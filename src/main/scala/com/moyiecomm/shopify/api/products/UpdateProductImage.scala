package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.ProductImage
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import ProductImage.{productImageEncoder, productImageDecoder}

case class UpdateProductImage(productId: Long, image: ProductImage)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ProductImage, ProductImage](image) {
  override def method: Method = Method.PUT

  override def path: String = s"/products/$productId/images/${image.id}.json"
}
