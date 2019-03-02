package com.mmold.lib.validations

trait NumberValidationAlgebra[F[_], RawString, Num] {

  type Result = F[RawString]

}
