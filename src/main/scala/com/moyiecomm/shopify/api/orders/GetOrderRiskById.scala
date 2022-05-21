package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.OrderRisk
import com.moyiecomm.shopify.api.orders.models.OrderRisk.orderRiskDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetOrderRiskById(orderId: Long, orderRiskId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[OrderRisk]()(orderRiskDecoder) {
  override def path: String = s"/orders/$orderId/risks/$orderRiskId.json"
}
