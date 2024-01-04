package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.ApplicationCharge
import com.moyiecomm.shopify.api.json.billing.ApplicationCharge.applicationChargeDecoder
import io.circe.Decoder

case class GetApplicationChargeById(id: Long, override val config: Config) extends GetRequest[ApplicationCharge](config) {
  override val path: String                                = s"application_charges/$id.json"
  override val responseDecoder: Decoder[ApplicationCharge] = applicationChargeDecoder
}
