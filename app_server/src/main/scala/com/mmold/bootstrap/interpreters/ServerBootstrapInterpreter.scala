package com.mmold.bootstrap.interpreters

import cats.effect.IO
import com.mmold.APIServer
import com.mmold.bootstrap.ServerBootstrapAlgebra

/**
 * Application bootstrap.
 *
 * @param server Application bootstrap interpreter
 */
final class ServerBootstrapInterpreter(val server: APIServer) extends ServerBootstrapAlgebra[IO]