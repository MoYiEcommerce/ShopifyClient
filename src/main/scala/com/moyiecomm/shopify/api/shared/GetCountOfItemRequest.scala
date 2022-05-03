package com.moyiecomm.shopify.api.shared

import com.moyiecomm.shopify.api.shared.models.Errors.errorsDecoder
import com.moyiecomm.shopify.api.shared.models.{CountOfRequestedItems, Errors}
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import io.circe.generic.semiauto._
import sttp.model.Method

abstract class GetCountOfItemRequest()
    extends ApiRequest[Null, CountOfRequestedItems, Errors](None, Some(deriveDecoder[CountOfRequestedItems]), errorsDecoder) {
  override def method: Method = Method.GET

  override def body: Null = null
}
