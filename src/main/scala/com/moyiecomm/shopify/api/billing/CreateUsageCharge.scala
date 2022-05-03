package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.UsageCharge
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import UsageCharge.{usageChargeDecoder, usageChargeEncoder}

case class CreateUsageCharge(usageCharge: UsageCharge)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[UsageCharge, UsageCharge](usageCharge)(
      usageChargeEncoder,
      usageChargeDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = {
    require(usageCharge.recurringApplicationChargeId.nonEmpty, "recurringApplicationChargeId can't be empty")
    s"/recurring_application_charges/${usageCharge.recurringApplicationChargeId.getOrElse("")}/usage_charges.json"
  }
}
