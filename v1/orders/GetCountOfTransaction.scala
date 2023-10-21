package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfTransaction(orderId: Long)(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = s"/orders/$orderId/transactions/count.json"
}
