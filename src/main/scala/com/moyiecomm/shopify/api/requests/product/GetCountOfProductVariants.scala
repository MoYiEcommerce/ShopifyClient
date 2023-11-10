package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.CountRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class GetCountOfProductVariants(productId: Long, override val config: Config) extends CountRequest(config) {
  override val path: String = s"/products/$productId/variants/count.json"
}
