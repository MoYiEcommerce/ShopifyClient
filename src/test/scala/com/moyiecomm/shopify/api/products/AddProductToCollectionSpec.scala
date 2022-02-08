package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.AddProductToCollection.ProductToCollect
import com.moyiecomm.shopify.api.products.models.Collect
import sttp.model.{Method, StatusCode}

class AddProductToCollectionSpec extends ApiSpec {

  "AddProductToCollection" should behave like correctShopifyRequestBehaviour(
    apiRequest = AddProductToCollection(ProductToCollect(921728736, 841564295)),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/collects.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some("""{"collect":{"product_id":921728736,"collection_id":841564295}}"""),
    mapping = post("/admin/api/2022-01/collects.json")
      .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(equalTo("""{"collect":{"product_id":921728736,"collection_id":841564295}}"""))
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "collect": {
                      |    "id": 1071559580,
                      |    "collection_id": 841564295,
                      |    "product_id": 921728736,
                      |    "created_at": "2022-01-06T16:10:10-05:00",
                      |    "updated_at": "2022-01-06T16:11:40-05:00",
                      |    "position": 2,
                      |    "sort_value": "0000000002"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      Collect(
        id = 1071559580,
        position = 2,
        sortValue = "0000000002",
        collectionId = 841564295,
        productId = 921728736,
        createdAt = "2022-01-06T16:10:10-05:00",
        updatedAt = "2022-01-06T16:11:40-05:00"
      )
    )
  )
}
