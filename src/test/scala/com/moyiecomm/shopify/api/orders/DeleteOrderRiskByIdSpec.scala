package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class DeleteOrderRiskByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = DeleteOrderRiskById(450789469, 284138680),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/450789469/risks/284138680.json",
    expectedMethod = Method.DELETE,
    expectedRequestBody = None,
    mapping = delete("/admin/api/2022-01/orders/450789469/risks/284138680.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )
}
