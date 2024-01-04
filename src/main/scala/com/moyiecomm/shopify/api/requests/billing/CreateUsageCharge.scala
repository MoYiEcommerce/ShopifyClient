package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.PostRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.UsageCharge
import com.moyiecomm.shopify.api.json.billing.UsageCharge.usageChargeDecoder
import com.moyiecomm.shopify.api.json.billing.UsageCharge.usageChargeEncoder
import io.circe.Decoder
import io.circe.Encoder

case class CreateUsageCharge(usageCharge: UsageCharge, override val config: Config)
    extends PostRequest[UsageCharge, UsageCharge](usageCharge, config) {

  override val path: String = {
    require(usageCharge.recurringApplicationChargeId.nonEmpty, "recurringApplicationChargeId can't be empty")
    s"/recurring_application_charges/${usageCharge.recurringApplicationChargeId.getOrElse("")}/usage_charges.json"
  }
  override val requestEncoder: Encoder[UsageCharge]  = usageChargeEncoder
  override val responseDecoder: Decoder[UsageCharge] = usageChargeDecoder
}
