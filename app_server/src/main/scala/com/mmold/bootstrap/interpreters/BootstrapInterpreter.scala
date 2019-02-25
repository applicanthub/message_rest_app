package com.mmold.bootstrap.interpreters

import doobie._
import cats.effect.IO

import scala.concurrent.ExecutionContext
import io.finch.circe._
import com.twitter.finagle.{ Http, ListeningServer }
import com.mmold.bootstrap.BootstrapAlgebra
import com.mmold.business.application.messages.services.interpreters.MessageGeneralApplicationControllerInterpreter
import com.mmold.business.application.users.services.interpreters.{ CreateUserTokenHS256Interpreter, UsersGeneralApplicationInterpreter }
import com.mmold.business.domain.messages.services.interpreters._
import com.mmold.configs.{ ApplicationConfig, ServiceSwaggerConfig }
import com.mmold.business.domain.users.services.interpreters.UsernameFactoryInterpreter
import com.mmold.infrastructure.endpoints.finch.app.interpreters.{ HealthFinchIOEndpointsAPIV1Interpreter, SwaggerFinchIOEndpointsSwaggerV2Interpreter }
import com.mmold.infrastructure.endpoints.finch.users.interpreters.UsersFinchIOEndpointsV1Interpreter
import com.mmold.infrastructure.repositories.doobie.users.interpreters.UserRepositoryDoobieFInterpreter
import com.mmold.infrastructure.endpoints.finch
import com.mmold.infrastructure.endpoints.finch.ServiceSwaggerModule
import io.finch.Application
import com.mmold.infrastructure.endpoints.finch.messages.interpreters.MessageEndpointsInterpreters
import com.mmold.infrastructure.repositories.doobie.messages.interpreters.MessageDoobieRepositoryInterpreter
import com.mmold.infrastructure.endpoints.finch.SwaggerFinchEndpointRegistry
/**
 * Application Bootstrap builder.
 * In functional programming terms this is the "End of the world" where functions are impure.
 *
 * @author Nick Odumo Feb 2019
 * @todo Implement dependency wiring not based on implicit dependency wiring mechanism
 *       See: Macwire https://github.com/adamw/macwire
 * @param applicationConfig Application configuration object
 */
final class BootstrapInterpreter(applicationConfig: ApplicationConfig) extends BootstrapAlgebra {

  //================================================================================
  // Execution contexts: Message
  //================================================================================

  private implicit val contextShift = IO.contextShift(ExecutionContext.global)

  //================================================================================
  // Databases: Message
  //================================================================================

  private implicit val doobieTranscation =
    Transactor.fromDriverManager[IO](
      driver = "org.postgresql.Driver",
      url = "jdbc:postgresql://stampy.db.elephantsql.com/jbvquqam",
      user = "jbvquqam",
      pass = "d1WRSNjK4cUe61S-EebX_wimPyTIyq_2")

  //================================================================================
  // Domain services: Message
  //================================================================================

  private val messageIdFactoryInterpreter: MessageIdFactoryInterpreter = MessageIdFactoryInterpreter.apply
  private val senderIdFactoryInterpreter: SenderIdFactoryInterpreter = SenderIdFactoryInterpreter.apply
  private val recipientIdFactoryInterpreter: RecipientIdFactoryInterpreter = RecipientIdFactoryInterpreter.apply
  private val isDeletedFactoryInterpreter: IsDeletedFactoryInterpreter = IsDeletedFactoryInterpreter.apply
  private val bodyFactoryInterpreter: BodyFactoryInterpreter = BodyFactoryInterpreter.apply
  private val messageFactoryInterpreter: MessageFactorySendMessageFormInterpreter =
    MessageFactorySendMessageFormInterpreter(
      messageIdFactoryInterpreter,
      senderIdFactoryInterpreter,
      recipientIdFactoryInterpreter,
      isDeletedFactoryInterpreter,
      bodyFactoryInterpreter)

  //================================================================================
  // Domain services: Users
  //================================================================================

  private implicit val usernameFactoryInterpreter: UsernameFactoryInterpreter = UsernameFactoryInterpreter.apply

  //================================================================================
  // Domain services: Repositories
  //================================================================================

  private implicit val messageDoobieRepository = MessageDoobieRepositoryInterpreter.apply(doobieTranscation)
  private implicit val userDoobieRepository = UserRepositoryDoobieFInterpreter.apply(doobieTranscation)

  //================================================================================
  // Application: Messages
  //================================================================================

  private val createUserToken = CreateUserTokenHS256Interpreter.apply("ExC>&QpG8_Bcnp6Tvz(/XR3/rES;wj(R7Ytv(f-")
  private val messageGeneralApplicationInterpreter =
    MessageGeneralApplicationControllerInterpreter(
      messageIdFactoryInterpreter,
      senderIdFactoryInterpreter,
      recipientIdFactoryInterpreter,
      messageFactoryInterpreter,
      messageDoobieRepository)

  //================================================================================
  // Application: Users
  //================================================================================

  private val usersGeneralApplicationInterpreter =
    UsersGeneralApplicationInterpreter(
      createUserToken,
      usernameFactoryInterpreter,
      userDoobieRepository)

  //================================================================================
  //  Endpoints
  //================================================================================

  private val applicationFinchRoutes = HealthFinchIOEndpointsAPIV1Interpreter.apply.routes
  private val messageFinchRoutes = MessageEndpointsInterpreters(messageGeneralApplicationInterpreter).routes
  private val usersFinchRoutes = UsersFinchIOEndpointsV1Interpreter(usersGeneralApplicationInterpreter).routes

  //================================================================================
  // Route: Root
  //================================================================================

  private val serviceSwaggerModule = new ServiceSwaggerModule(ServiceSwaggerConfig.default())
  private val swagger = serviceSwaggerModule.swagger
  private val a = new SwaggerFinchEndpointRegistry(ServiceSwaggerConfig.default())(swagger).tryIt()
  println(a)
  private val swaggerFinchRoutes = new SwaggerFinchIOEndpointsSwaggerV2Interpreter(swagger)

  private val routeCoproduct = // @todo Refactor to infrastructure and then
    applicationFinchRoutes :+:
      messageFinchRoutes :+:
      usersFinchRoutes :+: swaggerFinchRoutes.routes

  //================================================================================
  // Route: Services
  //================================================================================

  private val applicationService = finch.corsFilter.andThen(routeCoproduct.toServiceAs[Application.Json])

  //================================================================================
  // Route: Application entry
  //================================================================================

  /**
   * Application runner.
   *
   * @author Nick Odumo Feb 2019
   * @param mainMethodArgs Main method arguments
   */
  def runApplication(arguments: List[String]): ListeningServer =
    Http.server.serve(addr = ":" ++ applicationConfig.serverPortNumber.toString, applicationService)

}

object BootstrapInterpreter {

  def apply(applicationConfig: ApplicationConfig): BootstrapInterpreter =
    new BootstrapInterpreter(applicationConfig)

}
