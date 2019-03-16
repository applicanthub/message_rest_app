package com.mmold.components.templating.interpreters

import cats.effect.IO
import com.mmold.components.templating.TemplatingComponentAlgebra
import org.fusesource.scalate.TemplateEngine
import TemplatingComponentScalateInterpreter._

/**
 * Template component based on scalate.
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
   */
  def render(templateName: TemplateName)(state: State): F[Result] =
    IO.delay(
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

  private val _scalateDirectory: TemplateDirectoryPath = "scalate"

  def apply(engine: TemplateEngine)(templateDirectoryPath: TemplateDirectoryPath): TemplatingComponentScalateInterpreter =
    new TemplatingComponentScalateInterpreter(engine)(templateDirectoryPath)

  def defaultFromScalateDirectory(templateEngine: TemplateEngine): TemplatingComponentScalateInterpreter =
    apply(templateEngine)(_scalateDirectory)

}