package com.mmold.infrastructure.repositories.doobie.messages

import com.mmold.business.domain.messages.models.aggregates.Message
import com.mmold.business.domain.messages.models.values.{ MessageId, RecipientId, SenderId }
import com.mmold.business.domain.messages.repositories.MessageRepositoryAlgebra

trait MessageDoobieRepositoryAlgebra[IOEffect[_], LinearCollection[_]] extends MessageRepositoryAlgebra[IOEffect, LinearCollection, MessageId, Message, SenderId, RecipientId] {

}
