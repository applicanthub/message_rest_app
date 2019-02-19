package com.spyops.bootstrap.interpreters

import doobie._
import cats.effect.IO

import scala.concurrent.ExecutionContext
import io.finch.circe._
import com.twitter.finagle.Http
import com.twitter.util.{ Await, Duration }  
import com.spyops.bootstrap.BootstrapAlgebra
import com.spyops.business.application.messages.services.interpreters.MessageGeneralApplicationControllerInterpreter
import com.spyops.business.application.users.services.interpreters.{ CreateUserTokenHS256Interpreter, UsersGeneralApplicationInterpreter }
import com.spyops.business.domain.messages.services.interpreters._
import com.spyops.configs.ApplicationConfig
import com.spyops.business.domain.users.services.interpreters.UsernameFactoryInterpreter
import com.spyops.infrastructure.endpoints.finch.app.interpreters.HealthFinchIOEndpointsInterpreter
import com.spyops.infrastructure.endpoints.finch.users.interpreters.UsersFinchIOEndpointsV1Interpreter
import com.spyops.infrastructure.repositories.doobie.users.interpreters.UserRepositoryDoobieFInterpreter
import com.spyops.infrastructure.endpoints.finch
import com.spyops.infrastructure.endpoints.finch.messages.interpreters.MessageEndpointsInterpreters
import com.spyops.infrastructure.repositories.doobie.messages.interpreters.MessageDoobieRepositoryInterpreter

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
  // Endpoints: Users
  //================================================================================

  private val applicationFinchRoutes = HealthFinchIOEndpointsInterpreter.apply.routes
  private val messageFinchRoutes = MessageEndpointsInterpreters(messageGeneralApplicationInterpreter).routes
  private val usersFinchRoutes = UsersFinchIOEndpointsV1Interpreter(usersGeneralApplicationInterpreter).routes
  
  //================================================================================
  // Route: Root
  //================================================================================

  private val routeCoproduct = // @todo Refactor to infrastructure and then
    applicationFinchRoutes :+:
      messageFinchRoutes :+:
      usersFinchRoutes

  //================================================================================
  //  Services: Root
  //================================================================================

  private val applicationService = finch.corsFilter.andThen(routeCoproduct.toService)

  /**
   * Application runner.
   *
   * @author Nick Odumo Feb 2019
   * @param mainMethodArgs Main method arguments
   */
  def runApplication(mainMethodArgs: Array[String]): Unit = {
    val _ = Await.ready(Http.serve(addr = ":" ++ applicationConfig.serverPortNumber.toString, applicationService), Duration.Top)
  }

}

object BootstrapInterpreter {

  def apply(applicationConfig: ApplicationConfig): BootstrapInterpreter =
    new BootstrapInterpreter(applicationConfig)

}
