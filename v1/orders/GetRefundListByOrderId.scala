package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.orders.models.Refund
import com.moyiecomm.shopify.api.v1.orders.models.Refund.refundListDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetRefundListByOrderId(orderId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[Refund]]()(refundListDecoder) {
  override def path: String = s"/orders/$orderId/refunds.json"
}
