package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.Product
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import Product.{productEncoder, productDecoder}

case class UpdateProductById(product: Product)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Product, Product](product)(productEncoder, productDecoder) {
  override def method: Method = Method.PUT
  override def path: String = {
    require(product.id.nonEmpty, "Product id can't be empty")
    s"/products/${product.id.getOrElse("")}.json"
  }
}
