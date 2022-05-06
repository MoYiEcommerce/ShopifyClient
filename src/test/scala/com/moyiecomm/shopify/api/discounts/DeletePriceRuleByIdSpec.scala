package com.moyiecomm.shopify.api.discounts

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class DeletePriceRuleByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = DeletePriceRuleById(507328175),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/price_rules/507328175.json",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/price_rules/507328175.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(204)
      ),
    expectedStatusCode = StatusCode.NoContent,
    expectedResponseBody = None
  )
}
