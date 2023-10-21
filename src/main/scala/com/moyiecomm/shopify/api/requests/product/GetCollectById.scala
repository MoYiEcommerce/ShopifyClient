package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.json.product.Collect
import com.moyiecomm.shopify.api.json.product.Collect.collectDecoder
import com.moyiecomm.shopify.api.requests.GetRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.Decoder

case class GetCollectById(id: Long, override val config: Config) extends GetRequest[Collect](config) {

  override val path: String                      = s"collects/$id.json"
  override val responseDecoder: Decoder[Collect] = collectDecoder
}
