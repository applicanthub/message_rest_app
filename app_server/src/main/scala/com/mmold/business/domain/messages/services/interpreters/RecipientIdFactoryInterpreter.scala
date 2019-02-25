package com.mmold.business.domain.messages.services.interpreters

import cats.implicits._
import com.mmold.business.domain.ModelValidation
import com.mmold.business.domain.messages.models.values.RecipientId
import com.mmold.business.domain.messages.models.values.RecipientId.Repr
import com.mmold.business.domain.messages.services.RecipientIdFactoryAlgebra

final class RecipientIdFactoryInterpreter extends RecipientIdFactoryAlgebra[RecipientId.Repr, RecipientId] {

  def create(from: Repr): ModelValidation[RecipientId] = RecipientId(from).validNec

}

object RecipientIdFactoryInterpreter {

  def apply: RecipientIdFactoryInterpreter = new RecipientIdFactoryInterpreter()

}