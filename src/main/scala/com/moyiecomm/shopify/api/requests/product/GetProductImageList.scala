package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.json.product.ProductImage
import com.moyiecomm.shopify.api.json.product.ProductImage.productImageListDecoder
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import io.circe.Decoder

case class GetProductImageList(productId: Long, override val config: Config) extends GetRequest[List[ProductImage]](config) {

  override val path: String                                 = s"/products/$productId/images.json"
  override val responseDecoder: Decoder[List[ProductImage]] = productImageListDecoder
}
