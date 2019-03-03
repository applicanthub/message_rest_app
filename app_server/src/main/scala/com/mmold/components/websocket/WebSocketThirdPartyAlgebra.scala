package com.mmold.components.websocket

/**
 * Websocket algebra.
 *
 * @author Nick Odumo Feb 2019
 * @tparam F Effect
 * @tparam Collection Collection
 * @tparam Channel Channel to broadcast this on.
 * @tparam Event Event
 * @tparam Payload Payload content
 */
trait WebSocketThirdPartyAlgebra[F[_], Collection[_], Channel, Event, Payload] {

  /**
   * Trigger event on channel.
   *
   * @author Nick Odumo Feb 2019
   * @param channels Channels to broadcast on on
   * @param event Event to broadcast
   * @param payload Payload content
   */
  def trigger(
    channels: Collection[Channel],
    event: Event,
    payload: Payload): F[Unit]

}
