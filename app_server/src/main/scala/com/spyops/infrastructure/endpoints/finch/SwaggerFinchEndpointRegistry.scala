package com.spyops.infrastructure.endpoints.finch

import com.jakehschwartz.finatra.swagger.{ FinatraSwagger, SwaggerController }
import com.spyops.configs.ServiceSwaggerConfig
import io.swagger.models.{ Operation, Swagger }

/**
 * Swagger Finch endpoint registry.
 *
 * @author Nick Odumo Feb 2019
 * @todo Possibly implement some sort of route accumulation object.
 *       This kind of object would greatly assist in revealing which endpoint have been registered.
 * @param swagger Swagger reference0
 */
class SwaggerFinchEndpointRegistry(config: ServiceSwaggerConfig)(implicit val swagger: Swagger) extends SwaggerController {

  /**
   * Define swagger route.
   *
   * @author Nick Odumo Feb 2019
   * @param relativePath Relative route path
   * @param httpMethod HTTP method
   * @param doc Application documentation
   */
  def defineRouteSwagger(
    relativePath: String,
    httpMethod: String)(doc: Operation => Operation): Unit =
    registerOperation(relativePath, httpMethod)(doc)

  /**
   * Register swagger route.
   *
   * @author Nick Odumo Feb 2019
   * @param relativePath Relative route path
   * @param httpMethod HTTP method
   * @param doc Application documentation
   */
  private def registerOperation(relativePath: String, httpMethod: String)(doc: Operation => Operation): Unit = {
    val _ = FinatraSwagger
      .convert(swagger)
      .registerOperation(absoluteRoute(relativePath), httpMethod, doc(new Operation))
  }

  /**
   * Determine absolute path.
   *
   * @author Nick Odumo Feb 2019
   * @param relativePath Path
   */
  private def absoluteRoute(relativePath: String): String = config.baseApplicationLocation ++ relativePath

}

object SwaggerFinchEndpointRegistry {

  def apply(config: ServiceSwaggerConfig)(implicit swagger: Swagger): SwaggerFinchEndpointRegistry =
    new SwaggerFinchEndpointRegistry(config)(swagger)

}