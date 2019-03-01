package com.mmold.infrastructure.correspondence

/**
 * Correspondence channel algebra.
 *
 * @tparam F Effect name
 * @tparam ChannelP  Channel
 * @tparam MessageP Message
 * @tparam Receipt Receipt
 */
trait CorrespondenceChannelAlgebra[F[_], ChannelP, MessageP, Receipt] {

  /**
   * Correspondences are meant to be sent. This function is how we send whatever it is.
   *
   * @param correspondence Correspondence to send
   * @param message Message
   */
  def sendCorrespondence(channel: ChannelP, message: MessageP): F[Receipt]

}
