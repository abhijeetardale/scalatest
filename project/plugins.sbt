// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

val playVersion = scala.util.Properties.envOrElse("PLAY_VERSION", "2.5.14")

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % playVersion)

addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.3")

