package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.json.product.ProductImage
import com.moyiecomm.shopify.api.json.product.ProductImage.productImageDecoder
import com.moyiecomm.shopify.api.json.product.ProductImage.productImageEncoder
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import io.circe.Decoder
import io.circe.Encoder

case class UpdateProductImage(image: ProductImage, override val config: Config)
    extends PutRequest[ProductImage, ProductImage](image, config) {

  override val path: String = {
    require(image.id.nonEmpty, "Image id can not be empty")
    s"/products/${image.productId}/images/${image.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[ProductImage]  = productImageEncoder
  override val responseDecoder: Decoder[ProductImage] = productImageDecoder
}
