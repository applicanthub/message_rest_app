package com.spyops.infrastructure.logging

trait LogInfrastructuralServiceAlgebra[F[_], Message] {

  def logDebug(message: Message): F[Unit]

  def logInfo(message: Message): F[Unit]

  def logWarning(message: Message): F[Unit]

  def logDanger(message: Message): F[Unit]

}
