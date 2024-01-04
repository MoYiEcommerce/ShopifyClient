package com.moyiecomm.shopify.api.requests.access

import com.moyiecomm.shopify.api.builder.DeleteRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class DeleteStoreFrontAccessTokenById(id: Long, override val config: Config) extends DeleteRequest(config) {
  override val path: String = s"storefront_access_tokens/$id.json"
}
