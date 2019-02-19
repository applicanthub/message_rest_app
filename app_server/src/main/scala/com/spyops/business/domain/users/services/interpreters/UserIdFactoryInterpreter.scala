package com.spyops.business.domain.users.services.interpreters

import cats.implicits._
import com.spyops.business.domain
import com.spyops.business.domain.ModelValidation
import com.spyops.business.domain.users.models.values.UserId
import com.spyops.business.domain.users.services.UserIdFactoryAlgebra

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