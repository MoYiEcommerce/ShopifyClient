package com.moyiecomm.shopify.api.events

import com.moyiecomm.shopify.api.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfWebHooks()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = "/webhooks/count.json"
}
