package com.mmold.scaffolding.business.ddd.algebras

trait ShowKey[A] {

  def showKey(value: A): ShowKey.Key

}

object ShowKey {

  def fromShowFunction[A](showFun: A => String): ShowKey[A] = new ShowKey[A] {
    def showKey(value: A): Key = Key(showFun(value))
  }

  final case class Key private[algebras] (value: String) extends AnyVal

}