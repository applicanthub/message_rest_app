package com.mmold.business.application.users.services

trait CreateUserTokenServiceAlgebra[F[_], Username, Token] {

  def createToken(username: Username): String

  def decodeToken(token: Token): F[String]

}
