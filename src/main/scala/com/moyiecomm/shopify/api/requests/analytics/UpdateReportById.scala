package com.moyiecomm.shopify.api.requests.analytics

import com.moyiecomm.shopify.api.builder.PutRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.analytics.Report
import com.moyiecomm.shopify.api.json.analytics.Report.reportDecoder
import com.moyiecomm.shopify.api.json.analytics.Report.reportEncoder
import io.circe.Decoder
import io.circe.Encoder

case class UpdateReportById(report: Report, override val config: Config) extends PutRequest[Report, Report](report, config) {
  override val path: String = {
    require(report.id.nonEmpty, "Report id can't be empty")
    s"/reports/${report.id.getOrElse("")}.json"
  }
  override val requestEncoder: Encoder[Report]  = reportEncoder
  override val responseDecoder: Decoder[Report] = reportDecoder
}
