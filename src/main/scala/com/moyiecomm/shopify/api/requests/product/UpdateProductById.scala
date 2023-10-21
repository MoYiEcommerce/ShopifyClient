package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.json.product.Product
import com.moyiecomm.shopify.api.json.product.Product.{productDecoder, productEncoder}
import com.moyiecomm.shopify.api.requests.PutRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.{Decoder, Encoder}

case class UpdateProductById(product: Product, override val config: Config)
    extends PutRequest[Product, Product](product, config) {

  override val path: String = {
    require(product.id.nonEmpty, "Product id can't be empty")
    s"/products/${product.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[Product]  = productEncoder
  override val responseDecoder: Decoder[Product] = productDecoder
}
