package com.mmold.components.nashorn.interpreters

import com.mmold.components.nashorn.{ NashornRawResult, RawResultFactoryAlgebra }

final class RawResultFactoryInterpreters extends RawResultFactoryAlgebra[Either, String, Object, NashornRawResult] {

  def from(from: Object): Either[String, NashornRawResult] = from match {
    case rawReturnValue => Right(NashornRawResult(rawReturnValue.toString))
  }

}

object RawResultFactoryInterpreters {

  def apply: RawResultFactoryInterpreters = new RawResultFactoryInterpreters()

}

