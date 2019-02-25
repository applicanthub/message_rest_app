package com.mmold.infrastructure.endpoints.finch.messages

import com.mmold.infrastructure.endpoints.finch.{ FinchEndpointAlgebra, FinchIOEndpoint }

trait MessagesEndpointsAlgebra[CreateMessageCommand, MessageIdRepr, MessageDTO] extends FinchEndpointAlgebra {

  def sendMessage: FinchIOEndpoint[MessageDTO]

  def viewMessageById: FinchIOEndpoint[MessageDTO]

  //  def viewMessagesSentBetweenUsers: FinchIOEndpoint[List[MessageDTO]]

  def deleteMessage: FinchIOEndpoint[MessageIdRepr]

}
