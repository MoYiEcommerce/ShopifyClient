package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.UsageCharge
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetUsageChargeList(recurringApplicationChargeId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[UsageCharge]] {
  override def path: String = s"/recurring_application_charges/$recurringApplicationChargeId/usage_charges.json"
}
