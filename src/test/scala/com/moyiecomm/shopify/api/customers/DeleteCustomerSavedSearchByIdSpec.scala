package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class DeleteCustomerSavedSearchByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = DeleteCustomerSavedSearchById(789629109),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customer_saved_searches/789629109.json",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/customer_saved_searches/789629109.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse().withStatus(200)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )

}
