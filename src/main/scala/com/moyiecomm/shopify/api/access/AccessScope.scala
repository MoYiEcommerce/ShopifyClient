package com.moyiecomm.shopify.api.access

import com.moyiecomm.shopify.api.access.AccessScope.Scope

case class AccessScope(accessScopes: List[Scope])

object AccessScope {
  case class Scope(handle: String)
}
