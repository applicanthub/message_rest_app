package com.spyops.infrastructure.logging

sealed trait LogDSL[Message]

final case class DebugMessageDSL[Message](message: Message) extends LogDSL[Message]

final case class InfoMessageDSL[Message](message: Message) extends LogDSL[Message]

final case class WarningMessageDSL[Message](message: Message) extends LogDSL[Message]

final case class DangerMessageDSL[Message](message: Message) extends LogDSL[Message]
