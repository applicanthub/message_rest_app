package com.mmold.infrastructure.endpoints.finch

import cats.Eval
import com.jakehschwartz.finatra.swagger.{ FinatraSwagger, SwaggerController }
import com.mmold.configs.ServiceSwaggerConfig
import io.swagger.models.{ Operation, Swagger }
import io.finch.{ EndpointModule, Endpoint }
import com.twitter.finagle.http.Method

/**
 * Swagger Finch endpoint registry.
 *
 * @author Nick Odumo Feb 2019
 * @todo Possibly implement some sort of route accumulation object.
 *       This kind of object would greatly assist in revealing which endpoint have been registered.
 * @tparam F effect controller
 * @param swagger Swagger reference
 */
class SwaggerFinchEndpointRegistry[F[_]](config: ServiceSwaggerConfig)(val swagger: Swagger) extends SwaggerController with EndpointModule[F] {

  def tryIt() = {
    getSwagger("cooler", Method.Get) { o =>
      o.summary("Sample request with route")
        .description("Read the detail information about the student.")
        .tag("Student")

    }

    getSwagger("demo/newer", Method.Get) { o =>
      o.summary("Sample request with route")
        .description("Read the detail information about the student.")
        .tag("Student")

    }
  }

  /**
   * GET swagger.
   *
   * @author Nick Odumo Feb 2019
   * @tparam A Endpoint result
   * @param relativePath Relative route path
   * @param httpMethod HTTP method
   * @param doc Application documentation
   * @param e Endpoint
   */
  def getSwagger[A](
    relativePath: String,
    httpMethod: Method)(doc: Operation => Operation) = {
    defineRouteSwagger(relativePath, httpMethod)(doc)
  }

  /**
   * Delete swagger.
   *
   * @author Nick Odumo Feb 2019
   * @tparam A Endpoint result
   * @param relativePath Relative route path
   * @param httpMethod HTTP method
   * @param doc Application documentation
   * @param e Endpoint
   */
  def postSwagger[A](
    relativePath: String,
    httpMethod: Method)(doc: Operation => Operation)(e: Endpoint[F, A]): Eval[Endpoint.Mappable[F, A]] = Eval.later {
    defineRouteSwagger(relativePath, httpMethod)(doc)
    post(e)
  }

  /**
   * POST swagger.
   *
   * @author Nick Odumo Feb 2019
   * @tparam A Endpoint result
   * @param relativePath Relative route path
   * @param httpMethod HTTP method
   * @param doc Application documentation
   * @param e Endpoint
   */
  def putSwagger[A](
    relativePath: String,
    httpMethod: Method)(doc: Operation => Operation)(e: Endpoint[F, A]): Eval[Endpoint.Mappable[F, A]] = Eval.later {
    defineRouteSwagger(relativePath, httpMethod)(doc)
    put(e)
  }

  /**
   * DELETE swagger.
   *
   * @author Nick Odumo Feb 2019
   * @tparam A Endpoint result
   * @param relativePath Relative route path
   * @param httpMethod HTTP method
   * @param doc Application documentation
   * @param e Endpoint
   */
  def deleteSwagger[A](
    relativePath: String,
    httpMethod: Method)(doc: Operation => Operation)(e: Endpoint[F, A]): Eval[Endpoint.Mappable[F, A]] = Eval.later {
    defineRouteSwagger(relativePath, httpMethod)(doc)
    delete(e)
  }

  /**
   * Define swagger route.
   *
   * @author Nick Odumo Feb 2019
   * @param relativePath Relative route path
   * @param httpMethod HTTP method
   * @param doc Application documentation
   */
  private def defineRouteSwagger(
    relativePath: String,
    httpMethod: Method)(doc: Operation => Operation): Unit =
    registerOperation(relativePath, httpMethod)(doc)

  /**
   * Register swagger route.
   *
   * @author Nick Odumo Feb 2019
   * @param relativePath Relative route path
   * @param httpMethod HTTP method
   * @param doc Application documentation
   */
  private def registerOperation(relativePath: String, httpMethod: Method)(doc: Operation => Operation): Unit = {
    val _ = FinatraSwagger
      .convert(swagger)
      .registerOperation(absoluteRoute(relativePath), httpMethod.name, doc(new Operation().summary("Sample request with route")
        .description("Read the detail information about the student.")
        .tag("Student")))
  }

  /**
   * Determine absolute path.
   *
   * @author Nick Odumo Feb 2019
   * @param relativePath Path
   */
  private def absoluteRoute(relativePath: String): String = config.baseApplicationLocation ++ relativePath

}
