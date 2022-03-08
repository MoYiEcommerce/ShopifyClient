package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.ProductImage
import sttp.model.{Method, StatusCode}

class CreateProductImageSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateProductImage(
      ProductImage(
        id = None,
        filename = Some("testFile.png"),
        alt = None,
        position = None,
        productId = 632910392,
        variantIds = List.empty,
        src = None,
        width = None,
        height = None,
        createdAt = None,
        updatedAt = None,
        attachment = Some("imageByteStr")
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/products/632910392/images.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"image":{"filename":"testFile.png","attachment":"imageByteStr"}}"""
    ),
    mapping = post("/admin/api/2022-01/products/632910392/images.json")
      .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalTo(
          """{"image":{"filename":"testFile.png","attachment":"imageByteStr"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "image": {
                      |    "id": 1001473902,
                      |    "product_id": 632910392,
                      |    "position": 4,
                      |    "created_at": "2022-03-11T11:16:51-05:00",
                      |    "updated_at": "2022-03-11T11:16:51-05:00",
                      |    "alt": null,
                      |    "width": 110,
                      |    "height": 140,
                      |    "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/products/rails_logo.gif?v=1647015411",
                      |    "variant_ids": [],
                      |    "admin_graphql_api_id": "gid://shopify/ProductImage/1001473902"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      ProductImage(
        id = Some(1001473902),
        filename = None,
        alt = None,
        position = Some(4),
        productId = 632910392,
        variantIds = List.empty,
        src = Some("https://cdn.shopify.com/s/files/1/0005/4838/0009/products/rails_logo.gif?v=1647015411"),
        width = Some(110),
        height = Some(140),
        createdAt = "2022-03-11T11:16:51-05:00",
        updatedAt = "2022-03-11T11:16:51-05:00",
        attachment = None
      )
    )
  )
}
