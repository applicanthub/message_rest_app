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
final class TemplatingComponentScalateInterpreter(engine: TemplateEngine)(templateDirectoryPath: TemplateDirectoryPath) extends TemplatingComponentAlgebra[F, TemplateDirectoryPath, TemplateName, State, Result] {

  /**
   * Render template.
   *
   * @author Nick Odumo Feb 2019
   * @param name Template name
   * @param state State to pass into template
   */
  def render(name: TemplateName)(state: State): F[Result] =
    IO.delay(ScalateResult(engine.layout(templateDirectoryPath ++ "/" ++ name, state)))

}

object TemplatingComponentScalateInterpreter {

  type TemplateDirectoryPath = String

  type TemplateName = String

  type State = Map[String, Any]

  type Result = ScalateResult

  type F[A] = IO[A]

  private val SCALATE_DIR: TemplateDirectoryPath = "scalate"

  def apply(engine: TemplateEngine)(templateDirectoryPath: TemplateDirectoryPath): TemplatingComponentScalateInterpreter =
    new TemplatingComponentScalateInterpreter(engine)(templateDirectoryPath)

  def default(templateEngine: TemplateEngine): TemplatingComponentScalateInterpreter =
    apply(templateEngine)(SCALATE_DIR)

}