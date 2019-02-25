package com.mmold.infrastructure.queue

/**
 * A specific concurrent queue implementation.
 * @todo Create a priority queue as well
 *
 * @tparam F[_] Effect
 * @tparam Item Item to manimulute
 * @tparam Size Size to calculate
 */
trait JobQueue[F[_], Item, Size] {

  def size: F[Size]

  def enqueue(value: Item): F[Unit]

  def peek: F[Item]

  def deque: F[Item]

}