package com.mmold.components.random.interpreters

import com.mmold.components.random.{ JavaUUIDGeneratorAlgebra, UUIDRepr }
import java.util.UUID

final class JavaUUIDGeneratorSameUUIDInterpreter(
  uuidRepr: UUIDRepr) extends JavaUUIDGeneratorAlgebra {

  def randomUUID(): UUID = UUID.fromString(uuidRepr)

}

object JavaUUIDGeneratorSameUUIDInterpreter {

  def apply(uuidRepr: UUIDRepr): JavaUUIDGeneratorSameUUIDInterpreter =
    new JavaUUIDGeneratorSameUUIDInterpreter(uuidRepr)

}