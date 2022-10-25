/*Used this video as base for learning scala https://www.youtube.com/watch?v=Yf-qgWG5hjQ*/

/*ThisBuild / scalaVersion := "2.12.6"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """ad-integration-template-v2""",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
    )
  )
*/
name := """ad-integration-template-v2"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.12.6"

libraryDependencies += jdbc
libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs
libraryDependencies += guice
libraryDependencies += javaForms

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.46",
  "org.mindrot" % "jbcrypt" % "0.3m",
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

//libraryDependencies += "com.zaxxer" % "HikariCP" % "3.4.5"
// https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
//libraryDependencies += "com.squareup.okhttp3" % "okhttp" % "4.10.0-RC1"