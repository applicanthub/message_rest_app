package com.mmold.business.domain.users.services.interpreters

import cats.implicits._
import com.mmold.business.domain
import com.mmold.business.domain.ModelValidation
import com.mmold.business.domain.users.models.values.UserId
import com.mmold.business.domain.users.services.UserIdFactoryAlgebra

/**
 * UserId factory(Smart constructor)
 *
 * @author Nick Odumo Feb 2019
 */
final class UserIdFactoryInterpreter extends UserIdFactoryAlgebra[Unit, UserId] {

  def create(from: Unit): ModelValidation[UserId] =
    (UserId(domain.genId.toString)).validNec

}

object UserIdFactoryInterpreter {

  def apply: UserIdFactoryInterpreter = new UserIdFactoryInterpreter()

}