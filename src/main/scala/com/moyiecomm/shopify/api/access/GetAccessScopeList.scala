package com.moyiecomm.shopify.api.access

import com.moyiecomm.shopify.api.access.models.AccessScope
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import AccessScope.accessScopesDecoder

case class GetAccessScopeList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[AccessScope]]()(accessScopesDecoder) {
  override def fullPath: String = s"http://${apiConfig.shopUrl}${apiConfig.adminPathPrefix}$path"
  override def path: String     = "/oauth/access_scopes.json"
}
