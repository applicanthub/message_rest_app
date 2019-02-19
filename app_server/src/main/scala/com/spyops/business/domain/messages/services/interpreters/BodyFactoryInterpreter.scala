package com.spyops.business.domain.messages.services.interpreters

import cats.implicits._
import com.spyops.business.domain.ModelValidation
import com.spyops.business.domain.messages.models.values.Body
import com.spyops.business.domain.messages.models.values.Body.Repr
import com.spyops.business.domain.messages.services.BodyFactoryAlgebra

final class BodyFactoryInterpreter extends BodyFactoryAlgebra[Body.Repr, Body] {

  def create(from: Repr): ModelValidation[Body] = (Body(from)).validNec
}

object BodyFactoryInterpreter {

  def apply: BodyFactoryInterpreter = new BodyFactoryInterpreter()

}
