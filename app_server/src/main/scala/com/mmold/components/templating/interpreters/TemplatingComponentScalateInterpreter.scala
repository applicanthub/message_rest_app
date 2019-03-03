package com.mmold.components.templating.interpreters

import cats.effect.IO
import com.mmold.components.templating.TemplatingComponentAlgebra
import org.fusesource.scalate.TemplateEngine
import TemplatingComponentScalateInterpreter._

/**
 * Template component based on scalate.
 *
 * @author Nick Odumo Feb 2019
 * @usecase Scalate templating
 * @param name Template name
 * @param state State to pass into template
 */
final class TemplatingComponentScalateInterpreter(
  engine: TemplateEngine,
  templateDirectoryPath: TemplateDirectoryPath) extends TemplatingComponentAlgebra[F, TemplateDirectoryPath, TemplateName, State, ScalateResult] {

  /**
   * Render template.
   *
   * @author Nick Odumo Feb 2019
   * @param name Template name
   * @param state State to pass into template
   */
  def render(name: TemplateName)(state: State): F[ScalateResult] =
    IO.delay(ScalateResult(engine.layout(templateDirectoryPath ++ "/" ++ name, state)))

}

object TemplatingComponentScalateInterpreter {

  type TemplateDirectoryPath = String

  type TemplateName = String

  type State = Map[String, Any]

  type F[A] = IO[A]

  def apply(engine: TemplateEngine, templateDirectoryPath: String): TemplatingComponentScalateInterpreter =
    new TemplatingComponentScalateInterpreter(engine, templateDirectoryPath)

  def default(templateEngine: TemplateEngine): TemplatingComponentScalateInterpreter =
    apply(templateEngine, templateDirectoryPath = "scalate")

}