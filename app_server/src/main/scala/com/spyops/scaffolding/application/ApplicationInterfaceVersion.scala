package com.spyops.scaffolding.application

import com.spyops.scaffolding.application.ApplicationInterfaceVersion.Repr

final case class ApplicationInterfaceVersion private (value: Repr)

object ApplicationInterfaceVersion {

  type Repr = Float

  def apply(value: Repr): ApplicationInterfaceVersion = new ApplicationInterfaceVersion(value)

}
