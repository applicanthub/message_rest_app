package com.mmold.scaffolding.business.application

import com.mmold.scaffolding.business.application.ApplicationInterfaceVersion.Repr

final case class ApplicationInterfaceVersion private (value: Repr)

object ApplicationInterfaceVersion {

  type Repr = Float

  def apply(value: Repr): ApplicationInterfaceVersion = new ApplicationInterfaceVersion(value)

}
