package com.moyiecomm.shopify.api.requests.analytics

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.analytics.Report
import com.moyiecomm.shopify.api.json.analytics.Report.reportDecoder
import com.moyiecomm.shopify.api.json.analytics.Report.reportEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateReport(report: Report, override val config: Config) extends PostRequest[Report, Report](report, config) {
  override val path: String                     = "reports.json"
  override val requestEncoder: Encoder[Report]  = reportEncoder
  override val responseDecoder: Decoder[Report] = reportDecoder
}
