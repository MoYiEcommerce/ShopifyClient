package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.Refund
import com.moyiecomm.shopify.api.orders.models.Refund.refundDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetRefundById(orderId: Long, refundId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[Refund]()(refundDecoder) {
  override def path: String = s"/orders/$orderId/refunds/$refundId.json"
}
