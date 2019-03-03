package com.mmold.components.templating.interpreters

import cats.effect.IO
import com.mmold.components.templating.TemplatingComponentAlgebra
import org.fusesource.scalate.TemplateEngine
import TemplatingComponentScalateInterpreters._

/**
 * Template component based on scalate.
 *
 * @author Nick Odumo Feb 2019
 * @usecase Scalate templating
 * @param name Template name
 * @param state State to pass into template
 */
final class TemplatingComponentScalateInterpreters(
  engine: TemplateEngine,
  templateDirectoryPath: TemplateDirectoryPath) extends TemplatingComponentAlgebra[F, TemplateDirectoryPath, TemplateName, State, ResultObject] {

  /**
   * Render template.
   *
   * @author Nick Odumo Feb 2019
   * @param name Template name
   * @param state State to pass into template
   */
  def render(name: TemplateName)(state: State): F[ResultObject] =
    IO.delay(ResultObject(engine.layout(templateDirectoryPath ++ "/" ++ name, state)))

}

object TemplatingComponentScalateInterpreters {

  type TemplateDirectoryPath = String

  type TemplateName = String

  type State = Map[String, Any]

  type F[A] = IO[A]

  def apply(engine: TemplateEngine, templateDirectoryPath: String): TemplatingComponentScalateInterpreters =
    new TemplatingComponentScalateInterpreters(engine, templateDirectoryPath)

  def default(templateEngine: TemplateEngine): TemplatingComponentScalateInterpreters =
    apply(templateEngine, templateDirectoryPath = "scalate")

  final case class ResultObject(value: String)

}