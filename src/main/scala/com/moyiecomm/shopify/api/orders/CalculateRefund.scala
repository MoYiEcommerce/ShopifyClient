package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.Refund
import com.moyiecomm.shopify.api.orders.models.Refund.{refundDecoder, refundEncoder}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CalculateRefund(refund: Refund)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Refund, Refund](refund)(refundEncoder, refundDecoder) {
  override def method: Method = Method.POST

  override def path: String = {
    require(refund.orderId.nonEmpty, "order Id can't be empty")
    s"/orders/${refund.orderId.getOrElse("")}/refunds/calculate.json"
  }
}
