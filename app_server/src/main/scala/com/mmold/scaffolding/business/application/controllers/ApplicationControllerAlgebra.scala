package com.mmold.scaffolding.business.application.controllers

import com.mmold.scaffolding.business.application.ApplicationInterfaceAlgebra

/**
 * Represents an application interface.
 *
 * @tparam F Effect name.
 */
trait ApplicationControllerAlgebra[F[_]] extends ApplicationInterfaceAlgebra[F] {

}