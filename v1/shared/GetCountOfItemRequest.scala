package com.moyiecomm.shopify.api.v1.shared

import com.moyiecomm.shopify.api.v1.shared.models.CountOfRequestedItems
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import io.circe.generic.semiauto._
import sttp.model.Method

abstract class GetCountOfItemRequest()
    extends ApiRequest[Null, CountOfRequestedItems](
      None,
      Some(deriveDecoder[CountOfRequestedItems])
    ) {
  override def method: Method = Method.GET

  override def body: Null = null
}
