package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.json.product.Product
import com.moyiecomm.shopify.api.json.product.Product.productDecoder
import com.moyiecomm.shopify.api.json.product.Product.productEncoder
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import io.circe.Decoder
import io.circe.Encoder

case class CreateProduct(product: Product, override val config: Config) extends PostRequest[Product, Product](product, config) {

  override val path: String                      = "products.json"
  override val requestEncoder: Encoder[Product]  = productEncoder
  override val responseDecoder: Decoder[Product] = productDecoder
}
