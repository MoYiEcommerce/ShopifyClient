package com.moyiecomm.shopify.api.shared

import com.moyiecomm.shopify.request.ApiRequest
import com.moyiecomm.shopify.request.ApiRequest.EmptyBody
import com.moyiecomm.shopify.request.ShopifyRequest
import io.circe.Decoder
import io.circe.generic.auto._
import sttp.client3.circe._
import sttp.model.Method

abstract class GetItemRequest[RESP]()(implicit responseBodyDecoder: Decoder[RESP]) extends ShopifyRequest[EmptyBody.type, RESP] {
  override def method: Method = Method.GET

  override def body: ApiRequest.RequestEntity = EmptyBody
}
