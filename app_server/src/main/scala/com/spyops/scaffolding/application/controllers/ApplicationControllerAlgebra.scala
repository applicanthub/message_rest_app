package com.spyops.scaffolding.application.controllers

import com.spyops.scaffolding.application.ApplicationInterfaceAlgebra

/**
 * Represents an application interface.
 *
 * @tparam F Effect name.
 */
trait ApplicationControllerAlgebra[F[_]] extends ApplicationInterfaceAlgebra[F] {

}