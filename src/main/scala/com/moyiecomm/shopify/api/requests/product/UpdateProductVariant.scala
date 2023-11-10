package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.json.product.ProductVariant
import com.moyiecomm.shopify.api.json.product.ProductVariant.productVariantDecoder
import com.moyiecomm.shopify.api.json.product.ProductVariant.productVariantEncoder
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import io.circe.Decoder
import io.circe.Encoder

case class UpdateProductVariant(productVariant: ProductVariant, override val config: Config)
    extends PutRequest[ProductVariant, ProductVariant](productVariant, config) {

  override val path: String = {
    require(productVariant.id.nonEmpty, "Product Variant id must not be empty")
    s"/variants/${productVariant.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[ProductVariant]  = productVariantEncoder
  override val responseDecoder: Decoder[ProductVariant] = productVariantDecoder
}
