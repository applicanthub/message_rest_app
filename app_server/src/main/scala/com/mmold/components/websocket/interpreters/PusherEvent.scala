package com.mmold.components.websocket.interpreters

final case class PusherEvent(
  value: PusherEvent.Repr)

object PusherEvent {

  type Repr = String

}