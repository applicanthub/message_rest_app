package com.mmold.infrastructure.logging.interpreters

import java.io.PrintWriter
import com.mmold.infrastructure.logging.interpreters.LoggerEffInterpreter.{ LogMessage }
import org.atnos.eff.RightFold

/**
 * Printer logger Eff side-effecting logger.
 *
 * @author Nick Odumo Feb 2019
 * @param path Path to log message at
 */
final class LoggerEffInterpreter(path: LogMessage) extends RightFold[LogMessage, Unit] {

  type S = PrintWriter

  val init: S = new PrintWriter(path)

  def fold(a: LogMessage, s: S): S = {
    s.println(a); s
  }

  def finalize(s: S): Unit =
    s.close

}

object LoggerEffInterpreter {

  type LogMessage = String

  def apply(path: LogMessage): LoggerEffInterpreter =
    new LoggerEffInterpreter(path)

}
