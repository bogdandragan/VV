/**
 * Created by bogdan on 7/20/15.
 */
import scala.slick.codegen.SourceCodeGenerator
import scala.slick.driver.MySQLDriver
import scala.slick.driver.MySQLDriver.simple._

object MySQLPlayground {
  def main(args: Array[String]) {
    var db = Database.forURL("jdbc:mysql://192.168.1.247/champ_ch", user="bogdan",password="1qazxsw2",driver="com.mysql.jdbc.Driver")
    // fetch data model


    val model = db.withSession { implicit session =>
      val tables = (Seq("besuchsrapporte","wohnobject_state","wohnobject_dictionary","gespraechspartner_stammdaten","sprache", "laender", "usertyp","userstammdaten_usertyp","userstammdaten","userstammdatenkontakt","wohnobjekt","gespraechsinformationen","kontaktperson","verwaltung_vermieter_info"))
      val t = Option(MySQLDriver.defaultTables.filter(t => tables.contains(t.name.name)))
      MySQLDriver.profile.createModel(t) // you can filter specific tables here
    }

    // customize code generator
    val codegen = new SourceCodeGenerator(model) {

    }


    codegen.writeToFile("scala.slick.driver.MySQLDriver", "test/models", "Gen", "Tables")
  }
}