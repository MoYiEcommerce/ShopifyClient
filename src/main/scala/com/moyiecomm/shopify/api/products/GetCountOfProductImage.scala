package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfProductImage(productId: Long)(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = s"/products/$productId/images/count.json"
}
