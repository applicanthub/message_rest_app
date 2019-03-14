package com.mmold.components.random.interpreters

import com.mmold.components.random.JavaUUIDGeneratorAlgebra
import java.util.UUID

final class JavaUUIDGeneratorDefaultInterpreter extends JavaUUIDGeneratorAlgebra {

  def randomUUID(): UUID = UUID.randomUUID()

}

object JavaUUIDGeneratorDefaultInterpreter {

  def apply: JavaUUIDGeneratorDefaultInterpreter =
    new JavaUUIDGeneratorDefaultInterpreter()

}