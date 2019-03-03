package com.mmold.components.templating.interpreters

import com.mmold.components.templating.TemplateEngineFactoryAlgebra
import org.fusesource.scalate.TemplateEngine
import TemplateEngineFactoryScalateEngineInterpreter.{ From, To }

final class TemplateEngineFactoryScalateEngineInterpreter extends TemplateEngineFactoryAlgebra[From, To] {

  def create(from: Unit): TemplateEngine = new TemplateEngine()

}

object TemplateEngineFactoryScalateEngineInterpreter {

  type From = Unit

  type To = TemplateEngine

  def apply: TemplateEngineFactoryScalateEngineInterpreter =
    new TemplateEngineFactoryScalateEngineInterpreter()

}