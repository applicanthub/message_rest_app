package com.mmold.components.random.interpreters

import com.mmold.components.random.{ JavaUUIDGeneratorAlgebra, UUIDRepr }
import java.util.UUID
import com.mmold.components.random

/**
 * Java UUID generator.
 *
 * @author Nick Odumo Feb 2019
 * @groupname Component
 */
final class JavaUUIDGeneratorSameUUIDInterpreter private (
  val uuidRepr: UUIDRepr) extends JavaUUIDGeneratorAlgebra {

  def randomUUID(): UUID = UUID.fromString(uuidRepr)

}

object JavaUUIDGeneratorSameUUIDInterpreter {

  private def apply(uuidRepr: UUIDRepr): JavaUUIDGeneratorSameUUIDInterpreter =
    new JavaUUIDGeneratorSameUUIDInterpreter(uuidRepr)

  def defaultBasedOnUUID1: JavaUUIDGeneratorSameUUIDInterpreter = apply(random.UUID_Constant_1)

  def defaultBasedOnUUID2: JavaUUIDGeneratorSameUUIDInterpreter = apply(random.UUID_Constant_2)

}