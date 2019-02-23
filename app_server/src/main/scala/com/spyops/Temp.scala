package com.spyops

import cats._, data._
import org.atnos.eff._
import org.atnos.eff.all._
import org.atnos.eff.syntax.all._

object Temp {

  type ReaderInt[A] = Reader[Int, A]
  type WriterString[A] = Writer[String, A]
  type Stack = Fx.fx3[WriterString, ReaderInt, Eval]

  type _readerInt[R] = ReaderInt |= R
  type _writerString[R] = WriterString |= R

  def program[R: _readerInt: _writerString: _eval]: Eff[R, Int] = for {
    n <- ask[R, Int]

    _ <- tell("the required power is " + n)

    a <- delay(math.pow(10, n.toDouble).toInt)

    _ <- tell("Logging some text.")

    _ <- tell("the result is " + a)
  } yield a

  def testIt(int: Int) = program[Stack].runReader(int).runWriter.runEval.run

  def logIt(): Unit = println(testIt(100))

}
