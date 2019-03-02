package com.mmold.lib.validations

trait AbstractValidationAlgebra[F[_], RawString, Num] {

  type Result = F[RawString]

}
