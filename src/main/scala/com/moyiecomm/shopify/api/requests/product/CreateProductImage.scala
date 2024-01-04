package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.product.ProductImage
import com.moyiecomm.shopify.api.json.product.ProductImage.productImageDecoder
import com.moyiecomm.shopify.api.json.product.ProductImage.productImageEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateProductImage(productImage: ProductImage, override val config: Config)
    extends PostRequest[ProductImage, ProductImage](productImage, config) {

  override val path: String                           = s"products/${productImage.productId}/images.json"
  override val requestEncoder: Encoder[ProductImage]  = productImageEncoder
  override val responseDecoder: Decoder[ProductImage] = productImageDecoder
}
