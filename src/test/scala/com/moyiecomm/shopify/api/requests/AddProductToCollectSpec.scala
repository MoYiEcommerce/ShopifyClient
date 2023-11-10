package com.moyiecomm.shopify.api.requests

import java.time.ZonedDateTime

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.RequestSpec
import com.moyiecomm.shopify.api.json.product.Collect
import com.moyiecomm.shopify.api.json.product.Collect.ProductToCollection
import com.moyiecomm.shopify.api.requests.product.AddProductToCollect
import sttp.model.StatusCode

class AddProductToCollectSpec extends RequestSpec {
  it should behave like correctRequestResponse(
    mockRequest = post("/admin/api/2023-10/collects.json")
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
    shopifyRequest = AddProductToCollect(ProductToCollection(921728736, 841564295), requestConfig),
    expectedStatusCode = StatusCode.Created,
    expectedResponseEntity = Collect(
      id = 1071559580,
      position = 2,
      sortValue = "0000000002",
      collectionId = 841564295,
      productId = 921728736,
      createdAt = Some(ZonedDateTime.parse("2022-01-06T16:10:10-05:00")),
      updatedAt = Some(ZonedDateTime.parse("2022-01-06T16:11:40-05:00"))
    )
  )
}
