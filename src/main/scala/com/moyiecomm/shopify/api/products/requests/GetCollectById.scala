package com.moyiecomm.shopify.api.products.requests

import com.moyiecomm.shopify.api.products.Collect
import com.moyiecomm.shopify.request.ApiRequest.{EmptyBody, RequestEntity}
import com.moyiecomm.shopify.request.{ApiConfig, ShopifyRequest}
import io.circe.generic.auto._
import sttp.client3._
import sttp.client3.circe._
import sttp.model.Method

object GetCollectById {
  val request = (uriPrefix: String, id: Long) =>
    basicRequest
      .get(uri"$uriPrefix/collects/$id.json")
      .response(asJson[Collect])

}

case class GetCollectById(id: Long)(implicit val apiConfig: ApiConfig) extends ShopifyRequest[EmptyBody.type, Collect] {
  override def method: Method = Method.GET

  override def path: String = s"/collects/$id.json"

  override def body: RequestEntity = EmptyBody
}
