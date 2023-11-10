package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.DeleteRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class DeleteCollectById(id: Long, override val config: Config) extends DeleteRequest(config) {

  override val path: String = s"collects/$id.json"

}
