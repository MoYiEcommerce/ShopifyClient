package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.OrderRisk
import com.moyiecomm.shopify.api.orders.models.OrderRisk.orderRiskListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetOrderRiskList(orderId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[OrderRisk]]()(orderRiskListDecoder) {
  override def path: String = s"/orders/$orderId/risks.json"
}
