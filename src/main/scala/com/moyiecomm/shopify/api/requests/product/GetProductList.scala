package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.json.product.Product
import com.moyiecomm.shopify.api.json.product.Product.productListDecoder
import com.moyiecomm.shopify.api.requests.GetRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.Decoder

case class GetProductList(override val config: Config) extends GetRequest[List[Product]](config) {
  override val path: String                            = "/products.json"
  override val responseDecoder: Decoder[List[Product]] = productListDecoder
}
