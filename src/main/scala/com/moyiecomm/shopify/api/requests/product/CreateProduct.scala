package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.RequestBuilder
import com.moyiecomm.shopify.api.requests.{PostRequest, ShopifyRequest}
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.Product
import com.moyiecomm.shopify.api.json.product.Product.{productDecoder, productEncoder}
import io.circe
import io.circe.{Decoder, Encoder}
import sttp.client3.{Request, ResponseException, UriContext}

case class CreateProduct(product: Product, override val config: Config) extends PostRequest[Product, Product](product, config) {

  override val path: String                      = "products.json"
  override val requestEncoder: Encoder[Product]  = productEncoder
  override val responseDecoder: Decoder[Product] = productDecoder
}
