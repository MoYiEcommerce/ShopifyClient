package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.UsageCharge
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import UsageCharge._

case class CreateUsageCharge(recurringApplicationChargeId: Long, usageCharge: UsageCharge)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[UsageCharge, UsageCharge](usageCharge) {
  override def method: Method = Method.POST

  override def path: String = s"/recurring_application_charges/$recurringApplicationChargeId/usage_charges.json"
}
