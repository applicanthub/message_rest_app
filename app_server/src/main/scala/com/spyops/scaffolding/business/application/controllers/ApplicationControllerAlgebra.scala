package com.spyops.scaffolding.business.application.controllers

import com.spyops.scaffolding.business.application.ApplicationInterfaceAlgebra

/**
 * Represents an application interface.
 *
 * @tparam F Effect name.
 */
trait ApplicationControllerAlgebra[F[_]] extends ApplicationInterfaceAlgebra[F] {

}