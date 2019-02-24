package com.spyops.scaffolding.business.application.usecases

/**
 * Log the business logic result.
 *
 * @author Nick Odumo Feb 2019
 * @todo Implement context object
 * @tparam F Effect
 * @tparam Input Input value
 * @tparam Output Output value 
 */
abstract class UseCaseExecutor[F[_], Input, Output] {

  /**
   * Log the business logic result.
   *
   * @author Nick Odumo Feb 2019
   * @param value Loggable value
   */
  def logWriterResult(value: String): F[Unit]

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

 
