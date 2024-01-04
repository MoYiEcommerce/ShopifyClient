package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.ApplicationCredit
import com.moyiecomm.shopify.api.json.billing.ApplicationCredit.applicationCreditListDecoder
import io.circe.Decoder

case class GetApplicationCreditList(override val config: Config) extends GetRequest[List[ApplicationCredit]](config) {
  override val path: String                                      = "application_credits.json"
  override val responseDecoder: Decoder[List[ApplicationCredit]] = applicationCreditListDecoder
}
