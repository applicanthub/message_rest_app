package com.spyops.scaffolding.business.application.errors

import com.spyops.scaffolding.business.application.errors.ModelValidationError.Repr

final case class ModelValidationError(message: Repr) extends Throwable {
  override def toString = s"ModelValidationError::${message}"
}

object ModelValidationError {

  type Repr = String

}
