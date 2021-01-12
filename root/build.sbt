name := "Hello"
version := "1.0"
scalaVersion := "2.12.12"
lazy val core = project.in(file("actor"))
  .settings(
    libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.10",
    libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.10",
    libraryDependencies += "com.typesafe.akka" %% "akka-persistence-typed" % "2.6.10",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.10" % Test,
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test
)dependsOn(util)

lazy val util = (project in file("common"))
  .settings(
    libraryDependencies += "io.github.embeddedkafka" %% "embedded-kafka" % "2.7.0" % Test,
    libraryDependencies += "com.softwaremill.sttp" %% "json4s" % "1.7.2",
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.3",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test,
    libraryDependencies += "org.mockito" %% "mockito-scala" % "1.16.13"
)
lazy val root = project.in(file(".")).aggregate(core, util)


