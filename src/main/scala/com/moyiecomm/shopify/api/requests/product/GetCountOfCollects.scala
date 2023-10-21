package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.requests.CountRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config

case class GetCountOfCollects(override val config: Config) extends CountRequest(config) {
  override val path: String = "collects/count.json"
}
