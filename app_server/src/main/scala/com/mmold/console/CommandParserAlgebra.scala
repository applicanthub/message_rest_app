package com.mmold.console

trait CommandParserAlgebra[F[_], L[_], ConsoleCommand] {

  def parse(input: L[String]): F[ConsoleCommand]

}
