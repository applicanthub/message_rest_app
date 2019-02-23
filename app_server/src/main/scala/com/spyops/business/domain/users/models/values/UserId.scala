package com.spyops.business.domain.users.models.values

import cats.Show
import cats.kernel.Eq
import com.spyops.business.domain.users.models.values.UserId.Repr
import com.spyops.scaffolding.business.ddd.models.IdentifierDDD

final case class UserId private[users] (
  value: UserId.Repr) extends IdentifierDDD[Repr]

object UserId {

  type Repr = String

  implicit val show = Show.show[UserId](a => a.value)

  implicit val eq = Eq.instance[UserId]((a, b) => a.value.contentEquals(b.value))

}