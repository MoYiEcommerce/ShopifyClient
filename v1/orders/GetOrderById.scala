package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.orders.models.Order
import com.moyiecomm.shopify.api.v1.orders.models.Order.orderDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetOrderById(orderId: Long)(implicit val apiConfig: ApiConfig) extends GetItemRequest[Order]()(orderDecoder) {
  override def path: String = s"/orders/$orderId.json"
}
