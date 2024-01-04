package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.RecurringApplicationCharge
import com.moyiecomm.shopify.api.json.billing.RecurringApplicationCharge.recurringApplicationChargeListDecoder
import io.circe.Decoder

case class GetRecurringApplicationChargeList(override val config: Config)
    extends GetRequest[List[RecurringApplicationCharge]](config) {
  override val path: String                                               = "recurring_application_charges.json"
  override val responseDecoder: Decoder[List[RecurringApplicationCharge]] = recurringApplicationChargeListDecoder
}
