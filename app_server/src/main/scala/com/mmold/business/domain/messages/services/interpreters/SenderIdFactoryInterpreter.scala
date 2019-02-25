package com.mmold.business.domain.messages.services.interpreters

import cats.implicits._
import com.mmold.business.domain.ModelValidation
import com.mmold.business.domain.messages.models.values.SenderId
import com.mmold.business.domain.messages.models.values.SenderId.Repr
import com.mmold.business.domain.messages.services.SenderIdFactoryAlgebra

final class SenderIdFactoryInterpreter extends SenderIdFactoryAlgebra[SenderId.Repr, SenderId] {

  def create(from: Repr): ModelValidation[SenderId] = SenderId(from).validNec

}

object SenderIdFactoryInterpreter {

  def apply: SenderIdFactoryInterpreter = new SenderIdFactoryInterpreter()

}