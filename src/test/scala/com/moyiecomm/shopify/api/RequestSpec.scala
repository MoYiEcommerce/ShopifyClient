package com.moyiecomm.shopify.api

import scala.concurrent.Future
import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.moyiecomm.shopify.MockServer
import com.moyiecomm.shopify.UnitSpec
import com.moyiecomm.shopify.api.builder.ShopifyRequest
import ShopifyRequest.Config
import sttp.client3.SttpBackend
import sttp.client3.asynchttpclient.future.AsyncHttpClientFutureBackend
import sttp.model.StatusCode

trait RequestSpec extends UnitSpec with MockServer {
  import RequestSpec.httpBackend

  val requestConfig: Config =
    Config(
      apiKeyId = "testKeyId",
      apiKeySecret = "testKeySecret",
      shopUrl = s"http://localhost:$port",
      adminApiVersion = "2023-10"
    )

  def correctRequestResponse[Req, Rep](
      mockRequest: MappingBuilder,
      shopifyRequest: ShopifyRequest[Req, Rep],
      expectedStatusCode: StatusCode,
      expectedResponseEntity: Rep
  ) =
    it should "behave like correct request and parse response" in {
      wireMockServer.stubFor(mockRequest)

      shopifyRequest.send().map { response =>
        response.code should be(expectedStatusCode)
        response.body.entity match {
          case Left(_) =>
            fail("expect success")
          case Right(a: Rep) =>
            a should be(expectedResponseEntity)
        }
      }
    }
}

object RequestSpec {
  implicit val httpBackend: SttpBackend[Future, Any] = AsyncHttpClientFutureBackend()
}
