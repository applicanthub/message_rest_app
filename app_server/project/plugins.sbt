addSbtPlugin("io.spray" % "sbt-revolver" % "0.8.0")

addSbtPlugin("com.github.tkawachi" % "sbt-lock" % "0.5.0")

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.2")

addCompilerPlugin("org.spire-math" % "kind-projector" % "0.9.7" cross CrossVersion.binary)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

addSbtPlugin("org.scalatra.scalate" % "sbt-scalate-precompiler" % "1.8.0.1")