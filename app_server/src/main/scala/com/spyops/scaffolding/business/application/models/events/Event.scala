package com.spyops.scaffolding.business.application.models.events

sealed trait Event

trait CommandEvent extends Event

trait Query extends Event