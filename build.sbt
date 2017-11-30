resolvers in ThisBuild ++= Seq("Apache Development Snapshot Repository" at "https://repository.apache.org/content/repositories/snapshots/",
  Resolver.mavenLocal)

name := "Flink Project"

version := "0.1-SNAPSHOT"

organization := "org.example"

scalaVersion in ThisBuild := "2.11.8"

scalacOptions ++= Seq(
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-unchecked",
  "-deprecation",
  "-Xfuture",
  "-Xlint:missing-interpolator",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Ywarn-dead-code",
  "-Ywarn-unused"
)

val flinkVersion = "1.3.2"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
resolvers += "Database Group Leipzig University" at "https://wdiserv1.informatik.uni-leipzig.de:443/archiva/repository/dbleipzig/"
libraryDependencies ++= Seq(
  //  base flink
  "org.apache.flink" %% "flink-scala" % flinkVersion % "provided",
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion % "provided",

  //  typesafe configuration
  "com.github.pureconfig" %% "pureconfig" % "0.8.0",

  // graph processing
  "org.gradoop" % "gradoop-flink" % "0.3.0-SNAPSHOT"
)


mainClass in assembly := Some("org.example.Job")

// make run command include the provided dependencies
fork := true
run in Compile := Defaults.runTask(fullClasspath in Compile, mainClass.in(
  Compile, run), runner.in(Compile, run))
  .evaluated

// exclude Scala library from assembly
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)


initialCommands in console :=
  """
    |import at.geoheil.graphDummy.utils.configuration.GraphDummyConfigurationClass
    |import at.geoheil.graphDummy.utils.configuration.configuration.ConfigurationUtils
    |import org.apache.flink.api.scala.ExecutionEnvironment
    |import org.slf4j.LoggerFactory
    |import org.apache.flink.streaming.api.scala._
    |
    |@transient lazy val LOG = LoggerFactory.getLogger("console")
    |val c = ConfigurationUtils.loadConfiguration[GraphDummyConfigurationClass]
    |val env = ConfigurationUtils.createFlinkExecutionEnvironment
  """.stripMargin