package com.mmold.infrastructure.executor.interpreters

import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit._

import com.mmold.infrastructure.executor.ExecutionContextAlgebra
import com.twitter.util._

/**
 * Run Async.
 *
 * @author Nick Odumo Feb 2019
 */
trait ExecutionContextIntepreter extends ExecutionContextAlgebra {

  /**
   * Run Async.
   *
   * @author Nick Odumo Feb 2019
   * @param f Function
   * @param futurePool Future pool to execute function on
   */
  final def runAsync[T](f: => T)(implicit futurePool: FuturePool): Future[T] = futurePool.apply(f)

  /**
   * Run Async unit.
   *
   * @author Nick Odumo Feb 2019
   * @param fun Function
   * @param fp Future pool to execute function on
   */
  final def runAsyncUnit[T](fun: => T)(implicit futurePool: FuturePool): Unit = {
    runAsync(fun)(futurePool)
    ()
  }

  /**
   * Run Async.
   *
   * @author Nick Odumo Feb 2019
   * @param f Function
   * @param fp Future pool to execute function on
   */
  final def block[T <: Awaitable[_]](awaitable: T): T = Await.ready(awaitable)

  /**
   * Run Async.
   *
   * @author Nick Odumo Feb 2019
   * @param f Function
   * @param fp Future pool to execute function on
   */
  final def blockUnit[T <: Awaitable[_]](awaitable: T): Unit = {
    block(awaitable)
    ()
  }

  /**
   * Shutdown executor.
   *
   * @author Nick Odumo Feb 2019
   * @param executor Executor to shutdown
   */
  final def shutdownExecutorService(executor: ExecutorService): Unit = {
    executor.shutdown()
    try {
      executor.awaitTermination(10L, SECONDS)
    } catch {
      case _: InterruptedException => {
        Console.err.println("Interrupted while waiting for graceful shutdown, forcibly shutting down...")
        executor.shutdownNow()
      }
    }
    ()
  }
}

object ExecutionContextIntepreter extends ExecutionContextIntepreter
