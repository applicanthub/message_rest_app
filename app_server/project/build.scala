import sbt._
import sbt.Keys._
import org.fusesource.scalate.ScalatePlugin._
import ScalateKeys._

/**
  * Build configuration.
  *
  * @see {{{
  *  https://scalate.github.io/scalate/documentation/user-guide.html
  *  https://github.com/scalate/scalate
  * }}}
  *
  * @author Nick Odumo Feb 2019
  */
object build extends Build {

  val templateSettings = scalateSettings ++ Seq(
    /**
      * Sets the behavior of recompiling template files.
      * Always template files are recompiled when this setting is true.
      * When you set it to false, they are recompiled only when the modified time of
      * a template file is newer than that of a scala file generated by compilation
      * or a compiled scala file corresponding to a template file doesn't exist yet.
      */
    scalateOverwrite := true,
    scalateTemplateConfig in Compile <<= (sourceDirectory in Compile) { base =>
      Seq(
        /**
          * A minimal template configuration example.
          * "scalate" is used as a package prefix(the 4th argument of TemplateConfig.apply)
          * if not specified.
          *
          * An example of a scalate usage is as bellow if you have templates/index.ssp.
          *
          * val engine = new TemplateEngine
          * engine.layout("/scalate/index.ssp")
          */
        TemplateConfig(
          base / "scalate",
          Nil,
          Nil,
          Some("scalate")
        )
      )
    }
  )

}
