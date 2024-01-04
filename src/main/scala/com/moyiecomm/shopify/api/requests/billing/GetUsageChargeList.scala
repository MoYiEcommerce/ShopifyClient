package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.UsageCharge
import com.moyiecomm.shopify.api.json.billing.UsageCharge.usageChargeListDecoder
import io.circe.Decoder

case class GetUsageChargeList(recurringApplicationChargeId: Long, override val config: Config)
    extends GetRequest[List[UsageCharge]](config) {
  override val path: String = s"recurring_application_charges/$recurringApplicationChargeId/usage_charges.json"
  override val responseDecoder: Decoder[List[UsageCharge]] = usageChargeListDecoder
}
