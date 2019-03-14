package com.mmold.components.random.interpreters

import com.mmold.components.random.JavaUUIDGeneratorAlgebra
import java.util.UUID

/**
 * Default UUID generator.
 *
 * @author Nick Odumo Feb 2019
 * @groupname Component
 */
final class JavaUUIDGeneratorDefaultInterpreter private () extends JavaUUIDGeneratorAlgebra {

  def randomUUID(): UUID = UUID.randomUUID()

}

object JavaUUIDGeneratorDefaultInterpreter {

  def apply: JavaUUIDGeneratorDefaultInterpreter =
    new JavaUUIDGeneratorDefaultInterpreter()

}