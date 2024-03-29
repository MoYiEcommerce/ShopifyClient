package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.Product
import com.moyiecomm.shopify.api.json.product.Product.productListDecoder
import io.circe.Decoder

case class GetProductList(override val config: Config) extends GetRequest[List[Product]](config) {
  override val path: String                            = "/products.json"
  override val responseDecoder: Decoder[List[Product]] = productListDecoder
}
