package com.moyiecomm.shopify.api.v1.analytics

import com.moyiecomm.shopify.api.v1.analytics.models.Report
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Report.reportListDecoder

case class GetReportList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[Report]]()(reportListDecoder) {
  override def path: String = "/reports.json"
}
