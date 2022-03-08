package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.Product
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import Product.{productEncoder, productDecoder}

case class UpdateProductById(product: Product)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Product, Product](product)(circeBodySerializer(productEncoder), productDecoder) {
  override def method: Method = Method.PUT
  override def path: String = {
    require(product.id.nonEmpty, "Product id can't be empty")
    s"/products/${product.id.getOrElse("")}.json"
  }
}
