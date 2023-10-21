package com.moyiecomm.shopify.api.v1.shared

import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import io.circe.Decoder
import sttp.model.Method

abstract class GetItemRequest[RESP]()(implicit
    responseBodyDecoder: Decoder[RESP]
) extends ApiRequest[Null, RESP](None, Some(responseBodyDecoder)) {
  override def method: Method = Method.GET

  override def body: Null = null
}
