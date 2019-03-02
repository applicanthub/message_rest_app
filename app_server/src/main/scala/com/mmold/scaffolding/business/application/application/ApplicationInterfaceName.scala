package com.mmold.scaffolding.business.application.application

import ApplicationInterfaceName.{ Repr => Value }

final case class ApplicationInterfaceName private (value: Value) extends AnyVal

object ApplicationInterfaceName {

  type Repr = String

  def apply(value: Repr): ApplicationInterfaceName = new ApplicationInterfaceName(value)

}