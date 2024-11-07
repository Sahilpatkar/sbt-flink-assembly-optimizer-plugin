
version := "0.1"
scalaVersion := "2.12.18"
name := "test-project"

val specs2Version = "4.20.6"
val flinkMajorVersion = "1.18"
val flinkMinorVersion = "1"
val flinkVersion = s"$flinkMajorVersion.$flinkMinorVersion"
val slf4jVersion = "2.0.12"
val logbackClassicVersion = "1.5.6"

lazy val commonFlinkDependencies = Seq(
  "org.apache.flink" % "flink-streaming-java" % flinkVersion,
  "org.apache.flink" % "flink-core" % flinkVersion,
  "org.apache.flink" % "flink-clients" % flinkVersion,
  "org.apache.flink" % "flink-table-api-java" % flinkVersion,
  "org.apache.flink" % "flink-table-api-java-bridge" % flinkVersion,
  "org.apache.flink" % "flink-table-common" % flinkVersion % Test,
  "org.apache.flink" % "flink-table-runtime" % flinkVersion % Test,
  "org.apache.flink" % "flink-table-planner-loader" % flinkVersion % Test,
  "org.apache.flink" %% "flink-scala" % "1.18.1",
  "org.flinkextended" %% "flink-scala-api" % s"${flinkVersion}_1.1.6",
  "org.apache.flink" % "flink-json" % "1.20.0",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.17.2",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.17.2"
)

lazy val flinkConnectorDependencies = Seq(
  "org.apache.flink" % "flink-connector-kafka" % s"3.1.0-$flinkMajorVersion",
  "org.apache.flink" % "flink-avro-confluent-registry" % "1.17.1",
  "io.confluent" % "kafka-avro-serializer" % "7.2.2",
  "io.confluent" % "kafka-schema-registry-client" % "7.2.2",
  "io.confluent" % "kafka-avro-serializer" % "7.2.2",
  "com.sksamuel.avro4s" %% "avro4s-kafka" % "4.1.2",

)

lazy val commonDependencies = Seq(
  "com.softwaremill.sttp.client3" %% "core" % "3.3.18",
  "io.circe" %% "circe-generic" % "0.14.1",
  "io.circe" %% "circe-parser" % "0.14.1",
  "io.circe" %% "circe-generic-extras" % "0.14.1")

libraryDependencies ++= commonFlinkDependencies ++ flinkConnectorDependencies ++ commonDependencies

val commonResolvers: Seq[MavenRepository] = Resolver.sonatypeOssRepos("releases") ++ Seq(
  "Confluent Repository".at("https://packages.confluent.io/maven/"),
  "Resolver mdsol Artifactory".at("https://mdsol.jfrog.io/mdsol/maven-preprod-virtual/"),
  Resolver.mavenLocal
)

resolvers := commonResolvers