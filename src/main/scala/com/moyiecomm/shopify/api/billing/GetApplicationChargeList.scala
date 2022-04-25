package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.api.billing.models.ApplicationCharge
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import ApplicationCharge.applicationChargeListDecoder

case class GetApplicationChargeList(sinceId: Option[Long])(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[ApplicationCharge]]()(applicationChargeListDecoder) {
  override def path: String = sinceId match {
    case Some(id) => s"/application_charges.json?since_id=$id"
    case None     => "/application_charges.json"
  }
}
