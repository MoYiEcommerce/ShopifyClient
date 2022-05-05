package com.moyiecomm.shopify.api.discounts

import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import sttp.model.Method

case class GetDiscountCodeLocation(code: String)(implicit val apiConfig: ApiConfig) extends ApiRequest[Null, Null](None, None) {
  override def body: Null = null

  override def method: Method = Method.GET

  override def path: String = s"/discount_codes/lookup.json?code=$code"
}
