package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.ProductImage
import sttp.model.{Method, StatusCode}
import com.github.tomakehurst.wiremock.client.WireMock._

class UpdateProductImageSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateProductImage(
      image = ProductImage(
        id = Some(850703190),
        filename = None,
        alt = Some("new alt tag content"),
        position = Some(2),
        productId = 632910392,
        variantIds = List.empty,
        src = None,
        width = None,
        height = None,
        createdAt = None,
        updatedAt = None,
        attachment = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/products/632910392/images/850703190.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some("""{"image":{"id":850703190,"alt":"new alt tag content","position":2}}"""),
    mapping = put("/admin/api/2022-01/products/632910392/images/850703190.json")
      .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson("""{"image":{"id":850703190,"alt":"new alt tag content","position":2}}""")
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "image": {
                      |    "id": 850703190,
                      |    "product_id": 632910392,
                      |    "position": 2,
                      |    "created_at": "2022-03-11T11:02:04-05:00",
                      |    "updated_at": "2022-03-11T11:17:01-05:00",
                      |    "alt": "new alt tag content",
                      |    "width": 123,
                      |    "height": 456,
                      |    "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1647015421",
                      |    "variant_ids": [],
                      |    "admin_graphql_api_id": "gid://shopify/ProductImage/850703190"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      ProductImage(
        id = Some(850703190),
        filename = None,
        alt = Some("new alt tag content"),
        position = Some(2),
        productId = 632910392,
        variantIds = List.empty,
        src = Some("https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1647015421"),
        width = Some(123),
        height = Some(456),
        createdAt = "2022-03-11T11:02:04-05:00",
        updatedAt = "2022-03-11T11:17:01-05:00",
        attachment = None
      )
    )
  )
}
