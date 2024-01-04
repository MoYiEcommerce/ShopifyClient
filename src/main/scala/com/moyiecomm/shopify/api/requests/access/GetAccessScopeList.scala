package com.moyiecomm.shopify.api.requests.access

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.access.AccessScope
import com.moyiecomm.shopify.api.json.access.AccessScope.accessScopesDecoder
import io.circe.Decoder

case class GetAccessScopeList(override val config: Config) extends GetRequest[List[AccessScope]](config) {
  override def fullPath: String                            = s"http://${config.shopUrl}${config.adminPathPrefix}$path"
  override val path: String                                = "/oauth/access_scopes.json"
  override val responseDecoder: Decoder[List[AccessScope]] = accessScopesDecoder
}
