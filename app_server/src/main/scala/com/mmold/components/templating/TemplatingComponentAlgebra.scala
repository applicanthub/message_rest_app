package com.mmold.components.templating

/**
 * Templating component algebra.
 *
 * @author Nick Odumo March 2019
 * @tparam F Effect
 * @tparam TemplateDirectoryPath Template directory path
 * @tparam TemplateName Template name
 * @tparam State State
 * @tparam Result Result
 */
trait TemplatingComponentAlgebra[F[_], TemplateDirectoryPath, TemplateName, State, Result] {

  def render(name: TemplateName)(state: State): F[Result]

}
