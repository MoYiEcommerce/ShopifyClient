package com.moyiecomm.shopify.request

import com.moyiecomm.shopify.request.ApiRequest.EmptyBody
import com.moyiecomm.shopify.request.ApiRequest.Entity
import io.circe
import io.circe.Decoder
import sttp.client3._
import sttp.client3.circe.asJson
import sttp.model.Method
import sttp.model._

abstract class ShopifyRequest[Req, Rep]()(implicit
    requestBodySerializer: BodySerializer[Req],
    responseBodyDecoder: Decoder[Rep]
) extends ApiRequest {

  def fullPath = s"http://${apiConfig.shopUrl}${apiConfig.apiPathPrefix}$path"

  val request = {
    val uri: Uri = {
      uri"$fullPath"
    }

    val requestWithMethod = method match {
      case Method.GET    => basicRequest.get(uri)
      case Method.POST   => basicRequest.post(uri)
      case Method.DELETE => basicRequest.delete(uri)
      case Method.PUT    => basicRequest.put(uri)
    }

    val requestWithBody = body match {
      case entity: Entity[Req] =>
        requestWithMethod.body(entity.entity)
      case EmptyBody =>
        requestWithMethod
    }

    requestWithBody
      .response(asJson[Rep])
      .auth
      .basic(apiConfig.apiKeyId, apiConfig.apiKeySecret)
  }

  def response[F[_], P]()(implicit
      sttpBackend: SttpBackend[F, P]
  ): F[Response[Either[ResponseException[String, circe.Error], Rep]]] =
    request.send(sttpBackend)
}
