package com.mmold.lib.permissions

/**
 * Permission repository.
 *
 * @author Nick Odumo March 2019
 * @tparam F Effect
 * @tparam Entity Entity name
 */
trait PermissionsRepository[F[_], Entity] {

  def assignRole(entity: Entity): F[Unit]

  def removeRole(entity: Entity): F[Unit]

  def syncPermissions(entity: Entity): F[Unit]

  def syncRoles(entity: Entity): F[Unit]

}
