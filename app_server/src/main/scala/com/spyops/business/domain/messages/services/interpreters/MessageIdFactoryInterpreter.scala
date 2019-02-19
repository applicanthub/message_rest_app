package com.spyops.business.domain.messages.services.interpreters

import cats.implicits._
import com.spyops.business.domain.ModelValidation
import com.spyops.business.domain.messages.models.values.MessageId
import com.spyops.business.domain.messages.services.MessageIdFactoryAlgebra

final class MessageIdFactoryInterpreter extends MessageIdFactoryAlgebra[MessageId.Repr, MessageId] {

  def create(from: MessageId.Repr): ModelValidation[MessageId] = MessageId(from).validNec

}

object MessageIdFactoryInterpreter {

  def apply: MessageIdFactoryInterpreter = new MessageIdFactoryInterpreter()

}
