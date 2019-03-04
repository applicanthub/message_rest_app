package com.mmold.components.websocket.interpreters

import cats.effect.IO
import com.mmold.components.websocket.WebSocketThirdPartyAlgebra
import WebSocketThirdPartyInterpreter.{ F, Collection, Channel, Event, Payload }

/**
 * Pusher websocket implementation.
 *
 * @author Nick Odumo Feb 2019
 * @todo Upgrade class with a lot more functionality 
 * @param pusherConfig Pusher config details
 */
final class WebSocketThirdPartyInterpreter(
  pusherConfig: PusherConfig) extends WebSocketThirdPartyAlgebra[F, Collection, Channel, Event, Payload] {
  
  /**
   * Trigger pusher message to relevant channels.
   *
   * @author Nick Odumo Feb 2019
   */
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
