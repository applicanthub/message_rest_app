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
  templateDirectoryPath: TemplateDirectoryPath) extends TemplatingComponentAlgebra[F, TemplateDirectoryPath, TemplateName, State, ResultObject] {

  // Template rendering engine
  private val engine = new TemplateEngine

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

  def apply(templateDirectoryPath: String): TemplatingComponentScalateInterpreters =
    new TemplatingComponentScalateInterpreters(templateDirectoryPath)

  def default: TemplatingComponentScalateInterpreters =
    apply(templateDirectoryPath = "scalate")

  final case class ResultObject(value: String)

}