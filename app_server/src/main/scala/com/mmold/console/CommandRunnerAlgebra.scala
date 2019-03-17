package com.mmold.console

trait CommandRunnerAlgebra[F[_], Command] {

  def run(command: Command): F[String]

}
