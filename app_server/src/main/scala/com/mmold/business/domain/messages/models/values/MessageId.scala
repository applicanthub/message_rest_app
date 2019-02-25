package com.mmold.business.domain.messages.models.values

import com.mmold.business.domain.messages.models.values.MessageId.Repr
import com.mmold.scaffolding.business.ddd.models.IdentifierDDD

final case class MessageId private[messages] (value: MessageId.Repr) extends IdentifierDDD[Repr]

object MessageId {

  type Repr = String

}