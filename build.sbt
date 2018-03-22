name := "bitcoin-scala-rpc"

def base(project: Project): Project = project.settings(
  organization := "io.daonomic.bitcoin.rpc",
  bintrayOrganization := Some("daonomic"),
  bintrayPackageLabels := Seq("daonomic", "rpc", "scala", "bitcoin"),
  licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
  version := "0.1.1",
  scalaVersion := Versions.scala
)

def tests(project: Project): Project = project
  .settings(libraryDependencies += "org.scalatest" %% "scalatest" % Versions.scalatest % "test")
  .settings(libraryDependencies += "org.scalacheck" %% "scalacheck" % Versions.scalacheck % "test")
  .settings(libraryDependencies += "org.mockito" % "mockito-all" % Versions.mockito)

lazy val util = tests(base(project))

lazy val domain = tests(base(project))
  .dependsOn(util)

def common(project: Project): Project = base(project)
  .dependsOn(domain, `test-common` % "test")

lazy val `test-common` = base(project)
  .dependsOn(domain)

lazy val core = common(project)
  .dependsOn(util)

lazy val `core-mono` = common(project)
  .dependsOn(core)

lazy val listener = common(project)
  .dependsOn(core)

lazy val `listener-mono` = common(project)
  .dependsOn(listener, `core-mono`)

lazy val test = common(project)
  .dependsOn(util, listener)
  .settings(publish := {})

lazy val root = base(project in file("."))
  .settings(publish := {})
  .aggregate(util, domain, core, `core-mono`, listener, `listener-mono`, test)

