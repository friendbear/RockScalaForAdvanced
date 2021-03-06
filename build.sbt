ThisBuild / scalaVersion := "2.12.8"
ThisBuild / organization := "friendbear.github.com"


lazy val commonSettings = Seq(
  version := "0.1.0"
)

lazy val root = (project in file(".")).
  settings(
    name := "scala-advanced",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % "3.0.5",
      "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"
    )


    //libraryDependencies ++= ...以下略
  )

