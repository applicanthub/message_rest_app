package com.mmold.components.random.interpreters

import java.util.UUID
import scala.language.reflectiveCalls
import com.mmold.components.random.{ RandomGeneratorAlgebra, JavaUUIDGeneratorAlgebra }

/**
 * Random generator UUID purely random.
 *
 * @author Nick Odumo Feb 2019
 * @param javaUUIDGenerator Java UUID generator
 */
final class RandomGeneratorUUIDPRandomGeneratorInterpreter private (
  val javaUUIDGenerator: JavaUUIDGeneratorAlgebra) extends RandomGeneratorAlgebra[Unit, UUID] {

  def generate(seed: Unit): UUID = javaUUIDGenerator.randomUUID

}

object RandomGeneratorUUIDPRandomGeneratorInterpreter {

  def apply(
    uuidObject: JavaUUIDGeneratorAlgebra): RandomGeneratorUUIDPRandomGeneratorInterpreter =
    new RandomGeneratorUUIDPRandomGeneratorInterpreter(uuidObject)

}
