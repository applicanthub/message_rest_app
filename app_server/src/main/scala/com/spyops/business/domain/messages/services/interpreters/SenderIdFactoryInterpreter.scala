package com.spyops.business.domain.messages.services.interpreters

import cats.implicits._
import com.spyops.business.domain.ModelValidation
import com.spyops.business.domain.messages.models.values.SenderId
import com.spyops.business.domain.messages.models.values.SenderId.Repr
import com.spyops.business.domain.messages.services.SenderIdFactoryAlgebra

final class SenderIdFactoryInterpreter extends SenderIdFactoryAlgebra[SenderId.Repr, SenderId] {

  def create(from: Repr): ModelValidation[SenderId] = SenderId(from).validNec

}

object SenderIdFactoryInterpreter {

  def apply: SenderIdFactoryInterpreter = new SenderIdFactoryInterpreter()

}