package com.mmold.lib.permissions.role

/**
 * Permission repository.
 *
 * @author Nick Odumo March 2019
 * @tparam F Effect
 * @tparam Entity Entity name
 */
trait RoleManagementRepository[F[_], Role, Profile, Entity] {

  def assignRole(role: Role): F[Unit]

  def removeRole(role: Role): F[Unit]

}
