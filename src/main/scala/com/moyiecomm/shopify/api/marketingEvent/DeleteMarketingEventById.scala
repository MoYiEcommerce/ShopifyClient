package com.moyiecomm.shopify.api.marketingEvent

import com.moyiecomm.shopify.api.shared.DeleteByIdRequest
import com.moyiecomm.shopify.request.ApiConfig

case class DeleteMarketingEventById(marketingEventId: Long)(implicit val apiConfig: ApiConfig) extends DeleteByIdRequest {
  override def path: String = s"/marketing_events/$marketingEventId.json"
}
