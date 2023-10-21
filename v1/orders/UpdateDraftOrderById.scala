package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.orders.models.DraftOrder
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import DraftOrder.{draftOrderDecoder, draftOrderEncoder}
import sttp.model.Method

case class UpdateDraftOrderById(draftOrder: DraftOrder)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest(draftOrder)(draftOrderEncoder, draftOrderDecoder) {
  override def method: Method = Method.PUT
  override def path: String = {
    require(draftOrder.id.nonEmpty, "Draft order id can't be empty")
    s"/draft_orders/${draftOrder.id.getOrElse("")}.json"
  }
}
