package com.mmold.lib.permissions.profile

/**
 * Permission repository.
 *
 * @author Nick Odumo March 2019
 * @tparam F Effect
 * @tparam G G Effect (Ideally supporting monad error)
 * @tparam Role Role
 * @tparam ProfileId Profile Id
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

  def removeRole( // Remove role
    role: Role,
    profileId: ProfileId): F[G[Profile]]

  def removeAllRoles( // Remove all roles
    role: Role,
    profileId: ProfileId): F[G[Profile]]

}
