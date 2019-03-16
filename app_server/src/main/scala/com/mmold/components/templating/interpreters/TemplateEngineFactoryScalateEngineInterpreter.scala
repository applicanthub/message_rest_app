package com.mmold.components.templating.interpreters

import com.mmold.components.templating.TemplateEngineFactoryAlgebra
import org.fusesource.scalate.TemplateEngine
import TemplateEngineFactoryScalateEngineInterpreter.{ From, To }

/**
 * Template engine factory.
 *
 * Example of how this kind of engine can be used:
 * {{{
 *   def tryTemplating = {
 *     val engine = new TemplateEngine
 *     val page = engine.layout(uri = "scalate/master.ssp", Map("title" -> "title"))
 *     println(page)
 *   }
 * }}}
 *
 * @author Nick Odumo Feb 2019
 */
final class TemplateEngineFactoryScalateEngineInterpreter private () extends TemplateEngineFactoryAlgebra[From, To] {

  def create(from: From): TemplateEngine = new TemplateEngine()

}

object TemplateEngineFactoryScalateEngineInterpreter {

  type From = Unit

  type To = TemplateEngine

  def apply: TemplateEngineFactoryScalateEngineInterpreter =
    new TemplateEngineFactoryScalateEngineInterpreter()

}