package com.spyops.infrastructure.endpoints.finch.users.interpreters

import cats.effect.IO
import com.spyops.business.application.users.models.commands.LoginCommandDTO
import com.spyops.business.application.users.models.dtos.UserCredentials
import com.spyops.business.application.users.services.UsersGeneralApplicationServiceAlgebra
import com.spyops.business.domain.users.models.aggregates.User
import com.spyops.business.domain.users.models.values.UserId
import com.spyops.infrastructure.endpoints.finch.FinchIOEndpoint
import com.spyops.infrastructure.endpoints.finch.users.UsersFinchIOEndpointsV1Algebra
import io.finch.circe._
import io.finch._
import io.finch.catsEffect._

/**
 * User Finch IO endpoint interpreter.
 *
 * @example
 *  {{
 *    Terminal:
 *    curl POST root/v1/users/commands  [[UserCredentials]]
 *    curl GET root/v1/users/:[[UserId.Repr]]
 *  }}
 *
 * @author Nick Odumo Feb 2019
 * @usecase User domain-related operations
 * @param usersGeneralApplicationService User general application service
 */
final class UsersFinchIOEndpointsV1Interpreter(
  usersGeneralApplicationService: UsersGeneralApplicationServiceAlgebra[IO, LoginCommandDTO, UserCredentials, UserId.Repr, User]) extends UsersFinchIOEndpointsV1Algebra[UserCredentials] {

  private val AUTH_HEADER_KEY = "auth"

  lazy val routes = authenticate :+: showUser

  private lazy val xHeaderAuth = header(AUTH_HEADER_KEY)

  /** Authenticate the user using application layer. */
  def authenticate: FinchIOEndpoint[UserCredentials] =
    post("v1" :: "users" :: "commands" :: "login" :: jsonBody[LoginCommandDTO]) { loginCommand: LoginCommandDTO =>
      usersGeneralApplicationService.loginJWT(loginCommand)
        .map((optionUserCredentials: Option[UserCredentials]) => optionUserCredentials match {
          case Some(userCredentials) =>
            logRequesContext(s"Endpoint::authenticate User (${loginCommand.username}) found.")
            Ok(userCredentials)
          case None =>
            logRequesContext(s"Endpoint::authenticate User (${loginCommand.username}) not found.")
            NotFound(new Exception("User::Error:: Users not found."))
        })
    }

  /** Retrieve the use application. */
  def showUser: FinchIOEndpoint[String] =
    get("v1" :: "users" :: path[UserId.Repr] :: xHeaderAuth) { (userId: UserId.Repr, _: String) =>
      IO.delay(userId).map(value => value match {
        case v => Ok(v)
      })
    }

}

object UsersFinchIOEndpointsV1Interpreter {

  def apply(implicit usersGeneralApplicationServiceAlgebra: UsersGeneralApplicationServiceAlgebra[IO, LoginCommandDTO, UserCredentials, UserId.Repr, User]): UsersFinchIOEndpointsV1Interpreter =
    new UsersFinchIOEndpointsV1Interpreter(usersGeneralApplicationServiceAlgebra)
}
