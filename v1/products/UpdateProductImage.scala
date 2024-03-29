package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.ProductImage
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import ProductImage.{productImageEncoder, productImageDecoder}

case class UpdateProductImage(image: ProductImage)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ProductImage, ProductImage](image)(productImageEncoder, productImageDecoder) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(image.id.nonEmpty, "Image id can not be empty")
    s"/products/${image.productId}/images/${image.id.getOrElse("")}.json"
  }
}
