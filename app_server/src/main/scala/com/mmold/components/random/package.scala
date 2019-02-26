package com.mmold.components

import java.util.UUID

package object random {

  type JavaUUIDGenerator = {
    def randomUUID(): UUID
  }

}
