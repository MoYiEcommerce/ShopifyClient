package com.moyiecomm.shopify.api.billing

import com.moyiecomm.shopify.request.ApiRequest.EmptyBody
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest, ShopifyRequest}
import sttp.model.Method
import io.circe.generic.auto._
import sttp.client3._
import sttp.client3.circe._

case class UpdateCappedAmount(recurringChargeId: Int, cappedAmount: Int)(implicit val apiConfig: ApiConfig)
    extends ShopifyRequest[EmptyBody.type, IgnoreResponse.type] {
  override def method: Method = Method.PUT

  override def body: ApiRequest.RequestEntity = EmptyBody

  override def path: String =
    s"/recurring_application_charges/$recurringChargeId/customize.json?recurring_application_charge[capped_amount]=$cappedAmount"
}
