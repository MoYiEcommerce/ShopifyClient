package com.moyiecomm.shopify.request

import io.circe._
import sttp.client3._
import sttp.client3.circe._
import sttp.model.{MediaType, Method}

abstract class ApiRequest[Req, Rep](
    requestBodyEncoder: Option[Encoder[Req]],
    responseBodyDecoder: Option[Decoder[Rep]]
) {

  def body: Req
  def method: Method
  def path: String
  def apiConfig: ApiConfig

  def fullPath = s"http://${apiConfig.shopUrl}${apiConfig.apiPathPrefix}$path"

  def request: RequestT[Identity, Any, Any] = {
    val requestBody: RequestBody[Any] = requestBodyEncoder match {
      case Some(reqEncoder) => circeBodySerializer(reqEncoder, Printer.noSpaces)(body)
      case None             => NoBody
    }

    val responseAs: ResponseAs[Any, Any] = responseBodyDecoder match {
      case Some(repDecoder) =>
        implicit val rpd: Decoder[Rep] = repDecoder
        asJson[Rep]
      case None =>
        IgnoreResponse
    }

    basicRequest
      .method(method, uri"$fullPath")
      .copy(body = requestBody)
      .contentType(MediaType.ApplicationJson.charset("UTF-8"))
      .auth
      .basic(apiConfig.apiKeyId, apiConfig.apiKeySecret)
      .response(responseAs)
  }

  def response[F[_], P]()(implicit
      sttpBackend: SttpBackend[F, P]
  ): F[Response[Any]] =
    request.send(sttpBackend)
}
