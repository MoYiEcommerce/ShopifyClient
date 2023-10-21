package com.moyiecomm.shopify.api.v1.billing

import com.moyiecomm.shopify.api.v1.billing.models.UsageCharge
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import UsageCharge._

case class GetUsageChargeById(recurringApplicationChargeId: Long, usageChargeId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[UsageCharge]()(usageChargeDecoder) {
  override def path: String = s"/recurring_application_charges/$recurringApplicationChargeId/usage_charges/$usageChargeId.json"
}
