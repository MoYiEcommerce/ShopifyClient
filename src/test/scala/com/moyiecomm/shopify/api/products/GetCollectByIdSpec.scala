package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.Collect
import sttp.model.{Method, StatusCode}

class GetCollectByIdSpec extends ApiSpec {
  "GetCollectById" should behave like correctShopifyRequestBehaviour(
    apiRequest = GetCollectById(455204334),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/collects/455204334.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/collects/455204334.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "collect": {
                      |    "id": 455204334,
                      |    "collection_id": 841564295,
                      |    "product_id": 632910392,
                      |    "created_at": "2022-01-06T16:10:10-05:00",
                      |    "updated_at": "2022-01-06T16:11:40-05:00",
                      |    "position": 2,
                      |    "sort_value": "0000000002"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Collect(
        id = 455204334,
        position = 2,
        sortValue = "0000000002",
        collectionId = 841564295,
        productId = 632910392,
        createdAt = "2022-01-06T16:10:10-05:00",
        updatedAt = "2022-01-06T16:11:40-05:00"
      )
    )
  )
}
