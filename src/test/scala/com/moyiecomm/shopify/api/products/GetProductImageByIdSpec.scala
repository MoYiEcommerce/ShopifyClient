package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.ProductImage
import sttp.model.{Method, StatusCode}

class GetProductImageByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetProductImageById(productId = 632910392, imageId = 850703190),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/products/632910392/images/850703190.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/products/632910392/images/850703190.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "image": {
                      |    "id": 850703190,
                      |    "product_id": 632910392,
                      |    "position": 1,
                      |    "created_at": "2022-03-11T11:02:04-05:00",
                      |    "updated_at": "2022-03-11T11:02:04-05:00",
                      |    "alt": null,
                      |    "width": 123,
                      |    "height": 456,
                      |    "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1647014524",
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
        alt = None,
        position = Some(1),
        productId = 632910392,
        variantIds = List.empty,
        src = Some("https://cdn.shopify.com/s/files/1/0005/4838/0009/products/ipod-nano.png?v=1647014524"),
        width = Some(123),
        height = Some(456),
        createdAt = "2022-03-11T11:02:04-05:00",
        updatedAt = "2022-03-11T11:02:04-05:00",
        attachment = None
      )
    )
  )

}
