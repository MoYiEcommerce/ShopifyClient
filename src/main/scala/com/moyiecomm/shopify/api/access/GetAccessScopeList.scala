package com.moyiecomm.shopify.api.access

import com.moyiecomm.shopify.api.access.models.AccessScope
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import io.circe.generic.auto._

case class GetAccessScopeList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[AccessScope]] {
  override def path: String = "/oauth/access_scopes.json"
}
