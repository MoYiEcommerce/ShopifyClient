package com.moyiecomm.shopify.api.shared

import com.moyiecomm.shopify.api.shared.models.Errors
import com.moyiecomm.shopify.api.shared.models.Errors.errorsDecoder
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import io.circe.Decoder
import sttp.model.Method

abstract class GetItemRequest[RESP]()(implicit
    responseBodyDecoder: Decoder[RESP]
) extends ApiRequest[Null, RESP, Errors](None, Some(responseBodyDecoder), errorsDecoder) {
  override def method: Method = Method.GET

  override def body: Null = null
}
