package com.moyiecomm.shopify.api.builder

import com.moyiecomm.shopify.api.builder.ApiResponse.ApiResponse
import com.moyiecomm.shopify.api.builder.ApiResponse.Error
import com.moyiecomm.shopify.api.builder.ApiResponse.Ignored
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import io.circe
import io.circe.Decoder
import io.circe.Encoder
import sttp.client3.DeserializationException
import sttp.client3.HttpError
import sttp.client3.Request
import sttp.client3.Response
import sttp.client3.ResponseException
import sttp.client3.SttpBackend
import sttp.client3.UriContext

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

abstract class GetRequest[Rep](val config: Config) extends ShopifyRequest[Ignored, Rep] {
  val responseDecoder: Decoder[Rep]

  override def request: Request[Either[ResponseException[String, circe.Error], Rep], Any] =
    RequestBuilder.getRequest[Rep](uri"$fullPath")(responseDecoder)
}

abstract class PostRequest[Req, Rep](requestBody: Req, val config: Config) extends ShopifyRequest[Req, Rep] {
  val requestEncoder: Encoder[Req]
  val responseDecoder: Decoder[Rep]

  override def request: Request[Either[ResponseException[String, circe.Error], Rep], Any] =
    RequestBuilder.postRequest[Req, Rep](uri"$fullPath", requestBody)(requestEncoder, responseDecoder)
}

abstract class PutRequest[Req, Rep](requestBody: Req, val config: Config) extends ShopifyRequest[Req, Rep] {
  val requestEncoder: Encoder[Req]
  val responseDecoder: Decoder[Rep]

  override def request: Request[Either[ResponseException[String, circe.Error], Rep], Any] =
    RequestBuilder.putRequest[Req, Rep](uri"$fullPath", requestBody)(requestEncoder, responseDecoder)
}

abstract class DeleteRequest(val config: Config) extends ShopifyRequest[Ignored, Ignored] {
  override def request: Request[Either[ResponseException[String, circe.Error], Ignored], Any] =
    RequestBuilder.deleteRequest(uri"$fullPath")
}

abstract class CountRequest(config: Config) extends GetRequest[Int](config) {
  override val responseDecoder: Decoder[Int] = Decoder.decodeInt
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
