package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.ProductVariant
import com.moyiecomm.shopify.api.json.product.ProductVariant.productVariantDecoder
import io.circe.Decoder

case class GetProductVariantById(variantId: Long, override val config: Config) extends GetRequest[ProductVariant](config) {

  override val path: String                             = s"/variants/$variantId.json"
  override val responseDecoder: Decoder[ProductVariant] = productVariantDecoder
}
