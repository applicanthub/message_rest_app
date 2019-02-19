package com.spyops.business.domain.messages.errors

sealed trait Transactional extends Throwable

final case class MessageRecipientNotFound(id: String) extends Transactional
