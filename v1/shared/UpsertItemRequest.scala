package com.moyiecomm.shopify.api.v1.shared

import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import io.circe.{Decoder, Encoder}

abstract class UpsertItemRequest[BODY, RESP](val body: BODY)(implicit
    requestBodyEncoder: Encoder[BODY],
    responseBodyDecoder: Decoder[RESP]
) extends ApiRequest[BODY, RESP](Some(requestBodyEncoder), Some(responseBodyDecoder)) {}
