
name := "sbt-flink-assembly-optimizer-plugin"
organization := "com.sp"
version := "0.2-SNAPSHOT"

sbtPlugin := true

// choose a test framework

// utest
//libraryDependencies += "com.lihaoyi" %% "utest" % "0.7.10" % "test"
//testFrameworks += new TestFramework("utest.runner.Framework")

// ScalaTest
//libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.9" % "test"
//libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % "test"

// Specs2
//libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.12.8" % "test")
//scalacOptions in Test ++= Seq("-Yrangepos")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "1.1.0")

inThisBuild(List(
  organization := "com.sp",
  homepage := Some(url("https://github.com/sbt/sbt-autoplugin.g8")),
  licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  developers := List(
    Developer(
      "sbt",
      "Sahil Patkar",
      "sahil.patkar72@gmail.com",
      url("https://scala-lang.org")
    )
  )
))

initialCommands in console := """import com.sp.sbt._"""

enablePlugins(ScriptedPlugin)
// set up 'scripted; sbt plugin for testing sbt plugins
scriptedLaunchOpts ++=
  Seq("-Xmx1024M", "-Dplugin.version=" + version.value)

//ThisBuild / githubWorkflowTargetTags ++= Seq("v*")
//ThisBuild / githubWorkflowPublishTargetBranches :=
//  Seq(RefPredicate.StartsWith(Ref.Tag("v")))
//
//ThisBuild / githubWorkflowPublish := Seq(
//  WorkflowStep.Sbt(
//    List("ci-release"),
//    env = Map(
//      "PGP_PASSPHRASE" -> "${{ secrets.PGP_PASSPHRASE }}",
//      "PGP_SECRET" -> "${{ secrets.PGP_SECRET }}",
//      "SONATYPE_PASSWORD" -> "${{ secrets.SONATYPE_PASSWORD }}",
//      "SONATYPE_USERNAME" -> "${{ secrets.SONATYPE_USERNAME }}"
//    )
//  )
//)

publishTo := Some("GitHub Packages" at "https://maven.pkg.github.com/Sahilpatkar/sbt-flink-assembly-optimizer-plugin")

credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  sys.env.getOrElse("GITHUB_ACTOR", ""),
  sys.env.getOrElse("GITHUB_TOKEN", "")
)


