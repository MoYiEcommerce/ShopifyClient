package com.moyiecomm.shopify.api.analytics

import com.moyiecomm.shopify.api.analytics.models.Report
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import Report.{reportEncoder, reportDecoder}

case class CreateReport(report: Report)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Report, Report](report)(circeBodySerializer(reportEncoder), reportDecoder) {
  override def method: Method = Method.POST

  override def path: String = "/reports.json"
}
