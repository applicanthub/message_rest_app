package com.mmold.business.domain.messages.services.interpreters

import cats.implicits._
import com.mmold.business.domain.ModelValidation
import com.mmold.business.domain.messages.models.values.IsDeleted
import com.mmold.business.domain.messages.models.values.IsDeleted.Repr
import com.mmold.business.domain.messages.services.IsDeletedFactoryAlgebra

final class IsDeletedFactoryInterpreter extends IsDeletedFactoryAlgebra[IsDeleted.Repr, IsDeleted] {

  def create(from: Repr): ModelValidation[IsDeleted] = IsDeleted(from).validNec

}

object IsDeletedFactoryInterpreter {

  def apply: IsDeletedFactoryInterpreter = new IsDeletedFactoryInterpreter()

}
