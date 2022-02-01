package com.moyiecomm.shopify.api.products.requests

import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.requests.AddProductToCollection.ProductToCollect
import com.moyiecomm.shopify.request.ApiRequest.Entity
import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.products.Collect
import sttp.model.Method

class AddProductToCollectionSpec extends ApiSpec {

  "AddProductToCollection" should "generate correct request" in {
    val addProductToCollection = AddProductToCollection(
      body = Entity(entity = ProductToCollect(1001, 2000))
    )

    val expectedUri = s"http://localhost:$port/admin/api/2022-01/collects.json"

    addProductToCollection.request.uri.toString() should be(expectedUri)
    addProductToCollection.request.method should be(Method.POST)
    addProductToCollection.request.body.show should be("""string: {"collect":{"productId":1001,"collectionId":2000}}""")
  }

  it should "get success response[201]" in {
    val addProductToCollection = AddProductToCollection(
      body = Entity(entity = ProductToCollect(921728736, 841564295))
    )

    stubFor(
      post("/admin/api/2022-01/collects.json")
        .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
        .withBasicAuth("testKeyId", "testKeySecret")
        .withRequestBody(equalTo("""{"collect":{"productId":921728736,"collectionId":841564295}}"""))
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
        )
    )

    addProductToCollection.response().map { response =>
      response.body should be(
        Right(
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
  }
}
