package com.moyiecomm.shopify.api.shared

import com.moyiecomm.shopify.request.ApiRequest.Entity
import com.moyiecomm.shopify.request.ShopifyRequest
import io.circe.Decoder
import sttp.client3._

abstract class UpsertItemRequest[BODY, RESP](body: BODY)(implicit
    requestBodySerializer: BodySerializer[BODY],
    responseBodyDecoder: Decoder[RESP]
) extends ShopifyRequest[BODY, RESP] {
  override def body: Entity[BODY] = Entity(body)
}
