package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.ApplicationCharge
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import ApplicationCharge.{applicationChargeEncoder, applicationChargeDecoder}

case class CreateApplicationCharge(applicationCharge: ApplicationCharge)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ApplicationCharge, ApplicationCharge](applicationCharge)(
      circeBodySerializer(applicationChargeEncoder),
      applicationChargeDecoder
    ) {
  override def method: Method = Method.POST

  override def path: String = "/application_charges.json"
}
