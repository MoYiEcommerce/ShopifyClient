package com.moyiecomm.shopify.api.v1.analytics

import com.moyiecomm.shopify.api.v1.analytics.models.Report
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Report.reportDecoder

case class GetReportById(id: Long)(implicit val apiConfig: ApiConfig) extends GetItemRequest[Report]()(reportDecoder) {
  override def path: String = s"/reports/$id.json"
}
