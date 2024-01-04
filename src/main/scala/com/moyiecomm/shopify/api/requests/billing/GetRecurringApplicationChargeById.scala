package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.RecurringApplicationCharge
import com.moyiecomm.shopify.api.json.billing.RecurringApplicationCharge.recurringApplicationChargeDecoder
import io.circe.Decoder

case class GetRecurringApplicationChargeById(id: Long, override val config: Config)
    extends GetRequest[RecurringApplicationCharge](config) {
  override val path: String                                         = s"recurring_application_charges/$id.json"
  override val responseDecoder: Decoder[RecurringApplicationCharge] = recurringApplicationChargeDecoder
}
