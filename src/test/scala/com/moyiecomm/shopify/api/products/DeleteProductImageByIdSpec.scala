package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class DeleteProductImageByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = DeleteProductImageById(632910392, 850703190),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/products/632910392/images/850703190.json",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/products/632910392/images/850703190.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse().withStatus(200)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )
}
