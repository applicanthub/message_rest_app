package com.spyops.scaffolding.application.usecases

import com.spyops.scaffolding.application.ApplicationInterfaceAlgebra

/**
 * Represents an application usecase.
 *
 * @tparam F Effect name
 * @tparam ID Id
 * @tparam Command Command to run
 * @tparam Result Event result
 */
trait UsecaseAlgebra[F[_], ID, Command[ID], Result] extends ApplicationInterfaceAlgebra[F] {

  def execute(command: Command[ID]): F[Result]

}
