package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.DraftOrder
import com.moyiecomm.shopify.api.orders.models.DraftOrder.draftOrderDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetDraftOrderById(draftOrderId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[DraftOrder]()(draftOrderDecoder) {
  override def path: String = s"/draft_orders/$draftOrderId.json"
}
