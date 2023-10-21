package com.moyiecomm.shopify.api.v1.analytics

import com.moyiecomm.shopify.api.v1.analytics.models.Report
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import Report.{reportEncoder, reportDecoder}

case class CreateReport(report: Report)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Report, Report](report)(reportEncoder, reportDecoder) {
  override def method: Method = Method.POST

  override def path: String = "/reports.json"
}
