package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.orders.models.Refund
import com.moyiecomm.shopify.api.v1.orders.models.Refund.refundDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetRefundById(orderId: Long, refundId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[Refund]()(refundDecoder) {
  override def path: String = s"/orders/$orderId/refunds/$refundId.json"
}
