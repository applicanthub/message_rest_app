package com.mmold.business.domain.users.services.interpreters

import cats.implicits._
import com.mmold.business.domain.ModelValidation
import com.mmold.business.domain.users.models.values.Username
import com.mmold.business.domain.users.services.UserFactoryAlgebra
import com.mmold.scaffolding.business.application.errors.ModelValidationError
import com.mmold.utils.regex.syntax._

/**
 * Username factory(Smart constructor)
 *
 * @author Nick Odumo Feb 2019
 */
final class UsernameFactoryInterpreter extends UserFactoryAlgebra[Username.Repr, Username] {

  private val usernameRegex = "^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$"r

  private def validationFailMessage(input: Username.Repr): String =
    s"""Could not match the input `${input}` with Username rules."""

  def create(from: Username.Repr): ModelValidation[Username] =
    if (usernameRegex.matches(from)) (Username(from)).validNec
    else ModelValidationError(validationFailMessage(from)).invalidNec

}

object UsernameFactoryInterpreter {

  def apply: UsernameFactoryInterpreter = new UsernameFactoryInterpreter()

}