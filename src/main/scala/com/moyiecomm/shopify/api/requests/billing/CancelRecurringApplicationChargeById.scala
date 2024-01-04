package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.DeleteRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

case class CancelRecurringApplicationChargeById(id: Long, override val config: Config) extends DeleteRequest(config) {
  override val path: String = s"recurring_application_charges/$id.json"
}
