package com.mmold.business.application.controllers.users.services.interpreters

import cats.Monad
import com.mmold.business.application.controllers.users.models.commands.LoginCommandDTO
import com.mmold.business.application.controllers.users.models.dtos.UserCredentials
import com.mmold.business.application.controllers.users.services.{ CreateUserTokenServiceAlgebra, UsersGeneralApplicationServiceAlgebra }
import com.mmold.business.domain.users.models.aggregates.User
import com.mmold.business.domain.users.models.values.{ UserId, Username }
import com.mmold.business.domain.users.repositories.UserRepositoryAlgebra
import com.mmold.business.domain.users.services.interpreters.UsernameFactoryInterpreter
import scala.util.Try

/**
 * User general application interpreter.
 *
 * This application interpreter is effectively the bridge between the infrastructure and the domain layer(application controller).
 *
 * @author Nick Odumo Feb 2019
 * @todo Possibly implement logging
 * @tparam IOEffect Effect
 * @param createUserToken Utility for creating tokens
 * @param usernameFactoryInterpreter Factory for [[Username]]
 * @param userRepository Repository for [[User]]
 */
final class UsersGeneralApplicationInterpreter[IOEffect[_]](
  createUserToken: CreateUserTokenServiceAlgebra[Try, Username, String],
  usernameFactoryInterpreter: UsernameFactoryInterpreter,
  userRepository: UserRepositoryAlgebra[IOEffect, UserId, Username, User]) extends UsersGeneralApplicationServiceAlgebra[IOEffect, LoginCommandDTO, UserCredentials, UserId.Repr, User] {

  /**
   * User general application interpreter.
   *
   * Compare the user's password and username and return Some(UserRecord) if the user has provide the right values
   * You could easily make the case for user tokens to be a purely infrastructural/security layer but
   * hey this is the layer where you keep track of authentications attempted or done! So you should create the token here.
   *
   * How else would you do updating to the user repository for things like authentication strikes?
   *
   * @author Nick Odumo Feb 2019
   * @param loginCommandDTO DTO
   * @param username Value [[User]]
   */
  private def _processAuthenticationCommand(loginCommandDTO: LoginCommandDTO)(username: Username)(implicit monad: Monad[IOEffect]): IOEffect[Option[UserCredentials]] =
    monad.map(userRepository.getUserByUsername(username)) {
      // Take the user returned in an option(Option[User]) and make sure it corresponds to the login
      _.filter(_.username.value.contains(loginCommandDTO.username))
        // Create the user token and give the token to the infrastructural layer to use whatever mechanism it chooses
        .map(user => UserCredentials(createUserToken.createToken(user.username)))
    }

  // Could have been represented as Either[DomainError, UserCredentials]
  def loginJWT(loginCommandDTO: LoginCommandDTO)(implicit monad: Monad[IOEffect]): IOEffect[Option[UserCredentials]] =
    usernameFactoryInterpreter.create(loginCommandDTO.username).fold(_ => monad.pure(None), _processAuthenticationCommand(loginCommandDTO))

  // Get the user's credentials assuming that there is some validation at the endpoint lager
  // Authentication is a an infrastructural concern and not really an business/application concern
  // def getUserProfile(userIdRepr: UserId.Repr)(implicit monad: Monad[IOEffect]): IOEffect[Option[UserCredentials]] = ???

}

object UsersGeneralApplicationInterpreter {

  def apply[IOEffect[_]](
    createUserToken: CreateUserTokenServiceAlgebra[Try, Username, String],
    usernameFactoryInterpreter: UsernameFactoryInterpreter,
    userRepositoryAlgebra: UserRepositoryAlgebra[IOEffect, UserId, Username, User]) =
    new UsersGeneralApplicationInterpreter(
      createUserToken,
      usernameFactoryInterpreter,
      userRepositoryAlgebra)

}
