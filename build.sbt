lazy val commonSettings = Seq(
  name := """scalatest""",
  organization := "com.example",
  version := "1.0-SNAPSHOT",
  scalaVersion := "2.11.11",
  crossScalaVersions := Seq("2.10.6", "2.12.2"),
  libraryDependencies ++= Seq(cache, filters,
    "org.scalactic" %% "scalactic" % "3.0.4",
    "org.scalatest" %% "scalatest" % "3.0.4" % "test"
  ),
   routesGenerator := InjectedRoutesGenerator
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).enablePlugins(PlayScala)

