package com.spyops.business.application.messages.services

/**
 * Message application interface.
 * This is the glue between the domain and the infrastructural layer.
 *
 * @author Nick Odumo Feb 2019
 * @usecase Application layer composition for Messages.
 */
trait MessageGeneralApplicationControllerAlgebra[F[_], CreateMessageCommand, MessageIdRepr, MessageDTO] {

  def sendMessage(createMessageCommand: CreateMessageCommand): F[Option[MessageDTO]]

  def viewMessageById(messageIdRepr: MessageIdRepr): F[Option[MessageDTO]]

  // def viewMessagesSentBetweenUsers(eitherSenderOrRecipientId: (SenderId.Repr, RecipientId.Repr)): F[List[MessageDTO]] =

  // def deleteMessage(messageIdRepr: MessageIdRepr): F[Option[MessageIdRepr]]

}
