package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.Product
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Product.productDecoder

case class GetProductById(id: Long)(implicit val apiConfig: ApiConfig) extends GetItemRequest[Product]()(productDecoder) {
  override def path: String = s"/products/$id.json"

}
