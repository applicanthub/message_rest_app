package com.mmold.components.random

trait RandomGeneratorAlgebra[Seed, Result] {

  def generate(seed: Seed): Result

}
