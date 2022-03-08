package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, get}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.Collection
import com.moyiecomm.shopify.api.products.models.Collection.CollectionImage
import sttp.model.{Method, StatusCode}

class GetCollectionByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetCollectionById(841564295),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/collections/841564295.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/collections/841564295.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "collection": {
                      |    "id": 841564295,
                      |    "handle": "ipods",
                      |    "title": "IPods",
                      |    "updated_at": "2008-02-01T19:00:00-05:00",
                      |    "body_html": "<p>The best selling ipod ever</p>",
                      |    "published_at": "2008-02-01T19:00:00-05:00",
                      |    "sort_order": "manual",
                      |    "template_suffix": null,
                      |    "products_count": 1,
                      |    "collection_type": "custom",
                      |    "published_scope": "web",
                      |    "admin_graphql_api_id": "gid://shopify/Collection/841564295",
                      |    "image": {
                      |      "created_at": "2022-03-11T11:02:04-05:00",
                      |      "alt": "MP3 Player 8gb",
                      |      "width": 123,
                      |      "height": 456,
                      |      "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/collections/ipod_nano_8gb.jpg?v=1647014524"
                      |    }
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Collection(
        id = Some(841564295),
        handle = Some("ipods"),
        title = "IPods",
        bodyHtml = Some("<p>The best selling ipod ever</p>"),
        sortOrder = Some("manual"),
        templateSuffix = None,
        productsCount = Some(1),
        publishedScope = Some("web"),
        published = None,
        publishedAt = "2008-02-01T19:00:00-05:00",
        updatedAt = "2008-02-01T19:00:00-05:00",
        image = Some(
          CollectionImage(
            src = "https://cdn.shopify.com/s/files/1/0005/4838/0009/collections/ipod_nano_8gb.jpg?v=1647014524",
            width = 123,
            height = 456,
            createdAt = "2022-03-11T11:02:04-05:00",
            alt = Some("MP3 Player 8gb"),
            attachment = None
          )
        )
      )
    )
  )
}
