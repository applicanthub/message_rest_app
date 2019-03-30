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

  // Assign role
  def assignRole(
    role: Role,
    profileId: ProfileId): F[G[Profile]]

  // Has role
  def hasRole(
    role: Role,
    profileId: ProfileId): F[G[Profile]]

  // Doesn't have role
  def doesNotHaveRole(
    role: Role,
    profileId: ProfileId): F[G[Profile]]

  // Assign role
  def removeRole(
    role: Role,
    profileId: ProfileId): F[G[Profile]]

}
