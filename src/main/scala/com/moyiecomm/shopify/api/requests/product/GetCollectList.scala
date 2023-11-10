package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.json.product.Collect
import com.moyiecomm.shopify.api.json.product.Collect.collectListDecoder
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import io.circe.Decoder

case class GetCollectList(override val config: Config) extends GetRequest[List[Collect]](config) {
  override val path: String = "collects.json"

  override val responseDecoder: Decoder[List[Collect]] = collectListDecoder
}
