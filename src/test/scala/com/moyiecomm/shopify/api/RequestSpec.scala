package com.moyiecomm.shopify.api

import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import com.moyiecomm.shopify.{MockServer, UnitSpec}
import sttp.client3.SttpBackend
import sttp.client3.asynchttpclient.future.AsyncHttpClientFutureBackend

import scala.concurrent.Future

trait RequestSpec extends UnitSpec with MockServer {
  val requestConfig: Config =
    Config(
      apiKeyId = "testKeyId",
      apiKeySecret = "testKeySecret",
      shopUrl = s"http://localhost:$port",
      adminApiVersion = "2023-10"
    )
}

object RequestSpec {
  implicit val httpBackend: SttpBackend[Future, Any] = AsyncHttpClientFutureBackend()
}
