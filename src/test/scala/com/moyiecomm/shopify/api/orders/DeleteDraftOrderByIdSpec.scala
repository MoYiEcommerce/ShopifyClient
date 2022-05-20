package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class DeleteDraftOrderByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = DeleteDraftOrderById(994118539),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/draft_orders/994118539.json",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/draft_orders/994118539.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )
}
