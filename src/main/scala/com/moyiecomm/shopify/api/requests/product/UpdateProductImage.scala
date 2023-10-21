package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.json.product.ProductImage
import com.moyiecomm.shopify.api.json.product.ProductImage.{productImageDecoder, productImageEncoder}
import com.moyiecomm.shopify.api.requests.PutRequest
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.{Decoder, Encoder}

case class UpdateProductImage(image: ProductImage, override val config: Config)
    extends PutRequest[ProductImage, ProductImage](image, config) {

  override val path: String = {
    require(image.id.nonEmpty, "Image id can not be empty")
    s"/products/${image.productId}/images/${image.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[ProductImage]  = productImageEncoder
  override val responseDecoder: Decoder[ProductImage] = productImageDecoder
}
