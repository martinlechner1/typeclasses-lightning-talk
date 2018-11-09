import Dependencies.{scalaTest, _}
import sbt.Keys.libraryDependencies

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "typeclasses",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += simulacrum

  )
