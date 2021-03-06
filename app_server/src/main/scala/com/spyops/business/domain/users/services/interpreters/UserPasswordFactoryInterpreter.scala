package com.spyops.business.domain.users.services.interpreters

import cats.implicits._
import com.spyops.business.domain.ModelValidation
import com.spyops.business.domain.users.models.values.UserPassword
import com.spyops.business.domain.users.models.values.UserPassword.Repr
import com.spyops.business.domain.users.services.UserPasswordFactoryAlgebra
import com.spyops.scaffolding.application.errors.ModelValidationError
import com.spyops.utils.regex.syntax._
import scala.util.matching.Regex

/**
 * UserPassword factory(Smart constructor)
 *
 * @author Nick Odumo Feb 2019
 */
final class UserPasswordFactoryInterpreter extends UserPasswordFactoryAlgebra[UserPassword.Repr, UserPassword] {

  private val userPasswordRegex: Regex = "^[a-z0-9_-]{3,15}$"r

  private def validationFailMessage(input: Repr): String =
    s"""Could not match the input `${input}` with UserPassword rules."""

  def create(from: Repr): ModelValidation[UserPassword] =
    if (userPasswordRegex.matches(from)) UserPassword(from).validNec
    else ModelValidationError(validationFailMessage(from)).invalidNec

}

object UserPasswordFactoryInterpreter {

  def apply: UserPasswordFactoryInterpreter = new UserPasswordFactoryInterpreter()

}
