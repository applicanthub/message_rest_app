package com.spyops.scaffolding.application

import com.spyops.scaffolding.application.ApplicationInterfaceName.Repr

final case class ApplicationInterfaceName private (value: Repr) extends AnyVal

object ApplicationInterfaceName {

  type Repr = String

  def apply(value: Repr): ApplicationInterfaceName = new ApplicationInterfaceName(value)

}