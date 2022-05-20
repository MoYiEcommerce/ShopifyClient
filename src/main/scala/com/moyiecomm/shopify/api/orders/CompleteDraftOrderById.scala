package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.DraftOrder
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import DraftOrder.draftOrderDecoder
import sttp.model.Method

case class CompleteDraftOrderById(draftOrderId: Long)(implicit val apiConfig: ApiConfig)
    extends ApiRequest[Null, DraftOrder](None, Some(draftOrderDecoder)) {
  override def body: Null = null

  override def method: Method = Method.PUT

  override def path: String = s"/draft_orders/$draftOrderId/complete.json"
}
