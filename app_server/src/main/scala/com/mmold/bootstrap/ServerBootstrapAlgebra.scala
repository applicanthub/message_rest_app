package com.mmold.bootstrap

import com.mmold.APIServer

/**
 * Provides a service as described.
 *
 * @tparam F Boot effect
 */
trait ServerBootstrapAlgebra[F[_]] {

  val server: APIServer

}
