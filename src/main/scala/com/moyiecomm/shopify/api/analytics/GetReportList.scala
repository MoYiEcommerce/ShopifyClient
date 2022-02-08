package com.moyiecomm.shopify.api.analytics

import com.moyiecomm.shopify.api.analytics.models.Report
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetReportList()(implicit val apiConfig: ApiConfig) extends GetItemRequest[List[Report]] {
  override def path: String = "/reports.json"
}
