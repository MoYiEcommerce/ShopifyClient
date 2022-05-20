package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfDraftOrder()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = "/draft_orders/count.json"
}
