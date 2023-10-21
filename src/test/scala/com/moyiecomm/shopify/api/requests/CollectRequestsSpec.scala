package com.moyiecomm.shopify.api.requests

import com.moyiecomm.shopify.api.RequestSpec
import com.moyiecomm.shopify.api.json.product.Collect.ProductToCollection
import com.moyiecomm.shopify.api.requests.product.AddProductToCollect
import RequestSpec.httpBackend
import com.github.tomakehurst.wiremock.client.WireMock._
import sttp.model.StatusCode

class CollectRequestsSpec extends RequestSpec {
  "AddProductToCollect" should "generate add product to collect request and get response as Collect" in {
    wireMockServer.stubFor(
      post("/admin/api/2023-10/collects.json")
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
        )
    )

    val addProductToCollectRequest = AddProductToCollect(ProductToCollection(921728736, 841564295), requestConfig)

    addProductToCollectRequest.send().map { response =>
      response.code should be(StatusCode.Created)
      response.body.entity match {
        case Left(_) =>
          fail("expect Right(collect)")
        case Right(collect) =>
          collect.id should be(1071559580)
          collect.collectionId should be(841564295)
          collect.productId should be(921728736)
      }
    }
  }
}
