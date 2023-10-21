package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.orders.models.DraftOrder
import com.moyiecomm.shopify.api.v1.orders.models.DraftOrder.{draftOrderDecoder, draftOrderEncoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreateDraftOrder(draftOrder: DraftOrder)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[DraftOrder, DraftOrder](draftOrder)(draftOrderEncoder, draftOrderDecoder) {
  override def method: Method = Method.POST

  override def path: String = "/draft_orders.json"
}
