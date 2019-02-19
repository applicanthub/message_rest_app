/**
  *  ____ ___  ____  _____    ____ _____ _   _ _____ ____     _  _____ ___  ____
  * / ___/ _ \|  _ \| ____|  / ___| ____| \ | | ____|  _ \   / \|_   _/ _ \|  _ \
  * | |  | | | | | | |  _|   | |  _|  _| |  \| |  _| | |_) | / _ \ | || | | | |_) |
  * | |__| |_| | |_| | |___  | |_| | |___| |\  | |___|  _ < / ___ \| || |_| |  _ <
  * \____\___/|____/|_____|  \____|_____|_| \_|_____|_| \_/_/   \_|_| \___/|_| \_\
  *

  */

/** Compiler options.
  *
  * @usecase Compiler plugins
  * @see https://tpolecat.github.io/2017/04/25/scalac-flags.html
  */
object SBTCompilerFlags {

  lazy val settings = Seq.apply(
    // Encoding
    "-encoding",
    // UTF-8 encoding
    "UTF-8",
    // Enable existential types
    "-language:existentials",
    // Enable higher kinded types
    "-language:higherKinds",
    // Enable implicit conversion
    "-language:implicitConversions",
    // Enable postfix ops
    "-language:postfixOps",
    // Cancel deprecated
    "-deprecation",
    // ???
    "-unchecked",
    // Emit optimised code
    "–optimise",
    // Emit warning and location for usages of deprecated APIs
    "-deprecation",
    // Emit warning and location for usages of features that should be imported explicitly
    "-feature",
    // Enable higher kinds
    "-language:higherKinds",
    // Enable additional warnings where generated code depends on assumptions
    "-unchecked",
    // Fail the compilation if there are any warnings
    // "-Xfatal-warnings",
    // Enable recommended additional warnings
    "-Xlint",
    //
    "-Xfuture",
    "-Ypartial-unification",
    //
    "-Yno-adapted-args"
   // Warn numeric widen
  /*  // Warn numeric widen
    "-Ywarn-numeric-widen",
    // Warn if an argument list is modified to match the receiver
    "-Ywarn-adapted-args",
    // Warn when dead code is identified
    "-Ywarn-dead-code",
    // Warn about inaccessible types in method signatures
    "-Ywarn-inaccessible",
    // Warn when non-nullify overrides nullify, e.g. def foo() over def foo
    "-Ywarn-nullary-override",
    // Warn when numeric are widened
    "-Ywarn-numeric-widen",
    // Warn when imports are unused
    "-Ywarn-unused-import"
    */
    )

}
