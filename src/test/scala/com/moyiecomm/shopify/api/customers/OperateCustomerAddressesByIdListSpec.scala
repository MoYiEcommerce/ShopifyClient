package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class OperateCustomerAddressesByIdListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = OperateCustomerAddressesByIdList(207119551, List(1053317289, 1053317333), "destroy"),
    expectedUrl =
      s"http://localhost:$port/admin/api/2022-01/customers/207119551/addresses/set.json?address_ids%5B%5D=1053317289,1053317333&operation=destroy",
    expectedMethod = Method.PUT,
    expectedRequestBody = None,
    mapping =
      put("/admin/api/2022-01/customers/207119551/addresses/set.json?address_ids%5B%5D=1053317289,1053317333&operation=destroy")
        .withBasicAuth("testKeyId", "testKeySecret")
        .willReturn(
          aResponse()
            .withStatus(200)
        ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )
}
