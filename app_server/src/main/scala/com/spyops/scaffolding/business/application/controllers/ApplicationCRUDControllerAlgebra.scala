package com.spyops.scaffolding.business.application.controllers

/**
 * Represents an application interface.
 * @tparam F Effect name.
 */
trait ApplicationCRUDControllerAlgebra[F[_], Serializer, CreateDTO, ReadDTO, ID] extends ApplicationControllerAlgebra[F] {

  def createEntity(createDTO: CreateDTO): F[ReadDTO]

  def readEntity(id: ID): F[ReadDTO]

  def updateEntity(createDTO: CreateDTO): F[ReadDTO]

  def deleteDelete(id: ID): F[Unit]

}