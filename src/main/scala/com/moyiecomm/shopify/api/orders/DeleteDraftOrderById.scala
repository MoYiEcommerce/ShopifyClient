package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteDraftOrderById(draftOrderId: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/draft_orders/$draftOrderId.json"
}
