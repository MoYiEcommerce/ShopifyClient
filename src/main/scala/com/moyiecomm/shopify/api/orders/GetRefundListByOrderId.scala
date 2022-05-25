package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.Refund
import com.moyiecomm.shopify.api.orders.models.Refund.refundListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetRefundListByOrderId(orderId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[Refund]]()(refundListDecoder) {
  override def path: String = s"/orders/$orderId/refunds.json"
}
