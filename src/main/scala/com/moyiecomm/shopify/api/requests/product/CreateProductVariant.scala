package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.RequestBuilder
import com.moyiecomm.shopify.api.json.product.ProductVariant
import com.moyiecomm.shopify.api.json.product.ProductVariant.{productVariantDecoder, productVariantEncoder}
import com.moyiecomm.shopify.api.requests.{PostRequest, ShopifyRequest}
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe
import io.circe.{Decoder, Encoder}
import sttp.client3.{Request, ResponseException, UriContext}

case class CreateProductVariant(productVariant: ProductVariant, override val config: Config)
    extends PostRequest[ProductVariant, ProductVariant](productVariant, config) {

  override val path: String = s"products/${productVariant.productId}/variants.json"

  override val requestEncoder: Encoder[ProductVariant]  = productVariantEncoder
  override val responseDecoder: Decoder[ProductVariant] = productVariantDecoder
}
