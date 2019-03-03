package com.mmold.components.websocket.interpreters

import cats.effect.IO
import com.mmold.components.websocket.WebSocketThirdPartyAlgebra
import WebSocketThirdPartyInterpreter.{ F, Collection, Channel, Event, Payload }

final class WebSocketThirdPartyInterpreter(
  pusherConfig: PusherConfig) extends WebSocketThirdPartyAlgebra[F, Collection, Channel, Event, Payload] {

  def trigger(
    channels: Collection[Channel],
    event: Event,
    payload: Payload): F[Unit] = IO.never

}

object WebSocketThirdPartyInterpreter {

  type F[A] = IO[A]

  type Collection[A] = List[A]

  type Channel = PusherChannel

  type Event = PusherEvent

  type Payload = PusherPayload

}