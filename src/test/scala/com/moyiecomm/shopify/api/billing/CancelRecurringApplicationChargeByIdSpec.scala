package com.moyiecomm.shopify.api.billing

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, delete}
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class CancelRecurringApplicationChargeByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CancelRecurringApplicationChargeById(455696195),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/recurring_application_charges/455696195.json",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/recurring_application_charges/455696195.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse().withStatus(200)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )

}
