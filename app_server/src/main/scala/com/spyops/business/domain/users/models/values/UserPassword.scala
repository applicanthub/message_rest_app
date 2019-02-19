package com.spyops.business.domain.users.models.values

import cats.Show
import cats.kernel.Eq
import com.spyops.business.domain.users.models.values.UserPassword.Repr
import com.spyops.scaffolding.ddd.models.ValueDDD

final case class UserPassword(value: Repr) extends ValueDDD

object UserPassword {

  type Repr = String

  implicit val show = Show.show[UserPassword](a => a.value)

  implicit val eq = Eq.instance[UserPassword]((a, b) => a.value.contentEquals(b.value))

}
