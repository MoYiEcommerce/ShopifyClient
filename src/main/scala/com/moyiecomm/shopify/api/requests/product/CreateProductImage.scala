package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.builder.RequestBuilder
import com.moyiecomm.shopify.api.json.product.ProductImage
import com.moyiecomm.shopify.api.json.product.ProductImage.{productImageDecoder, productImageEncoder}
import com.moyiecomm.shopify.api.requests.{PostRequest, ShopifyRequest}
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe.{Decoder, Encoder}

case class CreateProductImage(productImage: ProductImage, override val config: Config)
    extends PostRequest[ProductImage, ProductImage](productImage, config) {

  override val path: String                           = s"products/${productImage.productId}/images.json"
  override val requestEncoder: Encoder[ProductImage]  = productImageEncoder
  override val responseDecoder: Decoder[ProductImage] = productImageDecoder
}
