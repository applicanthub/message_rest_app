package com.spyops.scaffolding.business.application.usecases

import cats.Monad
import cats.Show

/**
 * Log the business logic result.
 *
 * @author Nick Odumo Feb 2019
 * @todo Implement context object
 * @tparam F Effect
 * @tparam Input Input value
 * @tparam Output Output value
 */
abstract class UseCaseExecutor[F[_]: Monad, Input, Output, WriterValue] {

  /**
   * Log the business logic result.
   *
   * @author Nick Odumo Feb 2019
   * @param value Loggable value
   */
  def logWriterResult(writerValue: WriterValue)(implicit show: Show[WriterValue]): F[Unit]

  /**
   * Executes the business logic of your application's use case.
   *
   * @author Nick Odumo Feb 2019
   * @param useCase UseCase object
   * @param request An object containing request data in public fields
   * @return object An object containing response data in public fields
   */
  def useCaseExecutor(useCase: Nothing, request: Input): F[(Output, WriterValue)]
  
  
  def executeUseCase: F[Output]

}

