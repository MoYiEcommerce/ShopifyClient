package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.json.product.ProductImage
import com.moyiecomm.shopify.api.json.product.ProductImage.productImageDecoder
import com.moyiecomm.shopify.api.requests.GetRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.Decoder

case class GetProductImageById(productId: Long, imageId: Long, override val config: Config)
    extends GetRequest[ProductImage](config) {

  override val path: String                           = s"/products/$productId/images/$imageId.json"
  override val responseDecoder: Decoder[ProductImage] = productImageDecoder
}
