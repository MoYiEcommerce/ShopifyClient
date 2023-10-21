package com.moyiecomm.shopify.api.v1.analytics

import com.moyiecomm.shopify.api.v1.analytics.models.Report
import com.moyiecomm.shopify.api.v1.analytics.models.Report.{reportEncoder, reportDecoder}
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method

case class UpdateReportById(report: Report)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Report, Report](report)(reportEncoder, reportDecoder) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(report.id.nonEmpty, "Report id can't be empty")
    s"/reports/${report.id.getOrElse("")}.json"
  }
}
