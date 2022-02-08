package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.Collect
import sttp.model.{Method, StatusCode}

class GetCollectListSpec extends ApiSpec {
  "GetCountOfCollectsSpec" should behave like correctShopifyRequestBehaviour(
    apiRequest = GetCollectList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/collects.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/collects.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "collects": [
                      |    {
                      |      "id": 358268117,
                      |      "collection_id": 482865238,
                      |      "product_id": 632910392,
                      |      "created_at": null,
                      |      "updated_at": null,
                      |      "position": 1,
                      |      "sort_value": "0000000001"
                      |    },
                      |    {
                      |      "id": 455204334,
                      |      "collection_id": 841564295,
                      |      "product_id": 632910392,
                      |      "created_at": null,
                      |      "updated_at": null,
                      |      "position": 1,
                      |      "sort_value": "0000000001"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        Collect(
          id = 358268117,
          collectionId = 482865238,
          productId = 632910392,
          createdAt = None,
          updatedAt = None,
          position = 1,
          sortValue = "0000000001"
        ),
        Collect(
          id = 455204334,
          collectionId = 841564295,
          productId = 632910392,
          createdAt = None,
          updatedAt = None,
          position = 1,
          sortValue = "0000000001"
        )
      )
    )
  )
}
