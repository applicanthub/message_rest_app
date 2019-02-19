package com.spyops.business.domain.messages.services.interpreters

import cats.implicits._
import com.spyops.business.domain.ModelValidation
import com.spyops.business.domain.messages.models.values.RecipientId
import com.spyops.business.domain.messages.models.values.RecipientId.Repr
import com.spyops.business.domain.messages.services.RecipientIdFactoryAlgebra

final class RecipientIdFactoryInterpreter extends RecipientIdFactoryAlgebra[RecipientId.Repr, RecipientId] {

  def create(from: Repr): ModelValidation[RecipientId] = RecipientId(from).validNec

}

object RecipientIdFactoryInterpreter {

  def apply: RecipientIdFactoryInterpreter = new RecipientIdFactoryInterpreter()

}