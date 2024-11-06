
//{
//  val pluginVersion = System.getProperty("plugin.version")
//  if(pluginVersion == null)
//    throw new RuntimeException("""|The system property 'plugin.version' is not defined.
//                                  |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
//  else addSbtPlugin("com.sp" % """sbt-flink-assembly-merge-plugin""" % pluginVersion)
//}
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.1.5")

//resolvers += "GitHub Packages" at "https://maven.pkg.github.com/Sahilpatkar/sbt-flink-assembly-optimizer-plugin"
//
//addSbtPlugin("com.sp" % "sbt-flink-assembly-optimizer-plugin" % "0.2-SNAPSHOT")

//credentials += Credentials(
//  "GitHub Package Registry",
//  "maven.pkg.github.com",
//  "Sahilpatkar",
//  ""
//)