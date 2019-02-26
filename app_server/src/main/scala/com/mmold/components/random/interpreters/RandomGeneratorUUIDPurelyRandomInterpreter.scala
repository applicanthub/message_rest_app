package com.mmold.components.random.interpreters

import java.util.UUID
import scala.language.reflectiveCalls
import com.mmold.components.random.{ RandomGeneratorAlgebra, JavaUUIDGenerator }

/**
 * HTTP application.
 *
 * @author Nick Odumo Feb 2019
 * @param uuidObject Java UUID generator
 */
final class RandomGeneratorUUIDPurelyRandomInterpreter(uuidObject: JavaUUIDGenerator) extends RandomGeneratorAlgebra[Unit, UUID] {

  def generate(seed: Unit): UUID = uuidObject.randomUUID

}

object RandomGeneratorUUIDPurelyRandomInterpreter {

  def apply(uuidObject: JavaUUIDGenerator): RandomGeneratorUUIDPurelyRandomInterpreter =
    new RandomGeneratorUUIDPurelyRandomInterpreter(uuidObject)

}
