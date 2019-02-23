package com.spyops.business.domain.users.models.values

import cats.Show
import com.spyops.business.domain.users.models.values.Username.Repr
import com.spyops.scaffolding.business.ddd.models.ValueDDD

final case class Username(value: Repr) extends ValueDDD

object Username {

  type Repr = String

  implicit val show = Show.show[UserId](a => a.value)
}

