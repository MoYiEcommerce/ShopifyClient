package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.Product
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetProductList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[Product]] {
  override def path: String = "/products.json"
}
