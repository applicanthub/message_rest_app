package com.spyops.business.domain.messages.services

import com.spyops.business.domain.DomainModelFactory

trait MessageFactoryAlgebra[From, To] extends DomainModelFactory[From, To]
