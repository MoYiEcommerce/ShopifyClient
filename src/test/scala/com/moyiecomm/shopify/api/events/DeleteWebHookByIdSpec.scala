package com.moyiecomm.shopify.api.events

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class DeleteWebHookByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = DeleteWebHookById(4759306),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/webhooks/4759306.json",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/webhooks/4759306.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )
}
