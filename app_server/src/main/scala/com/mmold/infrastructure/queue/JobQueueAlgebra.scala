package com.mmold.infrastructure.queue

/**
 * A specific concurrent queue implementation.
 *
 * @todo Create a priority queue as well
 * @tparam F[_] Effect
 * @tparam BI Bi-functorial result
 * @tparam Err Error
 * @tparam Item Item to manipulate
 * @tparam Size Size to calculate
 */
trait JobQueue[F[_], BI[_, _], Err, Item, Size] {

  type FindOrError = BI[Err, Item]

  /**
   * Get the size of the queue.
   *
   * @author Nick Odumo Feb 2019
   */
  def size: F[Size]

  /**
   *  Enqueue a new value.
   *
   * @author Nick Odumo Feb 2019
   */
  def enqueue(item: Item): F[Unit]

  /**
   * Peek the queue determine how many value there are.
   *
   * @author Nick Odumo Feb 2019
   */
  def peek: F[FindOrError]

  /**
   * Dequeue.
   *
   * @author Nick Odumo Feb 2019
   */
  def deque: F[FindOrError]

}