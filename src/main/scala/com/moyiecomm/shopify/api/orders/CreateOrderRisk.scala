package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.OrderRisk
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import OrderRisk.{orderRiskDecoder, orderRiskEncoder}
import sttp.model.Method

case class CreateOrderRisk(orderRisk: OrderRisk)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[OrderRisk, OrderRisk](orderRisk)(orderRiskEncoder, orderRiskDecoder) {
  override def method: Method = Method.POST

  override def path: String = s"/orders/${orderRisk.orderId}/risks.json"
}
