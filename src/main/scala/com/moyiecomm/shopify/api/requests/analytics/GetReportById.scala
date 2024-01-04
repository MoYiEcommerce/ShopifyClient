package com.moyiecomm.shopify.api.requests.analytics

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.analytics.Report
import com.moyiecomm.shopify.api.json.analytics.Report.reportDecoder
import io.circe.Decoder

case class GetReportById(id: Long, override val config: Config) extends GetRequest[Report](config) {
  override val path: String                     = s"/reports/$id.json"
  override val responseDecoder: Decoder[Report] = reportDecoder
}
