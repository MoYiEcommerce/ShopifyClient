package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.ProductImage
import com.moyiecomm.shopify.api.json.product.ProductImage.productImageDecoder
import io.circe.Decoder

case class GetProductImageById(productId: Long, imageId: Long, override val config: Config)
    extends GetRequest[ProductImage](config) {

  override val path: String                           = s"/products/$productId/images/$imageId.json"
  override val responseDecoder: Decoder[ProductImage] = productImageDecoder
}
