package com.mmold.infrastructure.repositories.doobie.users.interpreters

import doobie.implicits._
import doobie.util.query.Query0
import doobie.util.update.Update0
import com.mmold.business.domain.users.models.aggregates.User
import com.mmold.business.domain.users.models.values.{ UserId, Username }
import com.mmold.infrastructure.repositories.doobie.users.UserQueryAlgebra

trait UserQueryInterpreter extends UserQueryAlgebra {

  def selectByUserId(userId: UserId.Repr): Query0[User] = sql"""
    SELECT *
    FROM USERS
    WHERE aggregateId = $userId
  """.query[User]

  def selectByUserName(username: Username.Repr): Query0[User] = sql"""
    SELECT *
    FROM USERS
    WHERE username = $username
  """.query[User]

  def insert(user: User): Update0 = sql"""
    INSERT INTO USERS (Username, UserPassword)
    VALUES (${user.username}, ${user.userPassword})
  """.update

}
