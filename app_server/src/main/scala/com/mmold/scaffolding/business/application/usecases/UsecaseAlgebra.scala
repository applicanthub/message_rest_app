package com.mmold.scaffolding.business.application.usecases

import com.mmold.scaffolding.business.application.ApplicationInterfaceAlgebra

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
