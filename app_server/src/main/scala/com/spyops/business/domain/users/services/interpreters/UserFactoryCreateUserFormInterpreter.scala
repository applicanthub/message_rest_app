package com.spyops.business.domain.users.services.interpreters

import cats.data.Validated._
import cats.implicits._
import com.spyops.business.domain.ModelValidation
import com.spyops.business.domain.users.models.aggregates.User
import com.spyops.business.domain.users.models.forms.CreateUserForm
import com.spyops.business.domain.users.services.UserFactoryAlgebra

/**
 * User domain aggregate factory.
 * This domain aggregate is the composition of the factories of its constituent parts.
 *
 * @author Nick Odumo Feb 2019
 */
final class UserFactoryCreateUserFormInterpreter(
  userIdFactoryInterpreter: UserIdFactoryInterpreter,
  usernameFactoryInterpreter: UsernameFactoryInterpreter,
  userPasswordFactoryInterpreter: UserPasswordFactoryInterpreter) extends UserFactoryAlgebra[CreateUserForm, User] {

  /**
   * Create method based upon the create functions for the aggregate's constituent values.
   *
   * @see Applicative validation composition at the following address
   *      https://typelevel.org/cats/datatypes/validated.html
   * @author Nick Odumo Feb 2019
   */
  def create(from: CreateUserForm): ModelValidation[User] = (
    userIdFactoryInterpreter.create(()),
    usernameFactoryInterpreter.create(from.username),
    userPasswordFactoryInterpreter.create(from.password)).mapN(User.apply)

}

object UserFactoryCreateUserFormInterpreter {

  def apply(implicit
    userIdFactoryInterpreter: UserIdFactoryInterpreter,
    usernameFactoryInterpreter: UsernameFactoryInterpreter,
    userPasswordFactoryInterpreter: UserPasswordFactoryInterpreter): UserFactoryCreateUserFormInterpreter =
    new UserFactoryCreateUserFormInterpreter(
      userIdFactoryInterpreter,
      usernameFactoryInterpreter,
      userPasswordFactoryInterpreter)

}