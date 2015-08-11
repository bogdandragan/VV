package controllers

import models.Tables._
import play.api.db.slick._
import play.api.libs.json.{JsValue, Json, Writes}
import play.api.mvc._

import scala.slick.driver.MySQLDriver.simple._


object Search extends Controller {

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


  implicit val filterwriter = new Writes[(Int, Option[String], Option[String], String)] {
    def writes(t: (Int, Option[String], Option[String], String)): JsValue = {
      Json.obj("id"-> t._1, "vorname" -> t._2,"nachname" -> t._3, "bezeichnung"->t._4)
    }
  }
  //I changed the name of the def from filter to filteredBy to ease the
  //implicit conversion
  case class MaybeFilter[X, Y](val query: scala.slick.lifted.Query[X, Y, Seq]) {
    def filteredBy(op: Option[_])(f:(X) => Column[Option[Boolean]]) = {
      op map { o => MaybeFilter(query.filter(f)) } getOrElse { this }
    }
  }
  //Implicit conversion to the MaybeFilter in order to minimize ceremony
  implicit def maybeFilterConversor[X,Y](q:Query[X,Y,Seq]) = new MaybeFilter(q)

  def filter = DBAction { implicit request =>
    val json = request.body.asJson.get

    var land_id = (json \ "land").as[String]

    var vorname: Option[String] = Some((json \ "vorname").as[String])
    var nachname: Option[String] = Some((json \ "nachname").as[String])
    var plz : Option[String] = Some((json \ "plz").as[String])
    var ort : Option[String] = Some((json \ "ort").as[String])

    var id : Option[Int] = None
    if(land_id == ""){
      id = None
    }
    else{
      id = Some(land_id.toInt)
    }

   val result =  Userstammdaten
      .filteredBy(id){_.laenderId === id}
      .filteredBy(vorname){_.vorname like vorname.map("%" + _ + "%").getOrElse("")}
      .filteredBy(nachname){_.nachname like nachname.map("%" + _ + "%").getOrElse("")}
      .filteredBy(plz){_.postleitzahl like plz.map("%" + _ + "%").getOrElse("")}
      .filteredBy(ort){_.ort like ort.map("%" + _ + "%").getOrElse("")}
      .query.join(UserstammdatenUsertyp)
    .on(_.id === _.userstammdatenId).join(Usertyp)
    .on(_._2.usertypId === _.id).filter(p=>p._2.bezeichnung === "Vermieter" || p._2.bezeichnung === "Bürgschaftsbegünstigter")
    .map{case(p, a) =>(p._1.id, p._1.vorname, p._1.nachname, a.bezeichnung)}.list

    Ok(Json.toJson(result))
  }

  def toInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e: Exception => None
    }
  }

  def fastFilter = DBAction { implicit request =>
    val json = request.body.asJson.get

    var parameter = (json \ "parameter").as[String]
    val id = toInt(parameter)
    var typ : String = (json \ "type").as[String]

    if(typ == "vermieter"){
      val result =  Userstammdaten.filter(p=>p.id === id || p.vorname === parameter || p.nachname === parameter)
        .join(UserstammdatenUsertyp)
        .on(_.id === _.userstammdatenId).join(Usertyp)
        .on(_._2.usertypId === _.id).filter(p=>p._2.bezeichnung === "Vermieter")
        .map{case(p, a) =>(p._1.id, p._1.vorname, p._1.nachname, a.bezeichnung)}.list

      Ok(Json.toJson(result))
    }
    else if(typ == "verwalter"){
      val result =  Userstammdaten.filter(p=>p.id === id ||p.vorname === parameter || p.nachname === parameter)
        .join(UserstammdatenUsertyp)
        .on(_.id === _.userstammdatenId).join(Usertyp)
        .on(_._2.usertypId === _.id).filter(p=>p._2.bezeichnung === "Bürgschaftsbegünstigter")
        .map{case(p, a) =>(p._1.id, p._1.vorname, p._1.nachname, a.bezeichnung)}.list

      Ok(Json.toJson(result))
    }
    else if(typ == "alle") {
      val result =  Userstammdaten.filter(p=>p.id === id ||p.vorname === parameter || p.nachname === parameter)
        .join(UserstammdatenUsertyp)
        .on(_.id === _.userstammdatenId).join(Usertyp)
        .on(_._2.usertypId === _.id).filter(p=>p._2.bezeichnung === "Vermieter" || p._2.bezeichnung === "Bürgschaftsbegünstigter")
        .map{case(p, a) =>(p._1.id, p._1.vorname, p._1.nachname, a.bezeichnung)}.list

      Ok(Json.toJson(result))
    }
    else{
      Ok("")
    }

  }

  def addUser = DBAction{ implicit request =>
    val json = request.body.asJson.get

    val u_id = toInt((json\"uid").as[String])

    val user = VerwaltungVermieterInfo.filter(p=>p.userstammdatenId === u_id).list

    if(!user.nonEmpty){
      VerwaltungVermieterInfo.map(p=>(p.userstammdatenId)).insert(u_id.get)
      val response = Map("added"->"1")
      Ok(Json.toJson(response))
    }
    else{
      val response = Map("added"->"0")
      Ok(Json.toJson(response))
    }
  }

  def checkAdded = DBAction { implicit request =>
    val json = request.body.asJson.get

    val u_id = toInt((json\"uid").as[String])

    val user = VerwaltungVermieterInfo.filter(p=>p.userstammdatenId === u_id).list

    if(user.nonEmpty){
      VerwaltungVermieterInfo.map(p=>(p.userstammdatenId)).insert(u_id.get)
      val response = Map("added"->"1")
      Ok(Json.toJson(response))
    }
    else{
      val response = Map("added"->"0")
      Ok(Json.toJson(response))
    }
  }
}