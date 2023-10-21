package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.orders.models.DraftOrder
import com.moyiecomm.shopify.api.v1.orders.models.DraftOrder.draftOrderDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetDraftOrderById(draftOrderId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[DraftOrder]()(draftOrderDecoder) {
  override def path: String = s"/draft_orders/$draftOrderId.json"
}
