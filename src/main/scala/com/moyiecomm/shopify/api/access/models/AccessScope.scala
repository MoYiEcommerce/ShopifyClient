package com.moyiecomm.shopify.api.access.models

import com.moyiecomm.shopify.api.access.models.AccessScope.Scope

case class AccessScope(accessScopes: List[Scope])

object AccessScope {
  case class Scope(handle: String)
}
