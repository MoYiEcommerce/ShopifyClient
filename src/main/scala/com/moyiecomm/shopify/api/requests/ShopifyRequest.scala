package com.moyiecomm.shopify.api.requests

import com.moyiecomm.shopify.api.ApiResponse.{ApiResponse, Error}
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe
import sttp.client3.{DeserializationException, HttpError, Request, Response, ResponseException, SttpBackend}

trait ShopifyRequest[Req, Rep] {

  val config: Config

  val path: String

  def fullPath = s"${config.apiPathPrefix}/$path"

  def request: Request[Either[ResponseException[String, circe.Error], Rep], Any]

  private def finalRequest: Request[ApiResponse[Rep], Any] =
    request.auth
      .basic(config.apiKeyId, config.apiKeySecret)
      .mapResponse {
        case Left(error) =>
          error match {
            case HttpError(body, statusCode) =>
              ApiResponse(Left(Error(message = body, errorCode = "")))
            case DeserializationException(body, error) =>
              ApiResponse(Left(Error(message = error.getMessage, errorCode = "")))
          }
        case Right(entity) =>
          ApiResponse(Right(entity))
      }

  def send[F[_], P]()(implicit backend: SttpBackend[F, P]): F[Response[ApiResponse[Rep]]] = {
    finalRequest.send(backend)
  }
}

object ShopifyRequest {
  case class Config(
      apiKeyId: String,
      apiKeySecret: String,
      shopUrl: String,
      adminApiVersion: String
  ) {
    val apiPathPrefix: String   = s"$shopUrl/admin/api/$adminApiVersion"
    val adminPathPrefix: String = "/admin"
  }

  object Config {
    def load(config: com.typesafe.config.Config): Config = {
      val apiKeyId        = config.getString("apiKeyId")
      val apiKeySecret    = config.getString("apiKeySecret")
      val shopUrl         = config.getString("shopUrl")
      val adminApiVersion = config.getString("adminApiVersion")
      Config(
        apiKeyId = apiKeyId,
        apiKeySecret = apiKeySecret,
        shopUrl = shopUrl,
        adminApiVersion = adminApiVersion
      )
    }
  }
}
