package com.spyops.business.domain.messages.models.values

import com.spyops.business.domain.messages.models.values.MessageId.Repr
import com.spyops.scaffolding.ddd.models.IdentifierDDD

final case class MessageId private[messages] (value: MessageId.Repr) extends IdentifierDDD[Repr]

object MessageId {

  type Repr = String

}