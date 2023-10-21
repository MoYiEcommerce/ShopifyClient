package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.Product
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import Product.{productEncoder, productDecoder}

case class CreateProduct(product: Product)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Product, Product](product)(productEncoder, productDecoder) {
  override def method: Method = Method.POST
  override def path: String   = "/products.json"
}
