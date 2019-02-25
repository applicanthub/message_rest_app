package com.mmold.bootstrap.interpreters

import cats.effect.IO
import com.mmold.APIServer
import com.mmold.bootstrap.ServerBootstrapAlgebra

/**
 * Application bootstrap.
 * Bootstrapper that passes the server to application endpoints/controllers that can update the stats.
 * @see Example: [[https://github.com/yorktsai/finch-example/blob/master/src/main/scala/tw/york/finch/example/Main.scala]].
 *
 * @param server Application bootstrap interpreter
 */
final class ServerBootstrapInterpreter(val server: APIServer) extends ServerBootstrapAlgebra[IO]

