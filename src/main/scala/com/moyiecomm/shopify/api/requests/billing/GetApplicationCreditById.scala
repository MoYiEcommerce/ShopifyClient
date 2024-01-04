package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.ApplicationCredit
import com.moyiecomm.shopify.api.json.billing.ApplicationCredit.applicationCreditDecoder
import io.circe.Decoder

case class GetApplicationCreditById(id: Long, override val config: Config) extends GetRequest[ApplicationCredit](config) {
  override val path: String                                = s"application_credits/$id.json"
  override val responseDecoder: Decoder[ApplicationCredit] = applicationCreditDecoder
}
