package controllers

import models.Tables._
import play.api.db.slick._
import play.api.libs.json.{JsValue, Writes, Json}
import play.api.mvc._
import scala.slick.driver.MySQLDriver.simple._


object Application extends Controller {

  def index = DBAction {

    Ok(views.html.index())
  }


  implicit val laenderwriter = new Writes[(Int, Option[String])] {
    def writes(t: (Int, Option[String])): JsValue = {
      Json.obj("id" -> t._1,"land"-> t._2)
    }
  }
  def fillLand = DBAction { implicit request =>
    val lands = Laender.map(l=>(l.id, l.laendername)).list

    Ok(Json.toJson(lands))
  }


  implicit val filterwriter = new Writes[(Int, Option[Int], Option[String], Option[String], String)] {
    def writes(t: (Int, Option[Int], Option[String], Option[String], String)): JsValue = {
      Json.obj("id"-> t._1, "laenderId"->t._2, "vorname" -> t._3,"nachname" -> t._4, "bezeichnung"->t._5)
    }
  }
  def filter = DBAction { implicit request =>
    val json = request.body.asJson.get

    var land_id: String = (json \ "land").as[String]

    var vorname = (json \ "vorname").as[String]
    var nachname = (json \ "nachname").as[String]
    var plz = (json \ "plz").as[String]
    var ort = (json \ "ort").as[String]

    if(land_id == ""){
      land_id = "-1"
    }
    if(vorname == ""){
      vorname = "-1"
    }
    if(nachname == ""){
      nachname = "-1"
    }
    if(plz == ""){
      plz = "-1"
    }
    if(ort == ""){
      ort = "-1"
    }

   // if(land_id == ""){
   //   result = Userstammdaten.filter(p=> p.vorname === vorname || p.nachname === nachname || p.postleitzahl === plz || p.ort === ort)
   // }s

    val result = Userstammdaten.filter(p=>p.laenderId === land_id.toInt || p.vorname === vorname || p.nachname === nachname || p.postleitzahl === plz || p.ort === ort).join(UserstammdatenUsertyp)
      .on(_.id === _.userstammdatenId).join(Usertyp)
      .on(_._2.usertypId === _.id).filter(p=>p._2.bezeichnung === "Vermieter" || p._2.bezeichnung === "Bürgschaftsbegünstigter")
      .map{case(p, a) =>(p._1.id, p._1.laenderId, p._1.vorname, p._1.nachname, a.bezeichnung)}.list


    Ok(Json.toJson(result))

  }
}