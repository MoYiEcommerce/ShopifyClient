package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.ProductImage
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import ProductImage.{productImageEncoder, productImageDecoder}

case class UpdateProductImage(image: ProductImage)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ProductImage, ProductImage](image)(circeBodySerializer(productImageEncoder), productImageDecoder) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(image.id.nonEmpty, "Image id can not be empty")
    s"/products/${image.productId}/images/${image.id.getOrElse("")}.json"
  }
}
