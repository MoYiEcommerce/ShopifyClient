package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.json.product.ProductVariant
import com.moyiecomm.shopify.api.json.product.ProductVariant.productVariantListDecoder
import com.moyiecomm.shopify.api.requests.GetRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.Decoder

case class GetProductVariantList(productId: Long, override val config: Config) extends GetRequest[List[ProductVariant]](config) {

  override val path: String                                   = s"/products/$productId/variants.json"
  override val responseDecoder: Decoder[List[ProductVariant]] = productVariantListDecoder
}
