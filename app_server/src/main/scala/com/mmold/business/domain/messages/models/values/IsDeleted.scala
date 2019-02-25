package com.mmold.business.domain.messages.models.values

import com.mmold.business.domain.messages.models.values.IsDeleted.Repr

final case class IsDeleted private[domain] (
  value: Repr) extends AnyVal

object IsDeleted {

  type Repr = Boolean

  val DELETED: Repr = true

  val NOT_DELETED: Repr = false

}