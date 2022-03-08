package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.Collection
import sttp.model.{Method, StatusCode}
import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.products.models.Collection.CollectionImage

class UpdateCustomCollectionByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateCustomCollectionById(
      Collection(
        id = Some(841564295),
        title = "IPods",
        bodyHtml = None,
        handle = Some("test handle"),
        image = None,
        publishedScope = None,
        published = None,
        sortOrder = None,
        templateSuffix = None,
        productsCount = None,
        publishedAt = None,
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/custom_collections/841564295.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some("""{"custom_collection":{"id":841564295,"title":"IPods","handle":"test handle"}}"""),
    mapping = put("/admin/api/2022-01/custom_collections/841564295.json")
      .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(equalTo("""{"custom_collection":{"id":841564295,"title":"IPods","handle":"test handle"}}"""))
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "custom_collection": {
                      |    "id": 841564295,
                      |    "body_html": "<p>5000 songs in your pocket</p>",
                      |    "title": "IPods",
                      |    "handle": "ipods",
                      |    "id": 841564295,
                      |    "updated_at": "2022-04-05T13:27:05-04:00",
                      |    "published_at": "2008-02-01T19:00:00-05:00",
                      |    "published": false,
                      |    "sort_order": "manual",
                      |    "template_suffix": null,
                      |    "published_scope": "web",
                      |    "admin_graphql_api_id": "gid://shopify/Collection/841564295",
                      |    "image": {
                      |      "created_at": "2022-04-05T13:17:47-04:00",
                      |      "alt": "MP3 Player 8gb",
                      |      "width": 123,
                      |      "height": 456,
                      |      "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/collections/ipod_nano_8gb.jpg?v=1649179067"
                      |    }
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Collection(
        id = Some(841564295),
        title = "IPods",
        bodyHtml = Some("<p>5000 songs in your pocket</p>"),
        handle = Some("ipods"),
        image = Some(
          CollectionImage(
            attachment = None,
            src = "https://cdn.shopify.com/s/files/1/0005/4838/0009/collections/ipod_nano_8gb.jpg?v=1649179067",
            alt = Some("MP3 Player 8gb"),
            createdAt = "2022-04-05T13:17:47-04:00",
            width = 123,
            height = 456
          )
        ),
        publishedScope = Some("web"),
        published = Some(false),
        sortOrder = Some("manual"),
        productsCount = None,
        templateSuffix = None,
        publishedAt = "2008-02-01T19:00:00-05:00",
        updatedAt = "2022-04-05T13:27:05-04:00"
      )
    )
  )

}
