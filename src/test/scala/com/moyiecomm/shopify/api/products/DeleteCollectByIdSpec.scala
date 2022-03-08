package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class DeleteCollectByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = DeleteCollectById(455204334),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/collects/455204334.json",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/collects/455204334.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse().withStatus(200)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )
}
