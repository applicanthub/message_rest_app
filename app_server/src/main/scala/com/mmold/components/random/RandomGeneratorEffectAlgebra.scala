package com.mmold.components.random

trait RandomGeneratorEffectAlgebra[F[_], Seed, Result] {

  def generate(seed: Seed): F[Result]

}

