package com.mmold.business.domain.users.repositories

import com.mmold.scaffolding.business.ddd.repositories.RepositoryUbiquitousAlgebra

trait UserRepositoryAlgebra[F[_], UserId, Username, User] extends RepositoryUbiquitousAlgebra[F] {

  def getUserById(userId: UserId): F[Option[User]]

  def getUserByUsername(userId: Username): F[Option[User]]

}
