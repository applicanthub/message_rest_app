package com.mmold.lib.permissions.profile

import cats.data.NonEmptyList

/**
 * Permission repository.
 *
 * @author Nick Odumo March 2019
 * @tparam F Effect
 * @tparam G G Effect (Ideally supporting monad error)
 * @tparam Role Role
 * @tparam ProfileId Profile Id
 * @tparam Profile Profile
 */
trait ProfileManagementRepository[F[_], G[_], Role, ProfileId, Profile] {

  //================================================================================
  // Role: Assign-
  //================================================================================

  def assignRole( // Assign role
    role: Role,
    profileId: ProfileId): F[G[Profile]]

  //================================================================================
  // Role check
  //================================================================================

  def hasRole( // Has role
    role: Role,
    profileId: ProfileId): F[G[Profile]]

  def doesNotHaveRole( // Doesn't have role
    role: Role,
    profileId: ProfileId): F[G[Profile]]

  //================================================================================
  // Role: Remove
  //================================================================================

  def revokeRole( // Remove role
    role: Role,
    profileId: ProfileId): F[G[Profile]]

  def removeRoles( // Remove all roles
    roles: NonEmptyList[Role],
    profileId: ProfileId): F[G[Profile]]

  def removeAllRoles( // Remove all roles
    role: Role,
    profileId: ProfileId): F[G[Profile]]

}
