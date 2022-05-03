package com.moyiecomm.shopify.api.shared

import com.moyiecomm.shopify.api.shared.models.Errors
import com.moyiecomm.shopify.api.shared.models.Errors.errorsDecoder
import com.moyiecomm.shopify.request.{ApiConfig, ApiRequest}
import io.circe.{Decoder, Encoder}

abstract class UpsertItemRequest[BODY, RESP](val body: BODY)(implicit
    requestBodyEncoder: Encoder[BODY],
    responseBodyDecoder: Decoder[RESP]
) extends ApiRequest[BODY, RESP, Errors](Some(requestBodyEncoder), Some(responseBodyDecoder), errorsDecoder) {}
