package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.ApplicationCharge
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import ApplicationCharge.applicationChargeDecoder

case class GetApplicationChargeById(id: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[ApplicationCharge]()(applicationChargeDecoder) {
  override def path: String = s"/application_charges/$id.json"
}
