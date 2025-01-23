ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
    name := "AdventOfCode2024"
  )
root / libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "latest.integration" % Test
)
root / Test / scalacOptions ++= Seq(
  "-Yrangepos"
)
