package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.OrderRisk
import com.moyiecomm.shopify.api.orders.models.OrderRisk.{orderRiskDecoder, orderRiskEncoder}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class UpdateOrderRiskById(orderRisk: OrderRisk)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[OrderRisk, OrderRisk](orderRisk)(orderRiskEncoder, orderRiskDecoder) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(orderRisk.id.nonEmpty, "Order risk id can't be empty")
    s"/orders/${orderRisk.orderId}/risks/${orderRisk.id.getOrElse("")}.json"
  }
}
