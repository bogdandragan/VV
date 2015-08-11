package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  import scala.slick.collection.heterogenous._
  import scala.slick.collection.heterogenous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Besuchsrapporte.ddl ++ Gespraechsinformationen.ddl ++ GespraechspartnerStammdaten.ddl ++ Kontaktperson.ddl ++ Laender.ddl ++ Sprache.ddl ++ Userstammdaten.ddl ++ Userstammdatenkontakt.ddl ++ UserstammdatenUsertyp.ddl ++ Usertyp.ddl ++ VerwaltungVermieterInfo.ddl ++ WohnobjectDictionary.ddl ++ WohnobjectState.ddl ++ Wohnobjekt.ddl

  /** Entity class storing rows of table Besuchsrapporte
    *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
    *  @param gespraechspartnerStammdatenId Database column gespraechspartner_stammdaten_id DBType(INT)
    *  @param userstammdatenId Database column userstammdaten_id DBType(INT)
    *  @param datum Database column datum DBType(DATETIME)
    *  @param memo Database column memo DBType(LONGTEXT), Length(2147483647,true)
    *  @param kooperationsvertrag Database column kooperationsvertrag DBType(TINYINT)
    *  @param nachsterBesuch Database column nachster_besuch DBType(DATE) */
  case class BesuchsrapporteRow(id: Int, gespraechspartnerStammdatenId: Int, userstammdatenId: Int, datum: java.sql.Timestamp, memo: String, kooperationsvertrag: Byte, nachsterBesuch: java.sql.Date)
  /** GetResult implicit for fetching BesuchsrapporteRow objects using plain SQL queries */
  implicit def GetResultBesuchsrapporteRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp], e2: GR[String], e3: GR[Byte], e4: GR[java.sql.Date]): GR[BesuchsrapporteRow] = GR{
    prs => import prs._
      BesuchsrapporteRow.tupled((<<[Int], <<[Int], <<[Int], <<[java.sql.Timestamp], <<[String], <<[Byte], <<[java.sql.Date]))
  }
  /** Table description of table besuchsrapporte. Objects of this class serve as prototypes for rows in queries. */
  class Besuchsrapporte(_tableTag: Tag) extends Table[BesuchsrapporteRow](_tableTag, "besuchsrapporte") {
    def * = (id, gespraechspartnerStammdatenId, userstammdatenId, datum, memo, kooperationsvertrag, nachsterBesuch) <> (BesuchsrapporteRow.tupled, BesuchsrapporteRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, gespraechspartnerStammdatenId.?, userstammdatenId.?, datum.?, memo.?, kooperationsvertrag.?, nachsterBesuch.?).shaped.<>({r=>import r._; _1.map(_=> BesuchsrapporteRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column gespraechspartner_stammdaten_id DBType(INT) */
    val gespraechspartnerStammdatenId: Column[Int] = column[Int]("gespraechspartner_stammdaten_id")
    /** Database column userstammdaten_id DBType(INT) */
    val userstammdatenId: Column[Int] = column[Int]("userstammdaten_id")
    /** Database column datum DBType(DATETIME) */
    val datum: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("datum")
    /** Database column memo DBType(LONGTEXT), Length(2147483647,true) */
    val memo: Column[String] = column[String]("memo", O.Length(2147483647,varying=true))
    /** Database column kooperationsvertrag DBType(TINYINT) */
    val kooperationsvertrag: Column[Byte] = column[Byte]("kooperationsvertrag")
    /** Database column nachster_besuch DBType(DATE) */
    val nachsterBesuch: Column[java.sql.Date] = column[java.sql.Date]("nachster_besuch")
  }
  /** Collection-like TableQuery object for table Besuchsrapporte */
  lazy val Besuchsrapporte = new TableQuery(tag => new Besuchsrapporte(tag))

  /** Entity class storing rows of table Gespraechsinformationen
    *  @param id Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey
    *  @param userstammdatenId Database column userstammdaten_id DBType(INT), Default(None)
    *  @param unterlagenversandId Database column unterlagenversand_id DBType(INT), Default(None)
    *  @param gespraechAm Database column gespraech_am DBType(DATETIME), Default(None)
    *  @param headline Database column headline DBType(VARCHAR), Length(255,true), Default(None)
    *  @param gespraechsinfos Database column gespraechsinfos DBType(TEXT), Length(65535,true), Default(None)
    *  @param prioritaet Database column prioritaet DBType(VARCHAR), Length(255,true), Default(None)
    *  @param gespraechspartnerStammdatenId Database column gespraechspartner_stammdaten_id DBType(INT), Default(None)
    *  @param vertragsdatenId Database column vertragsdaten_id DBType(INT), Default(None)
    *  @param userTime Database column user_time DBType(DATETIME), Default(None)
    *  @param inanspruchnahmeId Database column inanspruchnahme_id DBType(INT UNSIGNED), Default(None) */
  case class GespraechsinformationenRow(id: Int, userstammdatenId: Option[Int] = None, unterlagenversandId: Option[Int] = None, gespraechAm: Option[java.sql.Timestamp] = None, headline: Option[String] = None, gespraechsinfos: Option[String] = None, prioritaet: Option[String] = None, gespraechspartnerStammdatenId: Option[Int] = None, vertragsdatenId: Option[Int] = None, userTime: Option[java.sql.Timestamp] = None, inanspruchnahmeId: Option[Int] = None)
  /** GetResult implicit for fetching GespraechsinformationenRow objects using plain SQL queries */
  implicit def GetResultGespraechsinformationenRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[java.sql.Timestamp]], e3: GR[Option[String]]): GR[GespraechsinformationenRow] = GR{
    prs => import prs._
      GespraechsinformationenRow.tupled((<<[Int], <<?[Int], <<?[Int], <<?[java.sql.Timestamp], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[java.sql.Timestamp], <<?[Int]))
  }
  /** Table description of table gespraechsinformationen. Objects of this class serve as prototypes for rows in queries. */
  class Gespraechsinformationen(_tableTag: Tag) extends Table[GespraechsinformationenRow](_tableTag, "gespraechsinformationen") {
    def * = (id, userstammdatenId, unterlagenversandId, gespraechAm, headline, gespraechsinfos, prioritaet, gespraechspartnerStammdatenId, vertragsdatenId, userTime, inanspruchnahmeId) <> (GespraechsinformationenRow.tupled, GespraechsinformationenRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, userstammdatenId, unterlagenversandId, gespraechAm, headline, gespraechsinfos, prioritaet, gespraechspartnerStammdatenId, vertragsdatenId, userTime, inanspruchnahmeId).shaped.<>({r=>import r._; _1.map(_=> GespraechsinformationenRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column userstammdaten_id DBType(INT), Default(None) */
    val userstammdatenId: Column[Option[Int]] = column[Option[Int]]("userstammdaten_id", O.Default(None))
    /** Database column unterlagenversand_id DBType(INT), Default(None) */
    val unterlagenversandId: Column[Option[Int]] = column[Option[Int]]("unterlagenversand_id", O.Default(None))
    /** Database column gespraech_am DBType(DATETIME), Default(None) */
    val gespraechAm: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("gespraech_am", O.Default(None))
    /** Database column headline DBType(VARCHAR), Length(255,true), Default(None) */
    val headline: Column[Option[String]] = column[Option[String]]("headline", O.Length(255,varying=true), O.Default(None))
    /** Database column gespraechsinfos DBType(TEXT), Length(65535,true), Default(None) */
    val gespraechsinfos: Column[Option[String]] = column[Option[String]]("gespraechsinfos", O.Length(65535,varying=true), O.Default(None))
    /** Database column prioritaet DBType(VARCHAR), Length(255,true), Default(None) */
    val prioritaet: Column[Option[String]] = column[Option[String]]("prioritaet", O.Length(255,varying=true), O.Default(None))
    /** Database column gespraechspartner_stammdaten_id DBType(INT), Default(None) */
    val gespraechspartnerStammdatenId: Column[Option[Int]] = column[Option[Int]]("gespraechspartner_stammdaten_id", O.Default(None))
    /** Database column vertragsdaten_id DBType(INT), Default(None) */
    val vertragsdatenId: Column[Option[Int]] = column[Option[Int]]("vertragsdaten_id", O.Default(None))
    /** Database column user_time DBType(DATETIME), Default(None) */
    val userTime: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("user_time", O.Default(None))
    /** Database column inanspruchnahme_id DBType(INT UNSIGNED), Default(None) */
    val inanspruchnahmeId: Column[Option[Int]] = column[Option[Int]]("inanspruchnahme_id", O.Default(None))

    /** Index over (userstammdatenId) (database name userstammdaten_id) */
    val index1 = index("userstammdaten_id", userstammdatenId)
    /** Index over (vertragsdatenId) (database name vertragsdaten_id) */
    val index2 = index("vertragsdaten_id", vertragsdatenId)
  }
  /** Collection-like TableQuery object for table Gespraechsinformationen */
  lazy val Gespraechsinformationen = new TableQuery(tag => new Gespraechsinformationen(tag))

  /** Row type of table GespraechspartnerStammdaten */
  type GespraechspartnerStammdatenRow = HCons[Int,HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[java.sql.Date],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[java.sql.Timestamp],HCons[Option[java.sql.Timestamp],HCons[Option[Int],HCons[Option[Byte],HCons[String,HCons[String,HCons[Option[Byte],HCons[Option[Boolean],HCons[Option[String],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Boolean],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for GespraechspartnerStammdatenRow providing default values if available in the database schema. */
  def GespraechspartnerStammdatenRow(id: Int, anrede: Option[String] = None, titelId: Option[Int] = None, firma: Option[String] = None, vorname: Option[String] = None, nachname: Option[String] = None, klientelId: Option[Int] = None, strasse: Option[String] = None, plz: Option[String] = None, ort: Option[String] = None, postfach: Option[String] = None, vorwahlTelefon: Option[String] = None, telefon: Option[String] = None, vorwahlFax: Option[String] = None, fax: Option[String] = None, email: Option[String] = None, taetigkeitSeit: Option[java.sql.Date] = None, besonderheit: Option[String] = None, laenderId: Option[Int] = None, rollenId: Option[Int] = None, firstLogin: Option[java.sql.Timestamp] = None, lastLogin: Option[java.sql.Timestamp] = None, numberOfLogin: Option[Int] = None, userguide: Option[Byte] = None, username: String, pw: String, aktiv: Option[Byte] = None, geloescht: Option[Boolean] = None, nachrichtInfozeit: Option[String] = None, onlineredakteur: Option[Boolean] = None, outboundAufgaben: Option[Boolean] = None, businessAnmeldungen: Option[Boolean] = None, outboundVerwalter: Option[Boolean] = None, loginFehler: Option[Int] = Some(0), autoPasswort: Option[String] = None, partnerIdBeschraenkung: Option[String] = None, spracheId: Option[Int] = None, outboundAbrechnung: Option[Boolean] = None): GespraechspartnerStammdatenRow = {
    id :: anrede :: titelId :: firma :: vorname :: nachname :: klientelId :: strasse :: plz :: ort :: postfach :: vorwahlTelefon :: telefon :: vorwahlFax :: fax :: email :: taetigkeitSeit :: besonderheit :: laenderId :: rollenId :: firstLogin :: lastLogin :: numberOfLogin :: userguide :: username :: pw :: aktiv :: geloescht :: nachrichtInfozeit :: onlineredakteur :: outboundAufgaben :: businessAnmeldungen :: outboundVerwalter :: loginFehler :: autoPasswort :: partnerIdBeschraenkung :: spracheId :: outboundAbrechnung :: HNil
  }
  /** GetResult implicit for fetching GespraechspartnerStammdatenRow objects using plain SQL queries */
  implicit def GetResultGespraechspartnerStammdatenRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[java.sql.Date]], e4: GR[Option[java.sql.Timestamp]], e5: GR[Option[Byte]], e6: GR[String], e7: GR[Option[Boolean]]): GR[GespraechspartnerStammdatenRow] = GR{
    prs => import prs._
      <<[Int] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[java.sql.Date] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[java.sql.Timestamp] :: <<?[java.sql.Timestamp] :: <<?[Int] :: <<?[Byte] :: <<[String] :: <<[String] :: <<?[Byte] :: <<?[Boolean] :: <<?[String] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Boolean] :: HNil
  }
  /** Table description of table gespraechspartner_stammdaten. Objects of this class serve as prototypes for rows in queries. */
  class GespraechspartnerStammdaten(_tableTag: Tag) extends Table[GespraechspartnerStammdatenRow](_tableTag, "gespraechspartner_stammdaten") {
    def * = id :: anrede :: titelId :: firma :: vorname :: nachname :: klientelId :: strasse :: plz :: ort :: postfach :: vorwahlTelefon :: telefon :: vorwahlFax :: fax :: email :: taetigkeitSeit :: besonderheit :: laenderId :: rollenId :: firstLogin :: lastLogin :: numberOfLogin :: userguide :: username :: pw :: aktiv :: geloescht :: nachrichtInfozeit :: onlineredakteur :: outboundAufgaben :: businessAnmeldungen :: outboundVerwalter :: loginFehler :: autoPasswort :: partnerIdBeschraenkung :: spracheId :: outboundAbrechnung :: HNil

    /** Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column anrede DBType(VARCHAR), Length(255,true), Default(None) */
    val anrede: Column[Option[String]] = column[Option[String]]("anrede", O.Length(255,varying=true), O.Default(None))
    /** Database column titel_id DBType(INT UNSIGNED), Default(None) */
    val titelId: Column[Option[Int]] = column[Option[Int]]("titel_id", O.Default(None))
    /** Database column firma DBType(VARCHAR), Length(255,true), Default(None) */
    val firma: Column[Option[String]] = column[Option[String]]("firma", O.Length(255,varying=true), O.Default(None))
    /** Database column vorname DBType(VARCHAR), Length(255,true), Default(None) */
    val vorname: Column[Option[String]] = column[Option[String]]("vorname", O.Length(255,varying=true), O.Default(None))
    /** Database column nachname DBType(VARCHAR), Length(255,true), Default(None) */
    val nachname: Column[Option[String]] = column[Option[String]]("nachname", O.Length(255,varying=true), O.Default(None))
    /** Database column klientel_id DBType(INT UNSIGNED), Default(None) */
    val klientelId: Column[Option[Int]] = column[Option[Int]]("klientel_id", O.Default(None))
    /** Database column strasse DBType(VARCHAR), Length(255,true), Default(None) */
    val strasse: Column[Option[String]] = column[Option[String]]("strasse", O.Length(255,varying=true), O.Default(None))
    /** Database column plz DBType(VARCHAR), Length(255,true), Default(None) */
    val plz: Column[Option[String]] = column[Option[String]]("plz", O.Length(255,varying=true), O.Default(None))
    /** Database column ort DBType(VARCHAR), Length(255,true), Default(None) */
    val ort: Column[Option[String]] = column[Option[String]]("ort", O.Length(255,varying=true), O.Default(None))
    /** Database column postfach DBType(VARCHAR), Length(255,true), Default(None) */
    val postfach: Column[Option[String]] = column[Option[String]]("postfach", O.Length(255,varying=true), O.Default(None))
    /** Database column vorwahl_telefon DBType(VARCHAR), Length(255,true), Default(None) */
    val vorwahlTelefon: Column[Option[String]] = column[Option[String]]("vorwahl_telefon", O.Length(255,varying=true), O.Default(None))
    /** Database column telefon DBType(VARCHAR), Length(255,true), Default(None) */
    val telefon: Column[Option[String]] = column[Option[String]]("telefon", O.Length(255,varying=true), O.Default(None))
    /** Database column vorwahl_fax DBType(VARCHAR), Length(255,true), Default(None) */
    val vorwahlFax: Column[Option[String]] = column[Option[String]]("vorwahl_fax", O.Length(255,varying=true), O.Default(None))
    /** Database column fax DBType(VARCHAR), Length(255,true), Default(None) */
    val fax: Column[Option[String]] = column[Option[String]]("fax", O.Length(255,varying=true), O.Default(None))
    /** Database column email DBType(VARCHAR), Length(255,true), Default(None) */
    val email: Column[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
    /** Database column taetigkeit_seit DBType(DATE), Default(None) */
    val taetigkeitSeit: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("taetigkeit_seit", O.Default(None))
    /** Database column besonderheit DBType(VARCHAR), Length(255,true), Default(None) */
    val besonderheit: Column[Option[String]] = column[Option[String]]("besonderheit", O.Length(255,varying=true), O.Default(None))
    /** Database column laender_id DBType(INT UNSIGNED), Default(None) */
    val laenderId: Column[Option[Int]] = column[Option[Int]]("laender_id", O.Default(None))
    /** Database column rollen_id DBType(INT UNSIGNED), Default(None) */
    val rollenId: Column[Option[Int]] = column[Option[Int]]("rollen_id", O.Default(None))
    /** Database column first_login DBType(DATETIME), Default(None) */
    val firstLogin: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("first_login", O.Default(None))
    /** Database column last_login DBType(DATETIME), Default(None) */
    val lastLogin: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("last_login", O.Default(None))
    /** Database column number_of_login DBType(INT UNSIGNED), Default(None) */
    val numberOfLogin: Column[Option[Int]] = column[Option[Int]]("number_of_login", O.Default(None))
    /** Database column userguide DBType(TINYINT), Default(None) */
    val userguide: Column[Option[Byte]] = column[Option[Byte]]("userguide", O.Default(None))
    /** Database column username DBType(VARCHAR), Length(255,true) */
    val username: Column[String] = column[String]("username", O.Length(255,varying=true))
    /** Database column pw DBType(VARCHAR), Length(255,true) */
    val pw: Column[String] = column[String]("pw", O.Length(255,varying=true))
    /** Database column aktiv DBType(TINYINT), Default(None) */
    val aktiv: Column[Option[Byte]] = column[Option[Byte]]("aktiv", O.Default(None))
    /** Database column geloescht DBType(BIT), Default(None) */
    val geloescht: Column[Option[Boolean]] = column[Option[Boolean]]("geloescht", O.Default(None))
    /** Database column nachricht_infozeit DBType(VARCHAR), Length(255,true), Default(None) */
    val nachrichtInfozeit: Column[Option[String]] = column[Option[String]]("nachricht_infozeit", O.Length(255,varying=true), O.Default(None))
    /** Database column onlineredakteur DBType(BIT), Default(None) */
    val onlineredakteur: Column[Option[Boolean]] = column[Option[Boolean]]("onlineredakteur", O.Default(None))
    /** Database column outbound_aufgaben DBType(BIT), Default(None) */
    val outboundAufgaben: Column[Option[Boolean]] = column[Option[Boolean]]("outbound_aufgaben", O.Default(None))
    /** Database column business_anmeldungen DBType(BIT), Default(None) */
    val businessAnmeldungen: Column[Option[Boolean]] = column[Option[Boolean]]("business_anmeldungen", O.Default(None))
    /** Database column outbound_verwalter DBType(BIT), Default(None) */
    val outboundVerwalter: Column[Option[Boolean]] = column[Option[Boolean]]("outbound_verwalter", O.Default(None))
    /** Database column login_fehler DBType(INT UNSIGNED), Default(Some(0)) */
    val loginFehler: Column[Option[Int]] = column[Option[Int]]("login_fehler", O.Default(Some(0)))
    /** Database column auto_passwort DBType(VARCHAR), Length(255,true), Default(None) */
    val autoPasswort: Column[Option[String]] = column[Option[String]]("auto_passwort", O.Length(255,varying=true), O.Default(None))
    /** Database column partner_id_beschraenkung DBType(VARCHAR), Length(255,true), Default(None) */
    val partnerIdBeschraenkung: Column[Option[String]] = column[Option[String]]("partner_id_beschraenkung", O.Length(255,varying=true), O.Default(None))
    /** Database column sprache_id DBType(INT UNSIGNED), Default(None) */
    val spracheId: Column[Option[Int]] = column[Option[Int]]("sprache_id", O.Default(None))
    /** Database column outbound_abrechnung DBType(BIT), Default(None) */
    val outboundAbrechnung: Column[Option[Boolean]] = column[Option[Boolean]]("outbound_abrechnung", O.Default(None))

    /** Index over (laenderId) (database name laender_id) */
    val index1 = index("laender_id", laenderId :: HNil)
    /** Index over (rollenId) (database name rollen_id) */
    val index2 = index("rollen_id", rollenId :: HNil)
    /** Index over (titelId) (database name titel_id) */
    val index3 = index("titel_id", titelId :: HNil)
    /** Index over (username) (database name username) */
    val index4 = index("username", username :: HNil)
  }
  /** Collection-like TableQuery object for table GespraechspartnerStammdaten */
  lazy val GespraechspartnerStammdaten = new TableQuery(tag => new GespraechspartnerStammdaten(tag))

  /** Entity class storing rows of table Kontaktperson
    *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
    *  @param userstammdatenId Database column userstammdaten_id DBType(INT)
    *  @param verwalterVermieterId Database column verwalter_vermieter_id DBType(INT)
    *  @param function Database column function DBType(VARCHAR), Length(45,true) */
  case class KontaktpersonRow(id: Int, userstammdatenId: Int, verwalterVermieterId: Int, function: String)
  /** GetResult implicit for fetching KontaktpersonRow objects using plain SQL queries */
  implicit def GetResultKontaktpersonRow(implicit e0: GR[Int], e1: GR[String]): GR[KontaktpersonRow] = GR{
    prs => import prs._
      KontaktpersonRow.tupled((<<[Int], <<[Int], <<[Int], <<[String]))
  }
  /** Table description of table kontaktperson. Objects of this class serve as prototypes for rows in queries. */
  class Kontaktperson(_tableTag: Tag) extends Table[KontaktpersonRow](_tableTag, "kontaktperson") {
    def * = (id, userstammdatenId, verwalterVermieterId, function) <> (KontaktpersonRow.tupled, KontaktpersonRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, userstammdatenId.?, verwalterVermieterId.?, function.?).shaped.<>({r=>import r._; _1.map(_=> KontaktpersonRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column userstammdaten_id DBType(INT) */
    val userstammdatenId: Column[Int] = column[Int]("userstammdaten_id")
    /** Database column verwalter_vermieter_id DBType(INT) */
    val verwalterVermieterId: Column[Int] = column[Int]("verwalter_vermieter_id")
    /** Database column function DBType(VARCHAR), Length(45,true) */
    val function: Column[String] = column[String]("function", O.Length(45,varying=true))
  }
  /** Collection-like TableQuery object for table Kontaktperson */
  lazy val Kontaktperson = new TableQuery(tag => new Kontaktperson(tag))

  /** Entity class storing rows of table Laender
    *  @param id Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey
    *  @param laendername Database column laendername DBType(VARCHAR), Length(255,true), Default(Some())
    *  @param laenderkuerzel Database column laenderkuerzel DBType(VARCHAR), Length(10,true), Default(Some())
    *  @param staatsangehoerigkeit Database column staatsangehoerigkeit DBType(VARCHAR), Length(255,true), Default(None)
    *  @param eu Database column eu DBType(TINYINT), Default(Some(0))
    *  @param eu15 Database column eu15 DBType(TINYINT), Default(Some(0))
    *  @param fr Database column FR DBType(VARCHAR), Length(255,true), Default(None)
    *  @param it Database column IT DBType(VARCHAR), Length(255,true), Default(None)
    *  @param gb Database column GB DBType(VARCHAR), Length(255,true), Default(None)
    *  @param es Database column ES DBType(VARCHAR), Length(255,true), Default(None)
    *  @param tr Database column TR DBType(VARCHAR), Length(255,true), Default(None)
    *  @param ru Database column RU DBType(VARCHAR), Length(255,true), Default(None) */
  case class LaenderRow(id: Int, laendername: Option[String] = Some(""), laenderkuerzel: Option[String] = Some(""), staatsangehoerigkeit: Option[String] = None, eu: Option[Byte] = Some(0), eu15: Option[Byte] = Some(0), fr: Option[String] = None, it: Option[String] = None, gb: Option[String] = None, es: Option[String] = None, tr: Option[String] = None, ru: Option[String] = None)
  /** GetResult implicit for fetching LaenderRow objects using plain SQL queries */
  implicit def GetResultLaenderRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Byte]]): GR[LaenderRow] = GR{
    prs => import prs._
      LaenderRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[Byte], <<?[Byte], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table laender. Objects of this class serve as prototypes for rows in queries. */
  class Laender(_tableTag: Tag) extends Table[LaenderRow](_tableTag, "laender") {
    def * = (id, laendername, laenderkuerzel, staatsangehoerigkeit, eu, eu15, fr, it, gb, es, tr, ru) <> (LaenderRow.tupled, LaenderRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, laendername, laenderkuerzel, staatsangehoerigkeit, eu, eu15, fr, it, gb, es, tr, ru).shaped.<>({r=>import r._; _1.map(_=> LaenderRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column laendername DBType(VARCHAR), Length(255,true), Default(Some()) */
    val laendername: Column[Option[String]] = column[Option[String]]("laendername", O.Length(255,varying=true), O.Default(Some("")))
    /** Database column laenderkuerzel DBType(VARCHAR), Length(10,true), Default(Some()) */
    val laenderkuerzel: Column[Option[String]] = column[Option[String]]("laenderkuerzel", O.Length(10,varying=true), O.Default(Some("")))
    /** Database column staatsangehoerigkeit DBType(VARCHAR), Length(255,true), Default(None) */
    val staatsangehoerigkeit: Column[Option[String]] = column[Option[String]]("staatsangehoerigkeit", O.Length(255,varying=true), O.Default(None))
    /** Database column eu DBType(TINYINT), Default(Some(0)) */
    val eu: Column[Option[Byte]] = column[Option[Byte]]("eu", O.Default(Some(0)))
    /** Database column eu15 DBType(TINYINT), Default(Some(0)) */
    val eu15: Column[Option[Byte]] = column[Option[Byte]]("eu15", O.Default(Some(0)))
    /** Database column FR DBType(VARCHAR), Length(255,true), Default(None) */
    val fr: Column[Option[String]] = column[Option[String]]("FR", O.Length(255,varying=true), O.Default(None))
    /** Database column IT DBType(VARCHAR), Length(255,true), Default(None) */
    val it: Column[Option[String]] = column[Option[String]]("IT", O.Length(255,varying=true), O.Default(None))
    /** Database column GB DBType(VARCHAR), Length(255,true), Default(None) */
    val gb: Column[Option[String]] = column[Option[String]]("GB", O.Length(255,varying=true), O.Default(None))
    /** Database column ES DBType(VARCHAR), Length(255,true), Default(None) */
    val es: Column[Option[String]] = column[Option[String]]("ES", O.Length(255,varying=true), O.Default(None))
    /** Database column TR DBType(VARCHAR), Length(255,true), Default(None) */
    val tr: Column[Option[String]] = column[Option[String]]("TR", O.Length(255,varying=true), O.Default(None))
    /** Database column RU DBType(VARCHAR), Length(255,true), Default(None) */
    val ru: Column[Option[String]] = column[Option[String]]("RU", O.Length(255,varying=true), O.Default(None))

    /** Index over (laenderkuerzel) (database name laenderkuerzel) */
    val index1 = index("laenderkuerzel", laenderkuerzel)
    /** Index over (laendername) (database name laendername) */
    val index2 = index("laendername", laendername)
    /** Index over (staatsangehoerigkeit) (database name staatsangehoerigkeit) */
    val index3 = index("staatsangehoerigkeit", staatsangehoerigkeit)
  }
  /** Collection-like TableQuery object for table Laender */
  lazy val Laender = new TableQuery(tag => new Laender(tag))

  /** Entity class storing rows of table Sprache
    *  @param id Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey
    *  @param tag Database column tag DBType(VARCHAR), Length(40,true)
    *  @param name Database column name DBType(VARCHAR), Length(255,true)
    *  @param localized Database column localized DBType(BIT) */
  case class SpracheRow(id: Int, tag: String, name: String, localized: Boolean)
  /** GetResult implicit for fetching SpracheRow objects using plain SQL queries */
  implicit def GetResultSpracheRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[SpracheRow] = GR{
    prs => import prs._
      SpracheRow.tupled((<<[Int], <<[String], <<[String], <<[Boolean]))
  }
  /** Table description of table sprache. Objects of this class serve as prototypes for rows in queries. */
  class Sprache(_tableTag: Tag) extends Table[SpracheRow](_tableTag, "sprache") {
    def * = (id, tag, name, localized) <> (SpracheRow.tupled, SpracheRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, tag.?, name.?, localized.?).shaped.<>({r=>import r._; _1.map(_=> SpracheRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column tag DBType(VARCHAR), Length(40,true) */
    val tag: Column[String] = column[String]("tag", O.Length(40,varying=true))
    /** Database column name DBType(VARCHAR), Length(255,true) */
    val name: Column[String] = column[String]("name", O.Length(255,varying=true))
    /** Database column localized DBType(BIT) */
    val localized: Column[Boolean] = column[Boolean]("localized")

    /** Index over (tag) (database name tag) */
    val index1 = index("tag", tag)
  }
  /** Collection-like TableQuery object for table Sprache */
  lazy val Sprache = new TableQuery(tag => new Sprache(tag))

  /** Row type of table Userstammdaten */
  type UserstammdatenRow = HCons[Int,HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[java.sql.Date],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[String],HCons[Option[Boolean],HCons[Option[String],HCons[Option[java.sql.Date],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Byte],HCons[Option[Byte],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[java.sql.Date],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[java.sql.Timestamp],HCons[Option[Int],HCons[Option[String],HCons[Option[java.sql.Date],HCons[Option[String],HCons[Option[Boolean],HCons[Option[String],HCons[Option[Boolean],HCons[Option[String],HCons[Option[Boolean],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for UserstammdatenRow providing default values if available in the database schema. */
  def UserstammdatenRow(id: Int, anrede: Option[String] = None, titelId: Option[Int] = None, firma: Option[String] = None, cbiCrefoIdentnummer: Option[String] = None, gesellschaftsformenId: Option[String] = None, cbiCrefoRechtsformenId: Option[Int] = None, rechtsformSeit: Option[java.sql.Date] = None, vorname: Option[String] = None, nachname: Option[String] = None, strasse: Option[String] = None, hausnummer: Option[String] = None, postleitzahl: Option[String] = None, ort: Option[String] = None, postfach: Option[String] = None, vorwahlTelefon: Option[String] = None, telefon: Option[String] = None, vorwahlFax: Option[String] = None, fax: Option[String] = None, vorwahlMobilnummer: Option[String] = None, mobilnummer: Option[String] = None, email: Option[String] = None, webadresse: Option[String] = None, staatsangehoerigkeit: Option[String] = None, beruf: Option[String] = None, geburtsname: Option[String] = None, klientelId: Option[Int] = None, rollenId: Option[Int] = None, eingetragenAm: Option[java.sql.Timestamp] = None, pw: Option[String] = None, username: Option[String] = None, aktiv: Option[Boolean] = None, geworbenVon: Option[String] = None, geburtsdatum: Option[java.sql.Date] = None, geburtsort: Option[String] = None, laenderId: Option[Int] = None, kundennummer: Option[String] = None, hash: Option[String] = None, meldeadresseStrasse: Option[String] = None, meldeadresseHausnummer: Option[String] = None, meldeadressePlz: Option[String] = None, meldeadresseOrt: Option[String] = None, geloescht: Option[Byte] = None, dokumentePerPost: Option[Byte] = None, aufenthaltsbewilligung: Option[String] = None, hochschule: Option[String] = None, matrikelnummer: Option[String] = None, staatsangehoerigkeitKuerzel: Option[String] = None, handelsregisternummer: Option[String] = None, steuernummer: Option[String] = None, umsatzsteuerid: Option[String] = None, gruendungsdatum: Option[java.sql.Date] = None, branchenId: Option[Int] = None, sonstigeBranche: Option[String] = None, sprache: Option[String] = None, funktion: Option[String] = None, datenHash: Option[String] = None, quelle: Option[String] = None, keineWerbemails: Option[java.sql.Timestamp] = None, mergedWith: Option[Int] = None, amtsgericht: Option[String] = None, amtsgerichtDatum: Option[java.sql.Date] = None, gesellschafter: Option[String] = None, bestehenVerbundeneUnternehmen: Option[Boolean] = None, bvuFuerFolgende: Option[String] = None, bvuBereitsKautionsversicherung: Option[Boolean] = None, bvuBkFolgende: Option[String] = None, bestehenSonstigeKautionsversicherungen: Option[Boolean] = None, bskFolgende: Option[String] = None, kautionAnfrage: Option[String] = None, persoenlichesKreditlimit: Option[Int] = None, einkommenNetto: Option[Int] = None, insolvenz: Option[Boolean] = None, codenameAbacus: Option[String] = None): UserstammdatenRow = {
    id :: anrede :: titelId :: firma :: cbiCrefoIdentnummer :: gesellschaftsformenId :: cbiCrefoRechtsformenId :: rechtsformSeit :: vorname :: nachname :: strasse :: hausnummer :: postleitzahl :: ort :: postfach :: vorwahlTelefon :: telefon :: vorwahlFax :: fax :: vorwahlMobilnummer :: mobilnummer :: email :: webadresse :: staatsangehoerigkeit :: beruf :: geburtsname :: klientelId :: rollenId :: eingetragenAm :: pw :: username :: aktiv :: geworbenVon :: geburtsdatum :: geburtsort :: laenderId :: kundennummer :: hash :: meldeadresseStrasse :: meldeadresseHausnummer :: meldeadressePlz :: meldeadresseOrt :: geloescht :: dokumentePerPost :: aufenthaltsbewilligung :: hochschule :: matrikelnummer :: staatsangehoerigkeitKuerzel :: handelsregisternummer :: steuernummer :: umsatzsteuerid :: gruendungsdatum :: branchenId :: sonstigeBranche :: sprache :: funktion :: datenHash :: quelle :: keineWerbemails :: mergedWith :: amtsgericht :: amtsgerichtDatum :: gesellschafter :: bestehenVerbundeneUnternehmen :: bvuFuerFolgende :: bvuBereitsKautionsversicherung :: bvuBkFolgende :: bestehenSonstigeKautionsversicherungen :: bskFolgende :: kautionAnfrage :: persoenlichesKreditlimit :: einkommenNetto :: insolvenz :: codenameAbacus :: HNil
  }
  /** GetResult implicit for fetching UserstammdatenRow objects using plain SQL queries */
  implicit def GetResultUserstammdatenRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[java.sql.Date]], e4: GR[Option[java.sql.Timestamp]], e5: GR[Option[Boolean]], e6: GR[Option[Byte]]): GR[UserstammdatenRow] = GR{
    prs => import prs._
      <<[Int] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[java.sql.Date] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Boolean] :: <<?[String] :: <<?[java.sql.Date] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Byte] :: <<?[Byte] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[java.sql.Date] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[java.sql.Timestamp] :: <<?[Int] :: <<?[String] :: <<?[java.sql.Date] :: <<?[String] :: <<?[Boolean] :: <<?[String] :: <<?[Boolean] :: <<?[String] :: <<?[Boolean] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Boolean] :: <<?[String] :: HNil
  }
  /** Table description of table userstammdaten. Objects of this class serve as prototypes for rows in queries. */
  class Userstammdaten(_tableTag: Tag) extends Table[UserstammdatenRow](_tableTag, "userstammdaten") {
    def * = id :: anrede :: titelId :: firma :: cbiCrefoIdentnummer :: gesellschaftsformenId :: cbiCrefoRechtsformenId :: rechtsformSeit :: vorname :: nachname :: strasse :: hausnummer :: postleitzahl :: ort :: postfach :: vorwahlTelefon :: telefon :: vorwahlFax :: fax :: vorwahlMobilnummer :: mobilnummer :: email :: webadresse :: staatsangehoerigkeit :: beruf :: geburtsname :: klientelId :: rollenId :: eingetragenAm :: pw :: username :: aktiv :: geworbenVon :: geburtsdatum :: geburtsort :: laenderId :: kundennummer :: hash :: meldeadresseStrasse :: meldeadresseHausnummer :: meldeadressePlz :: meldeadresseOrt :: geloescht :: dokumentePerPost :: aufenthaltsbewilligung :: hochschule :: matrikelnummer :: staatsangehoerigkeitKuerzel :: handelsregisternummer :: steuernummer :: umsatzsteuerid :: gruendungsdatum :: branchenId :: sonstigeBranche :: sprache :: funktion :: datenHash :: quelle :: keineWerbemails :: mergedWith :: amtsgericht :: amtsgerichtDatum :: gesellschafter :: bestehenVerbundeneUnternehmen :: bvuFuerFolgende :: bvuBereitsKautionsversicherung :: bvuBkFolgende :: bestehenSonstigeKautionsversicherungen :: bskFolgende :: kautionAnfrage :: persoenlichesKreditlimit :: einkommenNetto :: insolvenz :: codenameAbacus :: HNil

    /** Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column anrede DBType(VARCHAR), Length(255,true), Default(None) */
    val anrede: Column[Option[String]] = column[Option[String]]("anrede", O.Length(255,varying=true), O.Default(None))
    /** Database column titel_id DBType(INT UNSIGNED), Default(None) */
    val titelId: Column[Option[Int]] = column[Option[Int]]("titel_id", O.Default(None))
    /** Database column firma DBType(VARCHAR), Length(255,true), Default(None) */
    val firma: Column[Option[String]] = column[Option[String]]("firma", O.Length(255,varying=true), O.Default(None))
    /** Database column cbi_crefo_identnummer DBType(VARCHAR), Length(255,true), Default(None) */
    val cbiCrefoIdentnummer: Column[Option[String]] = column[Option[String]]("cbi_crefo_identnummer", O.Length(255,varying=true), O.Default(None))
    /** Database column gesellschaftsformen_id DBType(VARCHAR), Length(255,true), Default(None) */
    val gesellschaftsformenId: Column[Option[String]] = column[Option[String]]("gesellschaftsformen_id", O.Length(255,varying=true), O.Default(None))
    /** Database column cbi_crefo_rechtsformen_id DBType(INT UNSIGNED), Default(None) */
    val cbiCrefoRechtsformenId: Column[Option[Int]] = column[Option[Int]]("cbi_crefo_rechtsformen_id", O.Default(None))
    /** Database column rechtsform_seit DBType(DATE), Default(None) */
    val rechtsformSeit: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("rechtsform_seit", O.Default(None))
    /** Database column vorname DBType(VARCHAR), Length(255,true), Default(None) */
    val vorname: Column[Option[String]] = column[Option[String]]("vorname", O.Length(255,varying=true), O.Default(None))
    /** Database column nachname DBType(VARCHAR), Length(255,true), Default(None) */
    val nachname: Column[Option[String]] = column[Option[String]]("nachname", O.Length(255,varying=true), O.Default(None))
    /** Database column strasse DBType(VARCHAR), Length(255,true), Default(None) */
    val strasse: Column[Option[String]] = column[Option[String]]("strasse", O.Length(255,varying=true), O.Default(None))
    /** Database column hausnummer DBType(VARCHAR), Length(50,true), Default(None) */
    val hausnummer: Column[Option[String]] = column[Option[String]]("hausnummer", O.Length(50,varying=true), O.Default(None))
    /** Database column postleitzahl DBType(VARCHAR), Length(50,true), Default(None) */
    val postleitzahl: Column[Option[String]] = column[Option[String]]("postleitzahl", O.Length(50,varying=true), O.Default(None))
    /** Database column ort DBType(VARCHAR), Length(255,true), Default(None) */
    val ort: Column[Option[String]] = column[Option[String]]("ort", O.Length(255,varying=true), O.Default(None))
    /** Database column postfach DBType(VARCHAR), Length(50,true), Default(None) */
    val postfach: Column[Option[String]] = column[Option[String]]("postfach", O.Length(50,varying=true), O.Default(None))
    /** Database column vorwahl_telefon DBType(VARCHAR), Length(10,true), Default(None) */
    val vorwahlTelefon: Column[Option[String]] = column[Option[String]]("vorwahl_telefon", O.Length(10,varying=true), O.Default(None))
    /** Database column telefon DBType(VARCHAR), Length(20,true), Default(None) */
    val telefon: Column[Option[String]] = column[Option[String]]("telefon", O.Length(20,varying=true), O.Default(None))
    /** Database column vorwahl_fax DBType(VARCHAR), Length(10,true), Default(None) */
    val vorwahlFax: Column[Option[String]] = column[Option[String]]("vorwahl_fax", O.Length(10,varying=true), O.Default(None))
    /** Database column fax DBType(VARCHAR), Length(20,true), Default(None) */
    val fax: Column[Option[String]] = column[Option[String]]("fax", O.Length(20,varying=true), O.Default(None))
    /** Database column vorwahl_mobilnummer DBType(VARCHAR), Length(10,true), Default(None) */
    val vorwahlMobilnummer: Column[Option[String]] = column[Option[String]]("vorwahl_mobilnummer", O.Length(10,varying=true), O.Default(None))
    /** Database column mobilnummer DBType(VARCHAR), Length(20,true), Default(None) */
    val mobilnummer: Column[Option[String]] = column[Option[String]]("mobilnummer", O.Length(20,varying=true), O.Default(None))
    /** Database column email DBType(VARCHAR), Length(255,true), Default(None) */
    val email: Column[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
    /** Database column webadresse DBType(VARCHAR), Length(255,true), Default(None) */
    val webadresse: Column[Option[String]] = column[Option[String]]("webadresse", O.Length(255,varying=true), O.Default(None))
    /** Database column staatsangehoerigkeit DBType(VARCHAR), Length(255,true), Default(None) */
    val staatsangehoerigkeit: Column[Option[String]] = column[Option[String]]("staatsangehoerigkeit", O.Length(255,varying=true), O.Default(None))
    /** Database column beruf DBType(VARCHAR), Length(255,true), Default(None) */
    val beruf: Column[Option[String]] = column[Option[String]]("beruf", O.Length(255,varying=true), O.Default(None))
    /** Database column geburtsname DBType(VARCHAR), Length(255,true), Default(None) */
    val geburtsname: Column[Option[String]] = column[Option[String]]("geburtsname", O.Length(255,varying=true), O.Default(None))
    /** Database column klientel_id DBType(INT UNSIGNED), Default(None) */
    val klientelId: Column[Option[Int]] = column[Option[Int]]("klientel_id", O.Default(None))
    /** Database column rollen_id DBType(INT UNSIGNED), Default(None) */
    val rollenId: Column[Option[Int]] = column[Option[Int]]("rollen_id", O.Default(None))
    /** Database column eingetragen_am DBType(DATETIME), Default(None) */
    val eingetragenAm: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("eingetragen_am", O.Default(None))
    /** Database column pw DBType(VARCHAR), Length(50,true), Default(None) */
    val pw: Column[Option[String]] = column[Option[String]]("pw", O.Length(50,varying=true), O.Default(None))
    /** Database column username DBType(VARCHAR), Length(50,true), Default(None) */
    val username: Column[Option[String]] = column[Option[String]]("username", O.Length(50,varying=true), O.Default(None))
    /** Database column aktiv DBType(BIT), Default(None) */
    val aktiv: Column[Option[Boolean]] = column[Option[Boolean]]("aktiv", O.Default(None))
    /** Database column geworben_von DBType(VARCHAR), Length(255,true), Default(None) */
    val geworbenVon: Column[Option[String]] = column[Option[String]]("geworben_von", O.Length(255,varying=true), O.Default(None))
    /** Database column geburtsdatum DBType(DATE), Default(None) */
    val geburtsdatum: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("geburtsdatum", O.Default(None))
    /** Database column geburtsort DBType(VARCHAR), Length(255,true), Default(None) */
    val geburtsort: Column[Option[String]] = column[Option[String]]("geburtsort", O.Length(255,varying=true), O.Default(None))
    /** Database column laender_id DBType(INT UNSIGNED), Default(None) */
    val laenderId: Column[Option[Int]] = column[Option[Int]]("laender_id", O.Default(None))
    /** Database column kundennummer DBType(VARCHAR), Length(255,true), Default(None) */
    val kundennummer: Column[Option[String]] = column[Option[String]]("kundennummer", O.Length(255,varying=true), O.Default(None))
    /** Database column hash DBType(VARCHAR), Length(255,true), Default(None) */
    val hash: Column[Option[String]] = column[Option[String]]("hash", O.Length(255,varying=true), O.Default(None))
    /** Database column meldeadresse_strasse DBType(VARCHAR), Length(255,true), Default(None) */
    val meldeadresseStrasse: Column[Option[String]] = column[Option[String]]("meldeadresse_strasse", O.Length(255,varying=true), O.Default(None))
    /** Database column meldeadresse_hausnummer DBType(VARCHAR), Length(255,true), Default(None) */
    val meldeadresseHausnummer: Column[Option[String]] = column[Option[String]]("meldeadresse_hausnummer", O.Length(255,varying=true), O.Default(None))
    /** Database column meldeadresse_plz DBType(VARCHAR), Length(255,true), Default(None) */
    val meldeadressePlz: Column[Option[String]] = column[Option[String]]("meldeadresse_plz", O.Length(255,varying=true), O.Default(None))
    /** Database column meldeadresse_ort DBType(VARCHAR), Length(255,true), Default(None) */
    val meldeadresseOrt: Column[Option[String]] = column[Option[String]]("meldeadresse_ort", O.Length(255,varying=true), O.Default(None))
    /** Database column geloescht DBType(TINYINT), Default(None) */
    val geloescht: Column[Option[Byte]] = column[Option[Byte]]("geloescht", O.Default(None))
    /** Database column dokumente_per_post DBType(TINYINT UNSIGNED), Default(None) */
    val dokumentePerPost: Column[Option[Byte]] = column[Option[Byte]]("dokumente_per_post", O.Default(None))
    /** Database column aufenthaltsbewilligung DBType(VARCHAR), Length(255,true), Default(None) */
    val aufenthaltsbewilligung: Column[Option[String]] = column[Option[String]]("aufenthaltsbewilligung", O.Length(255,varying=true), O.Default(None))
    /** Database column hochschule DBType(VARCHAR), Length(255,true), Default(None) */
    val hochschule: Column[Option[String]] = column[Option[String]]("hochschule", O.Length(255,varying=true), O.Default(None))
    /** Database column matrikelnummer DBType(VARCHAR), Length(255,true), Default(None) */
    val matrikelnummer: Column[Option[String]] = column[Option[String]]("matrikelnummer", O.Length(255,varying=true), O.Default(None))
    /** Database column staatsangehoerigkeit_kuerzel DBType(VARCHAR), Length(255,true), Default(None) */
    val staatsangehoerigkeitKuerzel: Column[Option[String]] = column[Option[String]]("staatsangehoerigkeit_kuerzel", O.Length(255,varying=true), O.Default(None))
    /** Database column handelsregisternummer DBType(VARCHAR), Length(255,true), Default(None) */
    val handelsregisternummer: Column[Option[String]] = column[Option[String]]("handelsregisternummer", O.Length(255,varying=true), O.Default(None))
    /** Database column steuernummer DBType(VARCHAR), Length(255,true), Default(None) */
    val steuernummer: Column[Option[String]] = column[Option[String]]("steuernummer", O.Length(255,varying=true), O.Default(None))
    /** Database column umsatzsteuerid DBType(VARCHAR), Length(255,true), Default(None) */
    val umsatzsteuerid: Column[Option[String]] = column[Option[String]]("umsatzsteuerid", O.Length(255,varying=true), O.Default(None))
    /** Database column gruendungsdatum DBType(DATE), Default(None) */
    val gruendungsdatum: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("gruendungsdatum", O.Default(None))
    /** Database column branchen_id DBType(INT), Default(None) */
    val branchenId: Column[Option[Int]] = column[Option[Int]]("branchen_id", O.Default(None))
    /** Database column sonstige_branche DBType(VARCHAR), Length(255,true), Default(None) */
    val sonstigeBranche: Column[Option[String]] = column[Option[String]]("sonstige_branche", O.Length(255,varying=true), O.Default(None))
    /** Database column sprache DBType(VARCHAR), Length(255,true), Default(None) */
    val sprache: Column[Option[String]] = column[Option[String]]("sprache", O.Length(255,varying=true), O.Default(None))
    /** Database column funktion DBType(VARCHAR), Length(255,true), Default(None) */
    val funktion: Column[Option[String]] = column[Option[String]]("funktion", O.Length(255,varying=true), O.Default(None))
    /** Database column daten_hash DBType(VARCHAR), Length(255,true), Default(None) */
    val datenHash: Column[Option[String]] = column[Option[String]]("daten_hash", O.Length(255,varying=true), O.Default(None))
    /** Database column quelle DBType(VARCHAR), Length(255,true), Default(None) */
    val quelle: Column[Option[String]] = column[Option[String]]("quelle", O.Length(255,varying=true), O.Default(None))
    /** Database column keine_werbemails DBType(DATETIME), Default(None) */
    val keineWerbemails: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("keine_werbemails", O.Default(None))
    /** Database column merged_with DBType(INT UNSIGNED), Default(None) */
    val mergedWith: Column[Option[Int]] = column[Option[Int]]("merged_with", O.Default(None))
    /** Database column amtsgericht DBType(VARCHAR), Length(255,true), Default(None) */
    val amtsgericht: Column[Option[String]] = column[Option[String]]("amtsgericht", O.Length(255,varying=true), O.Default(None))
    /** Database column amtsgericht_datum DBType(DATE), Default(None) */
    val amtsgerichtDatum: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("amtsgericht_datum", O.Default(None))
    /** Database column gesellschafter DBType(VARCHAR), Length(255,true), Default(None) */
    val gesellschafter: Column[Option[String]] = column[Option[String]]("gesellschafter", O.Length(255,varying=true), O.Default(None))
    /** Database column bestehen_verbundene_unternehmen DBType(BIT), Default(None) */
    val bestehenVerbundeneUnternehmen: Column[Option[Boolean]] = column[Option[Boolean]]("bestehen_verbundene_unternehmen", O.Default(None))
    /** Database column bvu_fuer_folgende DBType(VARCHAR), Length(255,true), Default(None) */
    val bvuFuerFolgende: Column[Option[String]] = column[Option[String]]("bvu_fuer_folgende", O.Length(255,varying=true), O.Default(None))
    /** Database column bvu_bereits_kautionsversicherung DBType(BIT), Default(None) */
    val bvuBereitsKautionsversicherung: Column[Option[Boolean]] = column[Option[Boolean]]("bvu_bereits_kautionsversicherung", O.Default(None))
    /** Database column bvu_bk_folgende DBType(VARCHAR), Length(255,true), Default(None) */
    val bvuBkFolgende: Column[Option[String]] = column[Option[String]]("bvu_bk_folgende", O.Length(255,varying=true), O.Default(None))
    /** Database column bestehen_sonstige_kautionsversicherungen DBType(BIT), Default(None) */
    val bestehenSonstigeKautionsversicherungen: Column[Option[Boolean]] = column[Option[Boolean]]("bestehen_sonstige_kautionsversicherungen", O.Default(None))
    /** Database column bsk_folgende DBType(VARCHAR), Length(255,true), Default(None) */
    val bskFolgende: Column[Option[String]] = column[Option[String]]("bsk_folgende", O.Length(255,varying=true), O.Default(None))
    /** Database column kaution_anfrage DBType(VARCHAR), Length(255,true), Default(None) */
    val kautionAnfrage: Column[Option[String]] = column[Option[String]]("kaution_anfrage", O.Length(255,varying=true), O.Default(None))
    /** Database column persoenliches_kreditlimit DBType(INT), Default(None) */
    val persoenlichesKreditlimit: Column[Option[Int]] = column[Option[Int]]("persoenliches_kreditlimit", O.Default(None))
    /** Database column einkommen_netto DBType(INT), Default(None) */
    val einkommenNetto: Column[Option[Int]] = column[Option[Int]]("einkommen_netto", O.Default(None))
    /** Database column insolvenz DBType(BIT), Default(None) */
    val insolvenz: Column[Option[Boolean]] = column[Option[Boolean]]("insolvenz", O.Default(None))
    /** Database column codename_abacus DBType(VARCHAR), Length(17,true), Default(None) */
    val codenameAbacus: Column[Option[String]] = column[Option[String]]("codename_abacus", O.Length(17,varying=true), O.Default(None))

    /** Index over (gesellschaftsformenId) (database name gesellschaftsformen_id) */
    val index1 = index("gesellschaftsformen_id", gesellschaftsformenId :: HNil)
    /** Index over (hash) (database name hash) */
    val index2 = index("hash", hash :: HNil)
    /** Index over (klientelId) (database name klientel_id) */
    val index3 = index("klientel_id", klientelId :: HNil)
    /** Index over (laenderId) (database name laender_id) */
    val index4 = index("laender_id", laenderId :: HNil)
    /** Index over (nachname) (database name nachname) */
    val index5 = index("nachname", nachname :: HNil)
    /** Index over (quelle) (database name quelle) */
    val index6 = index("quelle", quelle :: HNil)
    /** Index over (titelId) (database name titel_id) */
    val index7 = index("titel_id", titelId :: HNil)
    /** Index over (vorname,nachname) (database name vorname) */
    val index8 = index("vorname", vorname :: nachname :: HNil)
  }
  /** Collection-like TableQuery object for table Userstammdaten */
  lazy val Userstammdaten = new TableQuery(tag => new Userstammdaten(tag))

  /** Row type of table Userstammdatenkontakt */
  type UserstammdatenkontaktRow = HCons[Int,HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[java.sql.Date],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[java.sql.Timestamp],HCons[Option[String],HCons[Option[String],HCons[Option[Boolean],HCons[Option[String],HCons[Option[java.sql.Date],HCons[Option[String],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Byte],HCons[Option[Byte],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[java.sql.Date],HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[java.sql.Timestamp],HCons[Option[Int],HCons[Option[String],HCons[Option[java.sql.Date],HCons[Option[String],HCons[Option[Boolean],HCons[Option[String],HCons[Option[Boolean],HCons[Option[String],HCons[Option[Boolean],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[String],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for UserstammdatenkontaktRow providing default values if available in the database schema. */
  def UserstammdatenkontaktRow(id: Int, anrede: Option[String] = None, titelId: Option[Int] = None, firma: Option[String] = None, cbiCrefoIdentnummer: Option[String] = None, gesellschaftsformenId: Option[String] = None, cbiCrefoRechtsformenId: Option[Int] = None, rechtsformSeit: Option[java.sql.Date] = None, vorname: Option[String] = None, nachname: Option[String] = None, strasse: Option[String] = None, hausnummer: Option[String] = None, postleitzahl: Option[String] = None, ort: Option[String] = None, postfach: Option[String] = None, vorwahlTelefon: Option[String] = None, telefon: Option[String] = None, vorwahlFax: Option[String] = None, fax: Option[String] = None, vorwahlMobilnummer: Option[String] = None, mobilnummer: Option[String] = None, email: Option[String] = None, webadresse: Option[String] = None, staatsangehoerigkeit: Option[String] = None, beruf: Option[String] = None, geburtsname: Option[String] = None, klientelId: Option[Int] = None, rollenId: Option[Int] = None, eingetragenAm: Option[java.sql.Timestamp] = None, pw: Option[String] = None, username: Option[String] = None, aktiv: Option[Boolean] = None, geworbenVon: Option[String] = None, geburtsdatum: Option[java.sql.Date] = None, geburtsort: Option[String] = None, laenderId: Option[Int] = None, kundennummer: Option[String] = None, hash: Option[String] = None, meldeadresseStrasse: Option[String] = None, meldeadresseHausnummer: Option[String] = None, meldeadressePlz: Option[String] = None, meldeadresseOrt: Option[String] = None, geloescht: Option[Byte] = None, dokumentePerPost: Option[Byte] = None, aufenthaltsbewilligung: Option[String] = None, hochschule: Option[String] = None, matrikelnummer: Option[String] = None, staatsangehoerigkeitKuerzel: Option[String] = None, handelsregisternummer: Option[String] = None, steuernummer: Option[String] = None, umsatzsteuerid: Option[String] = None, gruendungsdatum: Option[java.sql.Date] = None, branchenId: Option[Int] = None, sonstigeBranche: Option[String] = None, sprache: Option[String] = None, funktion: Option[String] = None, datenHash: Option[String] = None, quelle: Option[String] = None, keineWerbemails: Option[java.sql.Timestamp] = None, mergedWith: Option[Int] = None, amtsgericht: Option[String] = None, amtsgerichtDatum: Option[java.sql.Date] = None, gesellschafter: Option[String] = None, bestehenVerbundeneUnternehmen: Option[Boolean] = None, bvuFuerFolgende: Option[String] = None, bvuBereitsKautionsversicherung: Option[Boolean] = None, bvuBkFolgende: Option[String] = None, bestehenSonstigeKautionsversicherungen: Option[Boolean] = None, bskFolgende: Option[String] = None, kautionAnfrage: Option[String] = None, persoenlichesKreditlimit: Option[Int] = None, einkommenNetto: Option[Int] = None, insolvenz: Option[Boolean] = None, codenameAbacus: Option[String] = None): UserstammdatenkontaktRow = {
    id :: anrede :: titelId :: firma :: cbiCrefoIdentnummer :: gesellschaftsformenId :: cbiCrefoRechtsformenId :: rechtsformSeit :: vorname :: nachname :: strasse :: hausnummer :: postleitzahl :: ort :: postfach :: vorwahlTelefon :: telefon :: vorwahlFax :: fax :: vorwahlMobilnummer :: mobilnummer :: email :: webadresse :: staatsangehoerigkeit :: beruf :: geburtsname :: klientelId :: rollenId :: eingetragenAm :: pw :: username :: aktiv :: geworbenVon :: geburtsdatum :: geburtsort :: laenderId :: kundennummer :: hash :: meldeadresseStrasse :: meldeadresseHausnummer :: meldeadressePlz :: meldeadresseOrt :: geloescht :: dokumentePerPost :: aufenthaltsbewilligung :: hochschule :: matrikelnummer :: staatsangehoerigkeitKuerzel :: handelsregisternummer :: steuernummer :: umsatzsteuerid :: gruendungsdatum :: branchenId :: sonstigeBranche :: sprache :: funktion :: datenHash :: quelle :: keineWerbemails :: mergedWith :: amtsgericht :: amtsgerichtDatum :: gesellschafter :: bestehenVerbundeneUnternehmen :: bvuFuerFolgende :: bvuBereitsKautionsversicherung :: bvuBkFolgende :: bestehenSonstigeKautionsversicherungen :: bskFolgende :: kautionAnfrage :: persoenlichesKreditlimit :: einkommenNetto :: insolvenz :: codenameAbacus :: HNil
  }
  /** GetResult implicit for fetching UserstammdatenkontaktRow objects using plain SQL queries */
  implicit def GetResultUserstammdatenkontaktRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[java.sql.Date]], e4: GR[Option[java.sql.Timestamp]], e5: GR[Option[Boolean]], e6: GR[Option[Byte]]): GR[UserstammdatenkontaktRow] = GR{
    prs => import prs._
      <<[Int] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[java.sql.Date] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[java.sql.Timestamp] :: <<?[String] :: <<?[String] :: <<?[Boolean] :: <<?[String] :: <<?[java.sql.Date] :: <<?[String] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Byte] :: <<?[Byte] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[java.sql.Date] :: <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[java.sql.Timestamp] :: <<?[Int] :: <<?[String] :: <<?[java.sql.Date] :: <<?[String] :: <<?[Boolean] :: <<?[String] :: <<?[Boolean] :: <<?[String] :: <<?[Boolean] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Boolean] :: <<?[String] :: HNil
  }
  /** Table description of table userstammdatenkontakt. Objects of this class serve as prototypes for rows in queries. */
  class Userstammdatenkontakt(_tableTag: Tag) extends Table[UserstammdatenkontaktRow](_tableTag, "userstammdatenkontakt") {
    def * = id :: anrede :: titelId :: firma :: cbiCrefoIdentnummer :: gesellschaftsformenId :: cbiCrefoRechtsformenId :: rechtsformSeit :: vorname :: nachname :: strasse :: hausnummer :: postleitzahl :: ort :: postfach :: vorwahlTelefon :: telefon :: vorwahlFax :: fax :: vorwahlMobilnummer :: mobilnummer :: email :: webadresse :: staatsangehoerigkeit :: beruf :: geburtsname :: klientelId :: rollenId :: eingetragenAm :: pw :: username :: aktiv :: geworbenVon :: geburtsdatum :: geburtsort :: laenderId :: kundennummer :: hash :: meldeadresseStrasse :: meldeadresseHausnummer :: meldeadressePlz :: meldeadresseOrt :: geloescht :: dokumentePerPost :: aufenthaltsbewilligung :: hochschule :: matrikelnummer :: staatsangehoerigkeitKuerzel :: handelsregisternummer :: steuernummer :: umsatzsteuerid :: gruendungsdatum :: branchenId :: sonstigeBranche :: sprache :: funktion :: datenHash :: quelle :: keineWerbemails :: mergedWith :: amtsgericht :: amtsgerichtDatum :: gesellschafter :: bestehenVerbundeneUnternehmen :: bvuFuerFolgende :: bvuBereitsKautionsversicherung :: bvuBkFolgende :: bestehenSonstigeKautionsversicherungen :: bskFolgende :: kautionAnfrage :: persoenlichesKreditlimit :: einkommenNetto :: insolvenz :: codenameAbacus :: HNil

    /** Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column anrede DBType(VARCHAR), Length(255,true), Default(None) */
    val anrede: Column[Option[String]] = column[Option[String]]("anrede", O.Length(255,varying=true), O.Default(None))
    /** Database column titel_id DBType(INT UNSIGNED), Default(None) */
    val titelId: Column[Option[Int]] = column[Option[Int]]("titel_id", O.Default(None))
    /** Database column firma DBType(VARCHAR), Length(255,true), Default(None) */
    val firma: Column[Option[String]] = column[Option[String]]("firma", O.Length(255,varying=true), O.Default(None))
    /** Database column cbi_crefo_identnummer DBType(VARCHAR), Length(255,true), Default(None) */
    val cbiCrefoIdentnummer: Column[Option[String]] = column[Option[String]]("cbi_crefo_identnummer", O.Length(255,varying=true), O.Default(None))
    /** Database column gesellschaftsformen_id DBType(VARCHAR), Length(255,true), Default(None) */
    val gesellschaftsformenId: Column[Option[String]] = column[Option[String]]("gesellschaftsformen_id", O.Length(255,varying=true), O.Default(None))
    /** Database column cbi_crefo_rechtsformen_id DBType(INT UNSIGNED), Default(None) */
    val cbiCrefoRechtsformenId: Column[Option[Int]] = column[Option[Int]]("cbi_crefo_rechtsformen_id", O.Default(None))
    /** Database column rechtsform_seit DBType(DATE), Default(None) */
    val rechtsformSeit: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("rechtsform_seit", O.Default(None))
    /** Database column vorname DBType(VARCHAR), Length(255,true), Default(None) */
    val vorname: Column[Option[String]] = column[Option[String]]("vorname", O.Length(255,varying=true), O.Default(None))
    /** Database column nachname DBType(VARCHAR), Length(255,true), Default(None) */
    val nachname: Column[Option[String]] = column[Option[String]]("nachname", O.Length(255,varying=true), O.Default(None))
    /** Database column strasse DBType(VARCHAR), Length(255,true), Default(None) */
    val strasse: Column[Option[String]] = column[Option[String]]("strasse", O.Length(255,varying=true), O.Default(None))
    /** Database column hausnummer DBType(VARCHAR), Length(50,true), Default(None) */
    val hausnummer: Column[Option[String]] = column[Option[String]]("hausnummer", O.Length(50,varying=true), O.Default(None))
    /** Database column postleitzahl DBType(VARCHAR), Length(50,true), Default(None) */
    val postleitzahl: Column[Option[String]] = column[Option[String]]("postleitzahl", O.Length(50,varying=true), O.Default(None))
    /** Database column ort DBType(VARCHAR), Length(255,true), Default(None) */
    val ort: Column[Option[String]] = column[Option[String]]("ort", O.Length(255,varying=true), O.Default(None))
    /** Database column postfach DBType(VARCHAR), Length(50,true), Default(None) */
    val postfach: Column[Option[String]] = column[Option[String]]("postfach", O.Length(50,varying=true), O.Default(None))
    /** Database column vorwahl_telefon DBType(VARCHAR), Length(10,true), Default(None) */
    val vorwahlTelefon: Column[Option[String]] = column[Option[String]]("vorwahl_telefon", O.Length(10,varying=true), O.Default(None))
    /** Database column telefon DBType(VARCHAR), Length(20,true), Default(None) */
    val telefon: Column[Option[String]] = column[Option[String]]("telefon", O.Length(20,varying=true), O.Default(None))
    /** Database column vorwahl_fax DBType(VARCHAR), Length(10,true), Default(None) */
    val vorwahlFax: Column[Option[String]] = column[Option[String]]("vorwahl_fax", O.Length(10,varying=true), O.Default(None))
    /** Database column fax DBType(VARCHAR), Length(20,true), Default(None) */
    val fax: Column[Option[String]] = column[Option[String]]("fax", O.Length(20,varying=true), O.Default(None))
    /** Database column vorwahl_mobilnummer DBType(VARCHAR), Length(10,true), Default(None) */
    val vorwahlMobilnummer: Column[Option[String]] = column[Option[String]]("vorwahl_mobilnummer", O.Length(10,varying=true), O.Default(None))
    /** Database column mobilnummer DBType(VARCHAR), Length(20,true), Default(None) */
    val mobilnummer: Column[Option[String]] = column[Option[String]]("mobilnummer", O.Length(20,varying=true), O.Default(None))
    /** Database column email DBType(VARCHAR), Length(255,true), Default(None) */
    val email: Column[Option[String]] = column[Option[String]]("email", O.Length(255,varying=true), O.Default(None))
    /** Database column webadresse DBType(VARCHAR), Length(255,true), Default(None) */
    val webadresse: Column[Option[String]] = column[Option[String]]("webadresse", O.Length(255,varying=true), O.Default(None))
    /** Database column staatsangehoerigkeit DBType(VARCHAR), Length(255,true), Default(None) */
    val staatsangehoerigkeit: Column[Option[String]] = column[Option[String]]("staatsangehoerigkeit", O.Length(255,varying=true), O.Default(None))
    /** Database column beruf DBType(VARCHAR), Length(255,true), Default(None) */
    val beruf: Column[Option[String]] = column[Option[String]]("beruf", O.Length(255,varying=true), O.Default(None))
    /** Database column geburtsname DBType(VARCHAR), Length(255,true), Default(None) */
    val geburtsname: Column[Option[String]] = column[Option[String]]("geburtsname", O.Length(255,varying=true), O.Default(None))
    /** Database column klientel_id DBType(INT UNSIGNED), Default(None) */
    val klientelId: Column[Option[Int]] = column[Option[Int]]("klientel_id", O.Default(None))
    /** Database column rollen_id DBType(INT UNSIGNED), Default(None) */
    val rollenId: Column[Option[Int]] = column[Option[Int]]("rollen_id", O.Default(None))
    /** Database column eingetragen_am DBType(DATETIME), Default(None) */
    val eingetragenAm: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("eingetragen_am", O.Default(None))
    /** Database column pw DBType(VARCHAR), Length(50,true), Default(None) */
    val pw: Column[Option[String]] = column[Option[String]]("pw", O.Length(50,varying=true), O.Default(None))
    /** Database column username DBType(VARCHAR), Length(50,true), Default(None) */
    val username: Column[Option[String]] = column[Option[String]]("username", O.Length(50,varying=true), O.Default(None))
    /** Database column aktiv DBType(BIT), Default(None) */
    val aktiv: Column[Option[Boolean]] = column[Option[Boolean]]("aktiv", O.Default(None))
    /** Database column geworben_von DBType(VARCHAR), Length(255,true), Default(None) */
    val geworbenVon: Column[Option[String]] = column[Option[String]]("geworben_von", O.Length(255,varying=true), O.Default(None))
    /** Database column geburtsdatum DBType(DATE), Default(None) */
    val geburtsdatum: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("geburtsdatum", O.Default(None))
    /** Database column geburtsort DBType(VARCHAR), Length(255,true), Default(None) */
    val geburtsort: Column[Option[String]] = column[Option[String]]("geburtsort", O.Length(255,varying=true), O.Default(None))
    /** Database column laender_id DBType(INT UNSIGNED), Default(None) */
    val laenderId: Column[Option[Int]] = column[Option[Int]]("laender_id", O.Default(None))
    /** Database column kundennummer DBType(VARCHAR), Length(255,true), Default(None) */
    val kundennummer: Column[Option[String]] = column[Option[String]]("kundennummer", O.Length(255,varying=true), O.Default(None))
    /** Database column hash DBType(VARCHAR), Length(255,true), Default(None) */
    val hash: Column[Option[String]] = column[Option[String]]("hash", O.Length(255,varying=true), O.Default(None))
    /** Database column meldeadresse_strasse DBType(VARCHAR), Length(255,true), Default(None) */
    val meldeadresseStrasse: Column[Option[String]] = column[Option[String]]("meldeadresse_strasse", O.Length(255,varying=true), O.Default(None))
    /** Database column meldeadresse_hausnummer DBType(VARCHAR), Length(255,true), Default(None) */
    val meldeadresseHausnummer: Column[Option[String]] = column[Option[String]]("meldeadresse_hausnummer", O.Length(255,varying=true), O.Default(None))
    /** Database column meldeadresse_plz DBType(VARCHAR), Length(255,true), Default(None) */
    val meldeadressePlz: Column[Option[String]] = column[Option[String]]("meldeadresse_plz", O.Length(255,varying=true), O.Default(None))
    /** Database column meldeadresse_ort DBType(VARCHAR), Length(255,true), Default(None) */
    val meldeadresseOrt: Column[Option[String]] = column[Option[String]]("meldeadresse_ort", O.Length(255,varying=true), O.Default(None))
    /** Database column geloescht DBType(TINYINT), Default(None) */
    val geloescht: Column[Option[Byte]] = column[Option[Byte]]("geloescht", O.Default(None))
    /** Database column dokumente_per_post DBType(TINYINT UNSIGNED), Default(None) */
    val dokumentePerPost: Column[Option[Byte]] = column[Option[Byte]]("dokumente_per_post", O.Default(None))
    /** Database column aufenthaltsbewilligung DBType(VARCHAR), Length(255,true), Default(None) */
    val aufenthaltsbewilligung: Column[Option[String]] = column[Option[String]]("aufenthaltsbewilligung", O.Length(255,varying=true), O.Default(None))
    /** Database column hochschule DBType(VARCHAR), Length(255,true), Default(None) */
    val hochschule: Column[Option[String]] = column[Option[String]]("hochschule", O.Length(255,varying=true), O.Default(None))
    /** Database column matrikelnummer DBType(VARCHAR), Length(255,true), Default(None) */
    val matrikelnummer: Column[Option[String]] = column[Option[String]]("matrikelnummer", O.Length(255,varying=true), O.Default(None))
    /** Database column staatsangehoerigkeit_kuerzel DBType(VARCHAR), Length(255,true), Default(None) */
    val staatsangehoerigkeitKuerzel: Column[Option[String]] = column[Option[String]]("staatsangehoerigkeit_kuerzel", O.Length(255,varying=true), O.Default(None))
    /** Database column handelsregisternummer DBType(VARCHAR), Length(255,true), Default(None) */
    val handelsregisternummer: Column[Option[String]] = column[Option[String]]("handelsregisternummer", O.Length(255,varying=true), O.Default(None))
    /** Database column steuernummer DBType(VARCHAR), Length(255,true), Default(None) */
    val steuernummer: Column[Option[String]] = column[Option[String]]("steuernummer", O.Length(255,varying=true), O.Default(None))
    /** Database column umsatzsteuerid DBType(VARCHAR), Length(255,true), Default(None) */
    val umsatzsteuerid: Column[Option[String]] = column[Option[String]]("umsatzsteuerid", O.Length(255,varying=true), O.Default(None))
    /** Database column gruendungsdatum DBType(DATE), Default(None) */
    val gruendungsdatum: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("gruendungsdatum", O.Default(None))
    /** Database column branchen_id DBType(INT), Default(None) */
    val branchenId: Column[Option[Int]] = column[Option[Int]]("branchen_id", O.Default(None))
    /** Database column sonstige_branche DBType(VARCHAR), Length(255,true), Default(None) */
    val sonstigeBranche: Column[Option[String]] = column[Option[String]]("sonstige_branche", O.Length(255,varying=true), O.Default(None))
    /** Database column sprache DBType(VARCHAR), Length(255,true), Default(None) */
    val sprache: Column[Option[String]] = column[Option[String]]("sprache", O.Length(255,varying=true), O.Default(None))
    /** Database column funktion DBType(VARCHAR), Length(255,true), Default(None) */
    val funktion: Column[Option[String]] = column[Option[String]]("funktion", O.Length(255,varying=true), O.Default(None))
    /** Database column daten_hash DBType(VARCHAR), Length(255,true), Default(None) */
    val datenHash: Column[Option[String]] = column[Option[String]]("daten_hash", O.Length(255,varying=true), O.Default(None))
    /** Database column quelle DBType(VARCHAR), Length(255,true), Default(None) */
    val quelle: Column[Option[String]] = column[Option[String]]("quelle", O.Length(255,varying=true), O.Default(None))
    /** Database column keine_werbemails DBType(DATETIME), Default(None) */
    val keineWerbemails: Column[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("keine_werbemails", O.Default(None))
    /** Database column merged_with DBType(INT UNSIGNED), Default(None) */
    val mergedWith: Column[Option[Int]] = column[Option[Int]]("merged_with", O.Default(None))
    /** Database column amtsgericht DBType(VARCHAR), Length(255,true), Default(None) */
    val amtsgericht: Column[Option[String]] = column[Option[String]]("amtsgericht", O.Length(255,varying=true), O.Default(None))
    /** Database column amtsgericht_datum DBType(DATE), Default(None) */
    val amtsgerichtDatum: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("amtsgericht_datum", O.Default(None))
    /** Database column gesellschafter DBType(VARCHAR), Length(255,true), Default(None) */
    val gesellschafter: Column[Option[String]] = column[Option[String]]("gesellschafter", O.Length(255,varying=true), O.Default(None))
    /** Database column bestehen_verbundene_unternehmen DBType(BIT), Default(None) */
    val bestehenVerbundeneUnternehmen: Column[Option[Boolean]] = column[Option[Boolean]]("bestehen_verbundene_unternehmen", O.Default(None))
    /** Database column bvu_fuer_folgende DBType(VARCHAR), Length(255,true), Default(None) */
    val bvuFuerFolgende: Column[Option[String]] = column[Option[String]]("bvu_fuer_folgende", O.Length(255,varying=true), O.Default(None))
    /** Database column bvu_bereits_kautionsversicherung DBType(BIT), Default(None) */
    val bvuBereitsKautionsversicherung: Column[Option[Boolean]] = column[Option[Boolean]]("bvu_bereits_kautionsversicherung", O.Default(None))
    /** Database column bvu_bk_folgende DBType(VARCHAR), Length(255,true), Default(None) */
    val bvuBkFolgende: Column[Option[String]] = column[Option[String]]("bvu_bk_folgende", O.Length(255,varying=true), O.Default(None))
    /** Database column bestehen_sonstige_kautionsversicherungen DBType(BIT), Default(None) */
    val bestehenSonstigeKautionsversicherungen: Column[Option[Boolean]] = column[Option[Boolean]]("bestehen_sonstige_kautionsversicherungen", O.Default(None))
    /** Database column bsk_folgende DBType(VARCHAR), Length(255,true), Default(None) */
    val bskFolgende: Column[Option[String]] = column[Option[String]]("bsk_folgende", O.Length(255,varying=true), O.Default(None))
    /** Database column kaution_anfrage DBType(VARCHAR), Length(255,true), Default(None) */
    val kautionAnfrage: Column[Option[String]] = column[Option[String]]("kaution_anfrage", O.Length(255,varying=true), O.Default(None))
    /** Database column persoenliches_kreditlimit DBType(INT), Default(None) */
    val persoenlichesKreditlimit: Column[Option[Int]] = column[Option[Int]]("persoenliches_kreditlimit", O.Default(None))
    /** Database column einkommen_netto DBType(INT), Default(None) */
    val einkommenNetto: Column[Option[Int]] = column[Option[Int]]("einkommen_netto", O.Default(None))
    /** Database column insolvenz DBType(BIT), Default(None) */
    val insolvenz: Column[Option[Boolean]] = column[Option[Boolean]]("insolvenz", O.Default(None))
    /** Database column codename_abacus DBType(VARCHAR), Length(17,true), Default(None) */
    val codenameAbacus: Column[Option[String]] = column[Option[String]]("codename_abacus", O.Length(17,varying=true), O.Default(None))

    /** Index over (gesellschaftsformenId) (database name gesellschaftsformen_id) */
    val index1 = index("gesellschaftsformen_id", gesellschaftsformenId :: HNil)
    /** Index over (hash) (database name hash) */
    val index2 = index("hash", hash :: HNil)
    /** Index over (klientelId) (database name klientel_id) */
    val index3 = index("klientel_id", klientelId :: HNil)
    /** Index over (laenderId) (database name laender_id) */
    val index4 = index("laender_id", laenderId :: HNil)
    /** Index over (nachname) (database name nachname) */
    val index5 = index("nachname", nachname :: HNil)
    /** Index over (quelle) (database name quelle) */
    val index6 = index("quelle", quelle :: HNil)
    /** Index over (titelId) (database name titel_id) */
    val index7 = index("titel_id", titelId :: HNil)
    /** Index over (vorname,nachname) (database name vorname) */
    val index8 = index("vorname", vorname :: nachname :: HNil)
  }
  /** Collection-like TableQuery object for table Userstammdatenkontakt */
  lazy val Userstammdatenkontakt = new TableQuery(tag => new Userstammdatenkontakt(tag))

  /** Entity class storing rows of table UserstammdatenUsertyp
    *  @param id Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey
    *  @param userstammdatenId Database column userstammdaten_id DBType(INT), Default(None)
    *  @param usertypId Database column usertyp_id DBType(INT), Default(None) */
  case class UserstammdatenUsertypRow(id: Int, userstammdatenId: Option[Int] = None, usertypId: Option[Int] = None)
  /** GetResult implicit for fetching UserstammdatenUsertypRow objects using plain SQL queries */
  implicit def GetResultUserstammdatenUsertypRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[UserstammdatenUsertypRow] = GR{
    prs => import prs._
      UserstammdatenUsertypRow.tupled((<<[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table userstammdaten_usertyp. Objects of this class serve as prototypes for rows in queries. */
  class UserstammdatenUsertyp(_tableTag: Tag) extends Table[UserstammdatenUsertypRow](_tableTag, "userstammdaten_usertyp") {
    def * = (id, userstammdatenId, usertypId) <> (UserstammdatenUsertypRow.tupled, UserstammdatenUsertypRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, userstammdatenId, usertypId).shaped.<>({r=>import r._; _1.map(_=> UserstammdatenUsertypRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column userstammdaten_id DBType(INT), Default(None) */
    val userstammdatenId: Column[Option[Int]] = column[Option[Int]]("userstammdaten_id", O.Default(None))
    /** Database column usertyp_id DBType(INT), Default(None) */
    val usertypId: Column[Option[Int]] = column[Option[Int]]("usertyp_id", O.Default(None))

    /** Index over (userstammdatenId,usertypId) (database name userstammdaten_id) */
    val index1 = index("userstammdaten_id", (userstammdatenId, usertypId))
  }
  /** Collection-like TableQuery object for table UserstammdatenUsertyp */
  lazy val UserstammdatenUsertyp = new TableQuery(tag => new UserstammdatenUsertyp(tag))

  /** Entity class storing rows of table Usertyp
    *  @param id Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey
    *  @param bezeichnung Database column bezeichnung DBType(VARCHAR), Length(255,true) */
  case class UsertypRow(id: Int, bezeichnung: String)
  /** GetResult implicit for fetching UsertypRow objects using plain SQL queries */
  implicit def GetResultUsertypRow(implicit e0: GR[Int], e1: GR[String]): GR[UsertypRow] = GR{
    prs => import prs._
      UsertypRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table usertyp. Objects of this class serve as prototypes for rows in queries. */
  class Usertyp(_tableTag: Tag) extends Table[UsertypRow](_tableTag, "usertyp") {
    def * = (id, bezeichnung) <> (UsertypRow.tupled, UsertypRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, bezeichnung.?).shaped.<>({r=>import r._; _1.map(_=> UsertypRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column bezeichnung DBType(VARCHAR), Length(255,true) */
    val bezeichnung: Column[String] = column[String]("bezeichnung", O.Length(255,varying=true))
  }
  /** Collection-like TableQuery object for table Usertyp */
  lazy val Usertyp = new TableQuery(tag => new Usertyp(tag))

  /** Entity class storing rows of table VerwaltungVermieterInfo
    *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
    *  @param userstammdatenId Database column userstammdaten_id DBType(INT)
    *  @param gespraechspartnerStammdatenId Database column gespraechspartner_stammdaten_id DBType(INT), Default(None)
    *  @param website Database column webSite DBType(VARCHAR), Length(100,true), Default(None)
    *  @param potencial Database column potencial DBType(INT), Default(None)
    *  @param linkHomepage Database column link_homepage DBType(TINYINT), Default(None)
    *  @param logoPartner Database column logo_partner DBType(TINYINT), Default(None)
    *  @param linkObject Database column link_object DBType(TINYINT), Default(None)
    *  @param antragsformular Database column antragsformular DBType(TINYINT), Default(None)
    *  @param erstvermietung Database column erstvermietung DBType(TINYINT), Default(None)
    *  @param logoZugestellt Database column logo_zugestellt DBType(DATE), Default(None)
    *  @param schnittstelleErwunscht Database column schnittstelle_erwunscht DBType(VARCHAR), Length(45,true), Default(None)
    *  @param bemerkungen Database column bemerkungen DBType(LONGTEXT), Length(2147483647,true), Default(None)
    *  @param plattform Database column plattform DBType(VARCHAR), Length(45,true), Default(None)
    *  @param schulungErwunscht Database column schulung_erwunscht DBType(TINYINT), Default(None)
    *  @param newsletterErwunscht Database column newsletter_erwunscht DBType(TINYINT), Default(None)
    *  @param zustellDatum Database column zustell_datum DBType(DATE), Default(None)
    *  @param antwortDatum Database column antwort_datum DBType(DATE), Default(None)
    *  @param kontaktId Database column kontakt_id DBType(INT), Default(None) */
  case class VerwaltungVermieterInfoRow(id: Int, userstammdatenId: Int, gespraechspartnerStammdatenId: Option[Int] = None, website: Option[String] = None, potencial: Option[Int] = None, linkHomepage: Option[Byte] = None, logoPartner: Option[Byte] = None, linkObject: Option[Byte] = None, antragsformular: Option[Byte] = None, erstvermietung: Option[Byte] = None, logoZugestellt: Option[java.sql.Date] = None, schnittstelleErwunscht: Option[String] = None, bemerkungen: Option[String] = None, plattform: Option[String] = None, schulungErwunscht: Option[Byte] = None, newsletterErwunscht: Option[Byte] = None, zustellDatum: Option[java.sql.Date] = None, antwortDatum: Option[java.sql.Date] = None, kontaktId: Option[Int] = None)
  /** GetResult implicit for fetching VerwaltungVermieterInfoRow objects using plain SQL queries */
  implicit def GetResultVerwaltungVermieterInfoRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]], e3: GR[Option[Byte]], e4: GR[Option[java.sql.Date]]): GR[VerwaltungVermieterInfoRow] = GR{
    prs => import prs._
      VerwaltungVermieterInfoRow.tupled((<<[Int], <<[Int], <<?[Int], <<?[String], <<?[Int], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[Byte], <<?[java.sql.Date], <<?[String], <<?[String], <<?[String], <<?[Byte], <<?[Byte], <<?[java.sql.Date], <<?[java.sql.Date], <<?[Int]))
  }
  /** Table description of table verwaltung_vermieter_info. Objects of this class serve as prototypes for rows in queries. */
  class VerwaltungVermieterInfo(_tableTag: Tag) extends Table[VerwaltungVermieterInfoRow](_tableTag, "verwaltung_vermieter_info") {
    def * = (id, userstammdatenId, gespraechspartnerStammdatenId, website, potencial, linkHomepage, logoPartner, linkObject, antragsformular, erstvermietung, logoZugestellt, schnittstelleErwunscht, bemerkungen, plattform, schulungErwunscht, newsletterErwunscht, zustellDatum, antwortDatum, kontaktId) <> (VerwaltungVermieterInfoRow.tupled, VerwaltungVermieterInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, userstammdatenId.?, gespraechspartnerStammdatenId, website, potencial, linkHomepage, logoPartner, linkObject, antragsformular, erstvermietung, logoZugestellt, schnittstelleErwunscht, bemerkungen, plattform, schulungErwunscht, newsletterErwunscht, zustellDatum, antwortDatum, kontaktId).shaped.<>({r=>import r._; _1.map(_=> VerwaltungVermieterInfoRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column userstammdaten_id DBType(INT) */
    val userstammdatenId: Column[Int] = column[Int]("userstammdaten_id")
    /** Database column gespraechspartner_stammdaten_id DBType(INT), Default(None) */
    val gespraechspartnerStammdatenId: Column[Option[Int]] = column[Option[Int]]("gespraechspartner_stammdaten_id", O.Default(None))
    /** Database column webSite DBType(VARCHAR), Length(100,true), Default(None) */
    val website: Column[Option[String]] = column[Option[String]]("webSite", O.Length(100,varying=true), O.Default(None))
    /** Database column potencial DBType(INT), Default(None) */
    val potencial: Column[Option[Int]] = column[Option[Int]]("potencial", O.Default(None))
    /** Database column link_homepage DBType(TINYINT), Default(None) */
    val linkHomepage: Column[Option[Byte]] = column[Option[Byte]]("link_homepage", O.Default(None))
    /** Database column logo_partner DBType(TINYINT), Default(None) */
    val logoPartner: Column[Option[Byte]] = column[Option[Byte]]("logo_partner", O.Default(None))
    /** Database column link_object DBType(TINYINT), Default(None) */
    val linkObject: Column[Option[Byte]] = column[Option[Byte]]("link_object", O.Default(None))
    /** Database column antragsformular DBType(TINYINT), Default(None) */
    val antragsformular: Column[Option[Byte]] = column[Option[Byte]]("antragsformular", O.Default(None))
    /** Database column erstvermietung DBType(TINYINT), Default(None) */
    val erstvermietung: Column[Option[Byte]] = column[Option[Byte]]("erstvermietung", O.Default(None))
    /** Database column logo_zugestellt DBType(DATE), Default(None) */
    val logoZugestellt: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("logo_zugestellt", O.Default(None))
    /** Database column schnittstelle_erwunscht DBType(VARCHAR), Length(45,true), Default(None) */
    val schnittstelleErwunscht: Column[Option[String]] = column[Option[String]]("schnittstelle_erwunscht", O.Length(45,varying=true), O.Default(None))
    /** Database column bemerkungen DBType(LONGTEXT), Length(2147483647,true), Default(None) */
    val bemerkungen: Column[Option[String]] = column[Option[String]]("bemerkungen", O.Length(2147483647,varying=true), O.Default(None))
    /** Database column plattform DBType(VARCHAR), Length(45,true), Default(None) */
    val plattform: Column[Option[String]] = column[Option[String]]("plattform", O.Length(45,varying=true), O.Default(None))
    /** Database column schulung_erwunscht DBType(TINYINT), Default(None) */
    val schulungErwunscht: Column[Option[Byte]] = column[Option[Byte]]("schulung_erwunscht", O.Default(None))
    /** Database column newsletter_erwunscht DBType(TINYINT), Default(None) */
    val newsletterErwunscht: Column[Option[Byte]] = column[Option[Byte]]("newsletter_erwunscht", O.Default(None))
    /** Database column zustell_datum DBType(DATE), Default(None) */
    val zustellDatum: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("zustell_datum", O.Default(None))
    /** Database column antwort_datum DBType(DATE), Default(None) */
    val antwortDatum: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("antwort_datum", O.Default(None))
    /** Database column kontakt_id DBType(INT), Default(None) */
    val kontaktId: Column[Option[Int]] = column[Option[Int]]("kontakt_id", O.Default(None))

    /** Index over (gespraechspartnerStammdatenId) (database name gespraechspartner_stammdaten_id) */
    val index1 = index("gespraechspartner_stammdaten_id", gespraechspartnerStammdatenId)
  }
  /** Collection-like TableQuery object for table VerwaltungVermieterInfo */
  lazy val VerwaltungVermieterInfo = new TableQuery(tag => new VerwaltungVermieterInfo(tag))

  /** Entity class storing rows of table WohnobjectDictionary
    *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
    *  @param strasse Database column strasse DBType(VARCHAR), Length(45,true)
    *  @param hausnummer Database column hausnummer DBType(VARCHAR), Length(45,true)
    *  @param otheInfoFields Database column othe_info_fields DBType(VARCHAR), Length(45,true)
    *  @param userstammdatenId Database column userstammdaten_id DBType(INT) */
  case class WohnobjectDictionaryRow(id: Int, strasse: String, hausnummer: String, otheInfoFields: String, userstammdatenId: Int)
  /** GetResult implicit for fetching WohnobjectDictionaryRow objects using plain SQL queries */
  implicit def GetResultWohnobjectDictionaryRow(implicit e0: GR[Int], e1: GR[String]): GR[WohnobjectDictionaryRow] = GR{
    prs => import prs._
      WohnobjectDictionaryRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Int]))
  }
  /** Table description of table wohnobject_dictionary. Objects of this class serve as prototypes for rows in queries. */
  class WohnobjectDictionary(_tableTag: Tag) extends Table[WohnobjectDictionaryRow](_tableTag, "wohnobject_dictionary") {
    def * = (id, strasse, hausnummer, otheInfoFields, userstammdatenId) <> (WohnobjectDictionaryRow.tupled, WohnobjectDictionaryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, strasse.?, hausnummer.?, otheInfoFields.?, userstammdatenId.?).shaped.<>({r=>import r._; _1.map(_=> WohnobjectDictionaryRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column strasse DBType(VARCHAR), Length(45,true) */
    val strasse: Column[String] = column[String]("strasse", O.Length(45,varying=true))
    /** Database column hausnummer DBType(VARCHAR), Length(45,true) */
    val hausnummer: Column[String] = column[String]("hausnummer", O.Length(45,varying=true))
    /** Database column othe_info_fields DBType(VARCHAR), Length(45,true) */
    val otheInfoFields: Column[String] = column[String]("othe_info_fields", O.Length(45,varying=true))
    /** Database column userstammdaten_id DBType(INT) */
    val userstammdatenId: Column[Int] = column[Int]("userstammdaten_id")
  }
  /** Collection-like TableQuery object for table WohnobjectDictionary */
  lazy val WohnobjectDictionary = new TableQuery(tag => new WohnobjectDictionary(tag))

  /** Entity class storing rows of table WohnobjectState
    *  @param id Database column id DBType(INT), AutoInc, PrimaryKey
    *  @param dateAdded Database column date_added DBType(DATETIME)
    *  @param miete Database column miete DBType(VARCHAR), Length(45,true)
    *  @param kaution Database column kaution DBType(VARCHAR), Length(45,true)
    *  @param etc Database column etc DBType(VARCHAR), Length(45,true)
    *  @param wohnobjectDictionaryId Database column wohnobject_dictionary_id DBType(INT) */
  case class WohnobjectStateRow(id: Int, dateAdded: java.sql.Timestamp, miete: String, kaution: String, etc: String, wohnobjectDictionaryId: Int)
  /** GetResult implicit for fetching WohnobjectStateRow objects using plain SQL queries */
  implicit def GetResultWohnobjectStateRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp], e2: GR[String]): GR[WohnobjectStateRow] = GR{
    prs => import prs._
      WohnobjectStateRow.tupled((<<[Int], <<[java.sql.Timestamp], <<[String], <<[String], <<[String], <<[Int]))
  }
  /** Table description of table wohnobject_state. Objects of this class serve as prototypes for rows in queries. */
  class WohnobjectState(_tableTag: Tag) extends Table[WohnobjectStateRow](_tableTag, "wohnobject_state") {
    def * = (id, dateAdded, miete, kaution, etc, wohnobjectDictionaryId) <> (WohnobjectStateRow.tupled, WohnobjectStateRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, dateAdded.?, miete.?, kaution.?, etc.?, wohnobjectDictionaryId.?).shaped.<>({r=>import r._; _1.map(_=> WohnobjectStateRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id DBType(INT), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column date_added DBType(DATETIME) */
    val dateAdded: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("date_added")
    /** Database column miete DBType(VARCHAR), Length(45,true) */
    val miete: Column[String] = column[String]("miete", O.Length(45,varying=true))
    /** Database column kaution DBType(VARCHAR), Length(45,true) */
    val kaution: Column[String] = column[String]("kaution", O.Length(45,varying=true))
    /** Database column etc DBType(VARCHAR), Length(45,true) */
    val etc: Column[String] = column[String]("etc", O.Length(45,varying=true))
    /** Database column wohnobject_dictionary_id DBType(INT) */
    val wohnobjectDictionaryId: Column[Int] = column[Int]("wohnobject_dictionary_id")
  }
  /** Collection-like TableQuery object for table WohnobjectState */
  lazy val WohnobjectState = new TableQuery(tag => new WohnobjectState(tag))

  /** Entity class storing rows of table Wohnobjekt
    *  @param id Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey
    *  @param strasse Database column strasse DBType(VARCHAR), Length(255,true), Default(None)
    *  @param hausnummer Database column hausnummer DBType(VARCHAR), Length(20,true), Default(None)
    *  @param postleitzahl Database column postleitzahl DBType(VARCHAR), Length(20,true), Default(None)
    *  @param ort Database column ort DBType(VARCHAR), Length(255,true), Default(None)
    *  @param quadratmeter Database column quadratmeter DBType(VARCHAR), Length(10,true), Default(None)
    *  @param wohnungsnummer Database column wohnungsnummer DBType(VARCHAR), Length(10,true), Default(None)
    *  @param zimmer Database column zimmer DBType(VARCHAR), Length(10,true), Default(None)
    *  @param lageId Database column lage_id DBType(INT UNSIGNED), Default(None)
    *  @param besonderheiten Database column besonderheiten DBType(VARCHAR), Length(255,true), Default(None)
    *  @param laenderId Database column laender_id DBType(INT), Default(None)
    *  @param miete Database column miete DBType(VARCHAR), Length(255,true), Default(None)
    *  @param nebenkosten Database column nebenkosten DBType(VARCHAR), Length(255,true), Default(None)
    *  @param etage Database column etage DBType(VARCHAR), Length(255,true), Default(None)
    *  @param kaution Database column kaution DBType(INT), Default(None)
    *  @param prozentsatz Database column prozentsatz DBType(FLOAT), Default(None)
    *  @param nutzungId Database column nutzung_id DBType(INT UNSIGNED), Default(None)
    *  @param sonstigeNutzung Database column sonstige_nutzung DBType(VARCHAR), Length(255,true), Default(None)
    *  @param geloescht Database column geloescht DBType(TINYINT), Default(None) */
  case class WohnobjektRow(id: Int, strasse: Option[String] = None, hausnummer: Option[String] = None, postleitzahl: Option[String] = None, ort: Option[String] = None, quadratmeter: Option[String] = None, wohnungsnummer: Option[String] = None, zimmer: Option[String] = None, lageId: Option[Int] = None, besonderheiten: Option[String] = None, laenderId: Option[Int] = None, miete: Option[String] = None, nebenkosten: Option[String] = None, etage: Option[String] = None, kaution: Option[Int] = None, prozentsatz: Option[Float] = None, nutzungId: Option[Int] = None, sonstigeNutzung: Option[String] = None, geloescht: Option[Byte] = None)
  /** GetResult implicit for fetching WohnobjektRow objects using plain SQL queries */
  implicit def GetResultWohnobjektRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[Float]], e4: GR[Option[Byte]]): GR[WohnobjektRow] = GR{
    prs => import prs._
      WohnobjektRow.tupled((<<[Int], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[Int], <<?[Float], <<?[Int], <<?[String], <<?[Byte]))
  }
  /** Table description of table wohnobjekt. Objects of this class serve as prototypes for rows in queries. */
  class Wohnobjekt(_tableTag: Tag) extends Table[WohnobjektRow](_tableTag, "wohnobjekt") {
    def * = (id, strasse, hausnummer, postleitzahl, ort, quadratmeter, wohnungsnummer, zimmer, lageId, besonderheiten, laenderId, miete, nebenkosten, etage, kaution, prozentsatz, nutzungId, sonstigeNutzung, geloescht) <> (WohnobjektRow.tupled, WohnobjektRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, strasse, hausnummer, postleitzahl, ort, quadratmeter, wohnungsnummer, zimmer, lageId, besonderheiten, laenderId, miete, nebenkosten, etage, kaution, prozentsatz, nutzungId, sonstigeNutzung, geloescht).shaped.<>({r=>import r._; _1.map(_=> WohnobjektRow.tupled((_1.get, _2, _3, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id DBType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column strasse DBType(VARCHAR), Length(255,true), Default(None) */
    val strasse: Column[Option[String]] = column[Option[String]]("strasse", O.Length(255,varying=true), O.Default(None))
    /** Database column hausnummer DBType(VARCHAR), Length(20,true), Default(None) */
    val hausnummer: Column[Option[String]] = column[Option[String]]("hausnummer", O.Length(20,varying=true), O.Default(None))
    /** Database column postleitzahl DBType(VARCHAR), Length(20,true), Default(None) */
    val postleitzahl: Column[Option[String]] = column[Option[String]]("postleitzahl", O.Length(20,varying=true), O.Default(None))
    /** Database column ort DBType(VARCHAR), Length(255,true), Default(None) */
    val ort: Column[Option[String]] = column[Option[String]]("ort", O.Length(255,varying=true), O.Default(None))
    /** Database column quadratmeter DBType(VARCHAR), Length(10,true), Default(None) */
    val quadratmeter: Column[Option[String]] = column[Option[String]]("quadratmeter", O.Length(10,varying=true), O.Default(None))
    /** Database column wohnungsnummer DBType(VARCHAR), Length(10,true), Default(None) */
    val wohnungsnummer: Column[Option[String]] = column[Option[String]]("wohnungsnummer", O.Length(10,varying=true), O.Default(None))
    /** Database column zimmer DBType(VARCHAR), Length(10,true), Default(None) */
    val zimmer: Column[Option[String]] = column[Option[String]]("zimmer", O.Length(10,varying=true), O.Default(None))
    /** Database column lage_id DBType(INT UNSIGNED), Default(None) */
    val lageId: Column[Option[Int]] = column[Option[Int]]("lage_id", O.Default(None))
    /** Database column besonderheiten DBType(VARCHAR), Length(255,true), Default(None) */
    val besonderheiten: Column[Option[String]] = column[Option[String]]("besonderheiten", O.Length(255,varying=true), O.Default(None))
    /** Database column laender_id DBType(INT), Default(None) */
    val laenderId: Column[Option[Int]] = column[Option[Int]]("laender_id", O.Default(None))
    /** Database column miete DBType(VARCHAR), Length(255,true), Default(None) */
    val miete: Column[Option[String]] = column[Option[String]]("miete", O.Length(255,varying=true), O.Default(None))
    /** Database column nebenkosten DBType(VARCHAR), Length(255,true), Default(None) */
    val nebenkosten: Column[Option[String]] = column[Option[String]]("nebenkosten", O.Length(255,varying=true), O.Default(None))
    /** Database column etage DBType(VARCHAR), Length(255,true), Default(None) */
    val etage: Column[Option[String]] = column[Option[String]]("etage", O.Length(255,varying=true), O.Default(None))
    /** Database column kaution DBType(INT), Default(None) */
    val kaution: Column[Option[Int]] = column[Option[Int]]("kaution", O.Default(None))
    /** Database column prozentsatz DBType(FLOAT), Default(None) */
    val prozentsatz: Column[Option[Float]] = column[Option[Float]]("prozentsatz", O.Default(None))
    /** Database column nutzung_id DBType(INT UNSIGNED), Default(None) */
    val nutzungId: Column[Option[Int]] = column[Option[Int]]("nutzung_id", O.Default(None))
    /** Database column sonstige_nutzung DBType(VARCHAR), Length(255,true), Default(None) */
    val sonstigeNutzung: Column[Option[String]] = column[Option[String]]("sonstige_nutzung", O.Length(255,varying=true), O.Default(None))
    /** Database column geloescht DBType(TINYINT), Default(None) */
    val geloescht: Column[Option[Byte]] = column[Option[Byte]]("geloescht", O.Default(None))

    /** Index over (laenderId) (database name laender_id) */
    val index1 = index("laender_id", laenderId)
    /** Index over (lageId) (database name lage_id) */
    val index2 = index("lage_id", lageId)
  }
  /** Collection-like TableQuery object for table Wohnobjekt */
  lazy val Wohnobjekt = new TableQuery(tag => new Wohnobjekt(tag))
}