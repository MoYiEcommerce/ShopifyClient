package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.UsageCharge
import com.moyiecomm.shopify.api.json.billing.UsageCharge.usageChargeDecoder
import io.circe.Decoder

case class GetUsageChargeById(recurringApplicationChargeId: Long, usageChargeId: Long, override val config: Config)
    extends GetRequest[UsageCharge](config) {
  override val path: String = s"recurring_application_charges/$recurringApplicationChargeId/usage_charges/$usageChargeId.json"
  override val responseDecoder: Decoder[UsageCharge] = usageChargeDecoder
}
