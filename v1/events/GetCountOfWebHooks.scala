package com.moyiecomm.shopify.api.v1.events

import com.moyiecomm.shopify.api.v1.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfWebHooks()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = "/webhooks/count.json"
}
