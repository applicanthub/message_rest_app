package com.spyops.infrastructure.repositories.doobie.messages

import com.spyops.business.domain.messages.models.aggregates.Message
import com.spyops.business.domain.messages.models.values.{ MessageId, RecipientId, SenderId }
import com.spyops.business.domain.messages.repositories.MessageRepositoryAlgebra

trait MessageDoobieRepositoryAlgebra[F[_], LinearCollection[_]] extends MessageRepositoryAlgebra[F, LinearCollection, MessageId, Message, SenderId, RecipientId] {

}
