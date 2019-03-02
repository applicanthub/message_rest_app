package com.mmold.lib.validations

trait StringValidationAlgebra[F[_], RawString, Num] {

  type Result = F[RawString]

  def contentIsAllCaps(rawString: RawString): Result

  def contentIsNotAllCaps(rawString: RawString): Result

  def contentIsAlphaNumeric(rawString: RawString): Result

  def lengthIsEmpty(rawString: RawString): Result

  def lengthIsAtMinimum(length: Num)(rawString: RawString): Result

  def lengthIsAtMaximum(length: Num)(rawString: RawString): Result

  def sameContent(rawStringL: RawString)(rawStringR: RawString): Result

}