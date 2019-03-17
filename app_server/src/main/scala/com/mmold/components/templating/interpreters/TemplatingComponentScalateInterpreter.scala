package com.mmold.components.templating.interpreters

import cats.effect.IO
import com.mmold.components.templating.TemplatingComponentAlgebra
import org.fusesource.scalate.TemplateEngine
import TemplatingComponentScalateInterpreter.{ F, TemplateDirectoryPath, TemplateName, State, Result }

/**
 * Template component based on scalate.
 *
 * By convention:
 * {{{
 *  ThisClass.apply(_ ..., "scalate" :TemplatePath  ,_ ...)
 * }}}
 *
 * @author Nick Odumo Feb 2019
 * @param engine Engine
 * @param templateDirectoryPath Template directory
 */
final class TemplatingComponentScalateInterpreter private (
  engine: TemplateEngine)(
  templateDirectoryPath: TemplateDirectoryPath) extends TemplatingComponentAlgebra[F, TemplateDirectoryPath, TemplateName, State, Result] {

  /**
   * Build template URI.
   *
   * @author Nick Odumo Feb 2019
   * @param templateName Template name
   */
  private def _buildURI(templateName: TemplateName): String = s"$templateDirectoryPath/$templateName"

  /**
   * Render template.
   *
   * @author Nick Odumo Feb 2019
   * @param templateName Template name
   * @param state State to pass into template
   * @return Template within a container of sorts.
   */
  def render(templateName: TemplateName)(state: State): F[Result] =
    IO.delay( //  To be safe `Pure` let us suspend the function.
      ScalateResult(
        engine.layout(
          uri = _buildURI(templateName),
          attributes = state)))

}

object TemplatingComponentScalateInterpreter {

  type TemplateDirectoryPath = String

  type TemplateName = String

  type State = Map[String, Any]

  type Result = ScalateResult

  type F[A] = IO[A]

  def apply(
    engine: TemplateEngine)(
    templateDirectoryPath: TemplateDirectoryPath): TemplatingComponentScalateInterpreter =
    new TemplatingComponentScalateInterpreter(engine)(templateDirectoryPath)

}