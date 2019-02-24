package com.spyops.scaffolding.business.application.usecases

import cats.Show

abstract class UseCaseExecutor[F[_], Input, Output] {

  /**
   * Log the business logic result.
   *
   * @author Nick Odumo Feb 2019
   * @param value Loggable value
   */
  def logWriterResult(value: String)(s: Show[String]): F[Unit]

  /**
   * Executes the business logic of your application's use case.
   *
   * @author Nick Odumo Feb 2019
   * @param useCase UseCase object
   * @param request An object containing request data in public fields
   * @return object An object containing response data in public fields
   */
  def executeUseCase(useCase: Nothing, request: Input): F[Output]

}

object UseCaseExecutor {

}