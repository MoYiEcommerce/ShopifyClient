package com.moyiecomm.shopify.api.requests.analytics

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.analytics.Report
import com.moyiecomm.shopify.api.json.analytics.Report.reportListDecoder
import io.circe.Decoder

case class GetReportList(override val config: Config) extends GetRequest[List[Report]](config) {
  override val path: String                           = "/reports.json"
  override val responseDecoder: Decoder[List[Report]] = reportListDecoder
}
