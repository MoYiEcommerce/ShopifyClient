package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.ProductVariant
import com.moyiecomm.shopify.api.json.product.ProductVariant.productVariantDecoder
import com.moyiecomm.shopify.api.json.product.ProductVariant.productVariantEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateProductVariant(productVariant: ProductVariant, override val config: Config)
    extends PostRequest[ProductVariant, ProductVariant](productVariant, config) {

  override val path: String = s"products/${productVariant.productId}/variants.json"

  override val requestEncoder: Encoder[ProductVariant]  = productVariantEncoder
  override val responseDecoder: Decoder[ProductVariant] = productVariantDecoder
}
