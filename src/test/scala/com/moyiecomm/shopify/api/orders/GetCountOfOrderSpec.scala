package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.shared.models.CountOfRequestedItems
import sttp.model.{Method, StatusCode}

class GetCountOfOrderSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetCountOfOrder(None, None, None, None, None, None, None),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/count.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/orders/count.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "count": 1
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      CountOfRequestedItems(1)
    )
  )
}
