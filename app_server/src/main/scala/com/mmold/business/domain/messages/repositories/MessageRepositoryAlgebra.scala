package com.mmold.business.domain.messages.repositories

trait MessageRepositoryAlgebra[F[_], LinearColl[_], MessageId, Message, SenderId, RecipientId] {

  def createMessage(message: Message): F[Int]

  def readByMessageId(messageId: MessageId): F[Option[Message]]

  def readMessageBetweenSenderAndRecipient(userId: (SenderId, RecipientId)): F[LinearColl[Message]]

  def deleteMessage(messageId: MessageId): F[Int]

}
