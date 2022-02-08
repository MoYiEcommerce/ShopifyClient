package com.moyiecomm.shopify.api.analytics

import com.moyiecomm.shopify.api.analytics.models.Report
import com.moyiecomm.shopify.api.analytics.models.Report._
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.client3.circe._
import sttp.model.Method

case class UpdateReportById(report: Report)(implicit val apiConfig: ApiConfig) extends UpsertItemRequest[Report, Report](report) {
  override def method: Method = Method.PUT

  override def path: String = s"/reports/${report.id}.json"
}
