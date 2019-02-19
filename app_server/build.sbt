name := "app_server"
version := "0.1"
scalaVersion := "2.12.7"

lazy val root = project in file(".")

scalacOptions ++= SBTSettings.value

libraryDependencies ++= {
  val finchVersion = "0.26.0"
  val circeVersion = "0.10.1"
  val DoobieVersion          = "0.6.0"
  val scalatestVersion = "3.0.5"
  val finagleVersion = "19.1.0"
  Seq(
    "com.github.finagle" %% "finchx-core" % finchVersion,
    "com.github.finagle" %% "finchx-circe" % finchVersion,
    "com.github.finagle" %% "finch-argonaut" % finchVersion,
    "com.twitter" %% "finagle-http" % finagleVersion,
    "com.twitter" %% "finagle-mysql" % finagleVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-core" % circeVersion,
    "org.scalatest" %% "scalatest" % scalatestVersion % "test",
    "org.tpolecat" %% "doobie-core" % DoobieVersion,
    "org.tpolecat" %% "doobie-h2" % DoobieVersion,
    "org.tpolecat" %% "doobie-scalatest" % DoobieVersion,
    "org.tpolecat" %% "doobie-hikari" % DoobieVersion,
    "org.tpolecat" %% "doobie-postgres" % "0.6.0",
    "com.github.pureconfig" %% "pureconfig" % "0.10.2",
    "com.pauldijou" %% "jwt-core" % "2.0.0"
  )
}