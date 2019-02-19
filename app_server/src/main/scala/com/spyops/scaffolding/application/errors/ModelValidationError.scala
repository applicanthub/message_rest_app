package com.spyops.scaffolding.application.errors

import com.spyops.scaffolding.application.errors.ModelValidationError.Repr

final case class ModelValidationError(message: Repr) extends Throwable {
  override def toString = s"ModelValidationError::${message}"
}

object ModelValidationError {

  type Repr = String

}
