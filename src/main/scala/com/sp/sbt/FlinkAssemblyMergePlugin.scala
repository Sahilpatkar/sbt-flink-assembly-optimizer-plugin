package com.sp.sbt

import sbt.*
import sbt.Keys.*
import sbt.plugins.JvmPlugin
import sbtassembly.AssemblyPlugin.autoImport._
object FlinkAssemblyMergePlugin extends AutoPlugin {

  override def trigger = allRequirements
  override def requires = JvmPlugin


  override lazy val projectSettings = Seq(
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs@_*) => MergeStrategy.discard // discard all META-INF files
      case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
      case PathList("META-INF", "io.netty.versions.properties") => MergeStrategy.first
      case PathList("META-INF", "versions", _@_*) => MergeStrategy.first
      case PathList("META-INF", "module-info.class") => MergeStrategy.first
      case PathList("META-INF", xs@_*) => MergeStrategy.first
      case PathList("META-INF", "spring.tooling") => MergeStrategy.first
      case "META-INF/DEPENDENCIES" => MergeStrategy.discard
      case "META-INF/LICENSE" | "META-INF/LICENSE.txt" | "META-INF/license" | "META-INF/NOTICE" | "META-INF/NOTICE.txt" =>
        MergeStrategy.discard
      case "META-INF/io.netty.versions.properties" => MergeStrategy.first
      case "META-INF/spring.tooling" => MergeStrategy.first
      case x if x.endsWith("reflect.properties") => MergeStrategy.first
      case x if x.endsWith("scala-collection-compat.properties") => MergeStrategy.first
      case x if x.endsWith(".properties") => MergeStrategy.first
      case x => MergeStrategy.first
    }
  )
}
