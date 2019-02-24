package com.spyops.scaffolding.business.application

/**
 * Represents an application interface.
 *
 * @tparam F Effect name.
 */
abstract class ApplicationInterfaceAlgebra[F[_]] {

  val applicationInterfaceName: ApplicationInterfaceName

  val applicationInterfaceVersion: ApplicationInterfaceVersion

}

object ApplicationInterfaceAlgebra {

}