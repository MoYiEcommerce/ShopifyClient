package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.Product
import com.moyiecomm.shopify.api.json.product.Product.productDecoder
import io.circe.Decoder

case class GetProductById(id: Long, override val config: Config) extends GetRequest[Product](config) {
  override val path: String                      = s"/products/$id.json"
  override val responseDecoder: Decoder[Product] = productDecoder
}
