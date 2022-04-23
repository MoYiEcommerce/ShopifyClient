package com.moyiecomm.shopify.api.analytics

import com.moyiecomm.shopify.api.analytics.models.Report
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Report.reportDecoder

case class GetReportById(id: Long)(implicit val apiConfig: ApiConfig) extends GetItemRequest[Report]()(reportDecoder) {
  override def path: String = s"/reports/$id.json"
}
