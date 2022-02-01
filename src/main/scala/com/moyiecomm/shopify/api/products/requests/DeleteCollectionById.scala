package com.moyiecomm.shopify.api.products.requests

import com.moyiecomm.shopify.request.ApiRequest.{EmptyBody, RequestEntity}
import com.moyiecomm.shopify.request.{ApiConfig, ShopifyRequest}
import io.circe.generic.auto._
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Method

case class DeleteCollectionById(id: Long)(implicit val apiConfig: ApiConfig)
    extends ShopifyRequest[EmptyBody.type, IgnoreResponse.type] {

  override def method: Method = Method.DELETE

  override def path: String = s"/collect/$id.json"

  override def body: RequestEntity = EmptyBody
}
