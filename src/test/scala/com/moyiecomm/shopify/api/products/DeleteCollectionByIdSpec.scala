package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class DeleteCollectionByIdSpec extends ApiSpec {
  "DeleteCollectionById" should behave like correctShopifyRequestBehaviour(
    apiRequest = DeleteCollectById(123456),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/collects/123456.json",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/collects/123456.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse().withStatus(200)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )
}
