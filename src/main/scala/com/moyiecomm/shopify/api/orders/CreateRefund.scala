package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.Refund
import com.moyiecomm.shopify.api.orders.models.Refund.{refundDecoder, refundEncoder}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreateRefund(orderId: Long, refund: Refund)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Refund, Refund](refund)(refundEncoder, refundDecoder) {
  override def method: Method = Method.POST

  override def path: String = s"/orders/$orderId/refunds.json"

}
