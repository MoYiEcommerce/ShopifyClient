package com.moyiecomm.shopify.api.marketingEvent

import com.moyiecomm.shopify.api.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfMarketingEvent()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = "/marketing_events/count.json"
}
