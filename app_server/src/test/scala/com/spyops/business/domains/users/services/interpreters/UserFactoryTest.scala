package com.spyops.business.domains.users.services.interpreters

import com.spyops.business.domain.users.models.forms.CreateUserForm
import com.spyops.business.domain.users.services.interpreters.{ UserFactoryCreateUserFormInterpreter, UserIdFactoryInterpreter, UserPasswordFactoryInterpreter, UsernameFactoryInterpreter }
import org.scalatest.{ FlatSpec, Matchers }

class UserFactoryTest extends FlatSpec with Matchers {

  behavior of "User factory test"

  private val pairsOfValidCredentials: List[CreateUserForm] =
    List(
      CreateUserForm("martin", "odersky123"),
      CreateUserForm("john", "degoes22"),
      CreateUserForm("Edwin", "brad_1"))

  private val pairsOfInvalidCredentials: List[CreateUserForm] =
    List(
      CreateUserForm("*****", "odersky123"),
      CreateUserForm("odersky123", "*****"),
      CreateUserForm("+++++", "degoes22"),
      CreateUserForm("degoes22", "cool+++++"))

  private implicit val userIdFactoryInterpreter: UserIdFactoryInterpreter = UserIdFactoryInterpreter.apply
  private implicit val usernameFactoryInterpreter: UsernameFactoryInterpreter = UsernameFactoryInterpreter.apply
  private implicit val usernamePasswordFactoryInterpreter: UserPasswordFactoryInterpreter = UserPasswordFactoryInterpreter.apply
  private implicit val userFactoryInterpreter: UserFactoryCreateUserFormInterpreter = UserFactoryCreateUserFormInterpreter.apply

  it should "Should accurately verify good ids" in {
    for (command <- pairsOfValidCredentials) {
      userFactoryInterpreter.create(command).toEither should be('right)
    }
  }

  it should "Should accurately exclude bas ids" in {
    for (command <- pairsOfInvalidCredentials) {
      userFactoryInterpreter.create(command).toEither should be('left)
    }
  }
}
