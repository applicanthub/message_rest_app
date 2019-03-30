package com.mmold.lib.permissions.role

import com.mmold.lib.permissions.permissions.PermissionId

/**
 * Role.
 *
 * @author Nick Odumo March 2019
 * @usecase Identifying a collection of permissions.
 * @todo Abstract out a sort of baned roles.
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
 * @param id
 * @param name
 * @param displayName
 * @param description
 * @param permissions
 * @param subRoles
 */
final case class DefinedRole(
  id: Role.Id,
  name: Role.Name,
  displayName: Role.DisplayName,
  description: Role.Description,
  permissions: Set[PermissionId],
  subRoles: Set[Role]) extends Role

object Role {

  type Id = RoleId

  type Name = String

  type DisplayName = String

  type Description = String

  def emptyRole: EmptyRole.type = EmptyRole

  def define(
    id: Role.Id,
    name: Role.Name,
    displayName: Role.DisplayName,
    description: Role.Description,
    permissions: Set[PermissionId],
    subRoles: Set[RoleId]): Role = ???

}
