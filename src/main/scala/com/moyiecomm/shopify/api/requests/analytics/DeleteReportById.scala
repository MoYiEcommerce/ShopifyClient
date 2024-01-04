package com.moyiecomm.shopify.api.requests.analytics

import com.moyiecomm.shopify.api.builder.DeleteRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class DeleteReportById(reportId: Long, override val config: Config) extends DeleteRequest(config) {
  override val path: String = s"/reports/$reportId.json"
}
