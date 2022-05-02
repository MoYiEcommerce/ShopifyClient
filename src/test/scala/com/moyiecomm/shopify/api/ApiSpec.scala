package com.moyiecomm.shopify.api

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock._

import java.time.ZonedDateTime
import scala.concurrent.Future
import scala.language.implicitConversions
import com.moyiecomm.shopify.MockServer
import com.moyiecomm.shopify.UnitSpec
import com.moyiecomm.shopify.request.{ApiConfig, ShopifyRequest}
import io.circe.Json
import io.circe._
import io.circe.parser._
import sttp.client3.{StringBody, SttpBackend}
import sttp.client3.asynchttpclient.future.AsyncHttpClientFutureBackend
import sttp.model.{Method, StatusCode}

trait ApiSpec extends UnitSpec with MockServer {
  implicit val apiConfig: ApiConfig =
    ApiConfig(
      apiKeyId = "testKeyId",
      apiKeySecret = "testKeySecret",
      shopUrl = s"localhost:$port",
      adminApiVersion = "2022-01"
    )
  implicit val httpBackend: SttpBackend[Future, Any] = AsyncHttpClientFutureBackend()

  implicit def timeStringToZonedDateTime(time: String): Option[ZonedDateTime] = {
    Option(ZonedDateTime.parse(time))
  }

  def correctShopifyRequestBehaviour[Req, Rep](
      apiRequest: ShopifyRequest[Req, Rep],
      expectedUrl: String,
      expectedMethod: Method,
      expectedRequestBody: Option[String],
      mapping: MappingBuilder,
      expectedStatusCode: StatusCode,
      expectedResponseBody: Option[Rep]
  ): Unit = {
    it should "generate correct request" in {
      apiRequest.request.uri.toString() should be(expectedUrl)
      apiRequest.request.method should be(expectedMethod)

      apiRequest.request.body match {
        case StringBody(json, encoding, contentType) =>
          expectedRequestBody match {
            case Some(expected) =>
              val requestBody  = parse(json).getOrElse(Json.Null)
              val expectedBody = parse(expected).getOrElse(Json.Null)
              assert(Json.eqJson.eqv(requestBody, expectedBody))
            case None =>
              succeed
          }

        case _ => fail("expect json body")
      }
    }

    it should s"get success response[${expectedStatusCode.code}] and parse response" in {
      stubFor(mapping)
      apiRequest.response().map { rep =>
        expectedResponseBody match {
          case Some(body) =>
            rep.body should be(Right(body))
            rep.code should be(expectedStatusCode)
          case None =>
            rep.code should be(expectedStatusCode)
        }
      }
    }
  }
}
