package com.mmold.infrastructure.endpoints.finch.api.app.interpreters

import com.mmold.infrastructure.endpoints.finch.FinchIOEndpoint
import com.mmold.infrastructure.endpoints.finch.api.app.PageEndpointsAlgebra
import io.finch.Ok
import io.finch.catsEffect.{ get, path }
import org.fusesource.scalate.TemplateEngine

final class PageEndpointsInterpreter() extends PageEndpointsAlgebra[PageEndpointsInterpreter.Page] {

  import PageEndpointsInterpreter._

  val routes: FinchIOEndpoint[Page] = _indexEndpoint

  private val _folderName = "scalate"

  private val _engine = new TemplateEngine

  private def _renderTemplate(uri: String, state: Map[String, Any]): String = _engine.layout(_folderName ++ uri, state)

  def _indexEndpoint: FinchIOEndpoint[Page] = get("demo") {
    Ok(_renderTemplate("master.ssp", Map("title" -> "title")))
  }

}

object PageEndpointsInterpreter {

  type Page = String

  def apply: PageEndpointsInterpreter =
    new PageEndpointsInterpreter()

}