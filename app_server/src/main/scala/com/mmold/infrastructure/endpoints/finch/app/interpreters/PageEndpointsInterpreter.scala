package com.mmold.infrastructure.endpoints.finch.app.interpreters

import com.mmold.infrastructure.endpoints.finch.FinchIOEndpoint
import com.mmold.infrastructure.endpoints.finch.app.PageEndpointsAlgebra
import io.finch.Ok
import io.finch.catsEffect.{ get, path }
import org.fusesource.scalate.TemplateEngine

final class PageEndpointsInterpreter extends PageEndpointsAlgebra[PageEndpointsInterpreter.Page] {

  import PageEndpointsInterpreter._

  val routes: FinchIOEndpoint[Page] = _indexEndpoint

  private val FOLDER = "scalate"

  private val engine = new TemplateEngine

  private def renderTemplate(uri: String, state: Map[String, Any]): String = engine.layout(FOLDER ++ uri, state)

  def _indexEndpoint: FinchIOEndpoint[Page] = get("demo") {
    Ok(renderTemplate("master.ssp", Map("title" -> "title")))
  }

}

object PageEndpointsInterpreter {

  type Page = String

  def apply: PageEndpointsInterpreter =
    new PageEndpointsInterpreter()

}