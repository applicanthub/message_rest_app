package com.mmold.lib.permissions.role

import com.mmold.lib.permissions.permissions.PermissionId

/**
 * Role.
 *
 * @author Nick Odumo March 2019
 * @usecase Identifying a collection of permissions.
 */
sealed trait Role

/**
 * Empty role.
 *
 * @author Nick Odumo March 2019
 * @usecase Identifying a non-identified role.
 */
final case object EmptyRole

/**
 * Application role
 *
 * @author Nick Odumo March 2019
 * @usecase Defined role.
 */
final case class DefinedRole(
  id: Role.Id,
  name: Role.Name,
  displayName: Role.DisplayName,
  description: Role.Description,
  permissions: Set[PermissionId]) extends Role

object Role {

  type Id = String

  type Name = String

  type DisplayName = String

  type Description = String

  def emptyRole = EmptyRole

}
