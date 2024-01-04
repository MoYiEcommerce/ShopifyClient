package com.moyiecomm.shopify.api.requests.billing

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.billing.ApplicationCharge
import com.moyiecomm.shopify.api.json.billing.ApplicationCharge.applicationChargeListDecoder
import io.circe.Decoder

case class GetApplicationChargeList(sinceId: Option[Long], override val config: Config)
    extends GetRequest[List[ApplicationCharge]](config) {
  override val path: String = sinceId match {
    case Some(id) => s"application_charges.json?since_id=$id"
    case None     => "application_charges.json"
  }
  override val responseDecoder: Decoder[List[ApplicationCharge]] = applicationChargeListDecoder
}
