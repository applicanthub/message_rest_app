package com.spyops.business.application.users.services.interpreters

import com.spyops.business.application.users.services.CreateUserTokenServiceAlgebra
import com.spyops.business.domain.users.models.values.Username
import pdi.jwt.{ Jwt, JwtAlgorithm }
import scala.util.Try

/**
 * Spy chat application.
 *
 * @author Nick Odumo Feb 2019
 * @see http://pauldijou.fr/jwt-scala/samples/jwt-core/
 * @param secretKey Secret key
 */
final class CreateUserTokenHS256Interpreter(secretKey: String) extends CreateUserTokenServiceAlgebra[Try, Username, String] {

  private val algorithmOfChoice = JwtAlgorithm.HS256

  def createToken(username: Username): String = Jwt.encode(username.value, secretKey, algorithmOfChoice)

  def decodeToken(token: String): Try[String] = Jwt.decodeRawAll(token, secretKey, Seq(algorithmOfChoice)).map(_._2)

}

object CreateUserTokenHS256Interpreter {

  def apply(secretKey: String): CreateUserTokenHS256Interpreter = new CreateUserTokenHS256Interpreter(secretKey)

}