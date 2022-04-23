package com.moyiecomm.shopify.api.analytics

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, delete}
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class DeleteReportByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = DeleteReportById(517154478),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/reports/517154478.json",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/reports/517154478.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse().withStatus(200)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )

}
