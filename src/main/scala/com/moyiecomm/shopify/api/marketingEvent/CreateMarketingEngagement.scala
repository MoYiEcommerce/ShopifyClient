package com.moyiecomm.shopify.api.marketingEvent

import com.moyiecomm.shopify.api.marketingEvent.models.Engagement
import com.moyiecomm.shopify.api.marketingEvent.models.Engagement.{engagementListDecoder, engagementListEncoder}
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class CreateMarketingEngagement(marketingEventId: Long, engagementList: List[Engagement])(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[List[Engagement], List[Engagement]](engagementList)(engagementListEncoder, engagementListDecoder) {
  override def method: Method = Method.POST

  override def path: String = s"/marketing_events/$marketingEventId/engagements.json"
}
