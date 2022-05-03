package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.shared.models.CountOfRequestedItems
import sttp.model.{Method, StatusCode}

class GetCountOfCollectsSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetCountOfCollects(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/collects/count.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/collects/count.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "count": 2
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      CountOfRequestedItems(2)
    )
  )
}
