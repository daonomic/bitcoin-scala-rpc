resolvers += Resolver.bintrayRepo("daonomic", "maven")

libraryDependencies += "io.daonomic.rpc" %% "transport-try" % Versions.scalaRpc
libraryDependencies += "org.scalatest" %% "scalatest" % Versions.scalatest
libraryDependencies += "org.scalacheck" %% "scalacheck" % Versions.scalacheck
libraryDependencies += "org.mockito" % "mockito-all" % Versions.mockito
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"