package com.moyiecomm.shopify.api.shared

import com.moyiecomm.shopify.request.ApiRequest.EmptyBody
import com.moyiecomm.shopify.request.ApiRequest.RequestEntity
import com.moyiecomm.shopify.request.ShopifyRequest
import io.circe.generic.auto._
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Method

abstract class DeleteByIdRequest extends ShopifyRequest[EmptyBody.type, IgnoreResponse.type] {

  override def method: Method = Method.DELETE

  override def body: RequestEntity = EmptyBody
}
