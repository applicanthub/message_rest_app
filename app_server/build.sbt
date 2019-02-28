name := "app_server"
version := "0.1"
scalaVersion := "2.12.7"

lazy val root = project in file(".")

scalacOptions ++= SBTSettings.value

libraryDependencies ++= {
  val finchVersion = "0.26.0"
  val circeVersion = "0.10.1"
  val DoobieVersion = "0.6.0"
  val scalatestVersion = "3.0.5"
  val finagleVersion = "19.1.0"
  Seq(
    "com.devskiller" % "jfairy" % "0.6.2",
    "com.github.finagle" %% "finchx-core" % finchVersion,
    "com.github.finagle" %% "finchx-circe" % finchVersion,
    "com.github.finagle" %% "finch-argonaut" % finchVersion,
    "com.github.nscala-time" %% "nscala-time" % "2.22.0",
    "com.jakehschwartz"  % "finatra-swagger_2.12" %"18.4.0",
    "com.orientechnologies" % "orientdb-jdbc" % "3.0.4",
    "com.twitter" %% "finagle-http" % finagleVersion,
    "com.twitter" %% "finagle-mysql" % finagleVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-core" % circeVersion,
    "io.circe" %% "circe-parser" % circeVersion,
    "org.atnos" %% "eff" % "5.1.0",
    "org.atnos" %% "eff-cats-effect" % "5.1.0",
    "org.atnos" % "eff-twitter_2.12" % "5.1.0",
    "org.atnos" % "eff-macros_2.12" % "5.1.0",
    "org.atnos" % "eff-doobie_2.12" % "5.1.0",
    "org.specs2" %% "specs2-core" % "4.3.4" % "test",
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