package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class DeleteProductVariantByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = DeleteProductVariantById(632910392, 808950810),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/products/632910392/variants/808950810.json",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/products/632910392/variants/808950810.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse().withStatus(200)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )

}
