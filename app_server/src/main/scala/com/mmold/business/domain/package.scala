package com.mmold.business

import java.util.UUID

import cats.data.ValidatedNec
import com.mmold.scaffolding.business.application.errors.ModelValidationError
import com.mmold.scaffolding.business.ddd.services.FactoryAlgebra

import scala.util.matching.Regex

package object domain {

  type ModelValidation[V] = ValidatedNec[ModelValidationError, V]

  type DomainModelFactory[To, From] = FactoryAlgebra[ModelValidation, From, To]

  private[domain] val nonEmptyString: Regex = "".r

  private[domain] def genId: UUID = UUID.randomUUID

}
