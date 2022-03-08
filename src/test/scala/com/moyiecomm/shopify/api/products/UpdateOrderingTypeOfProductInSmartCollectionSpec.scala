package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}
import com.github.tomakehurst.wiremock.client.WireMock._

class UpdateOrderingTypeOfProductInSmartCollectionSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest =
      UpdateOrderingTypeOfProductInSmartCollection(smartCollectionId = 482865238, productIdList = List(921728736, 632910392)),
    expectedUrl =
      s"http://localhost:$port/admin/api/2022-01/smart_collections/482865238/order.json?products%5B%5D=921728736&products%5B%5D=632910392",
    expectedMethod = Method.PUT,
    expectedRequestBody = None,
    mapping = put("/admin/api/2022-01/smart_collections/482865238/order.json?products%5B%5D=921728736&products%5B%5D=632910392")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = None
  )

}
