package com.mmold.business.application.controllers.users.services

import cats.Monad

/**
 * Users application interface.
 * This is the glue between the domain and the infrastructural layer.
 *
 * @author Nick Odumo Feb 2019  *
 * @usecase Application layer composition for Users.
 * @tparam F IO Effect
 * @tparam LoginCommand Command
 * @tparam UserCredentialsDTO DTO
 * @tparam UserIdRepr Id representation
 */
trait UsersGeneralApplicationServiceAlgebra[F[_], LoginCommand, UserCredentialsDTO, UserIdRepr, User] {

  def loginJWT(loginCommand: LoginCommand)(implicit m: Monad[F]): F[Option[UserCredentialsDTO]]

  //  def getUserProfile(userIdRepr: UserIdRepr)(implicit m: Monad[F]): F[Option[User]]

}
