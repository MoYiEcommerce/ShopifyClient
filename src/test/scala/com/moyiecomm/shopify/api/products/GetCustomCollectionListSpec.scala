package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, get}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.Collection
import com.moyiecomm.shopify.api.products.models.Collection.CollectionImage
import sttp.model.{Method, StatusCode}

class GetCustomCollectionListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetCustomCollectionList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/custom_collections.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/custom_collections.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody(
            """
              |{
              |  "custom_collections": [
              |    {
              |      "id": 841564295,
              |      "handle": "ipods",
              |      "title": "IPods",
              |      "updated_at": "2008-02-01T19:00:00-05:00",
              |      "body_html": "<p>The best selling ipod ever</p>",
              |      "published_at": "2008-02-01T19:00:00-05:00",
              |      "sort_order": "manual",
              |      "template_suffix": null,
              |      "published_scope": "web",
              |      "admin_graphql_api_id": "gid://shopify/Collection/841564295",
              |      "image": {
              |        "created_at": "2022-03-11T11:29:03-05:00",
              |        "alt": "MP3 Player 8gb",
              |        "width": 123,
              |        "height": 456,
              |        "src": "https://cdn.shopify.com/s/files/1/0005/4838/0009/collections/ipod_nano_8gb.jpg?v=1647016143"
              |      }
              |    },
              |    {
              |      "id": 395646240,
              |      "handle": "ipods_two",
              |      "title": "IPods Two",
              |      "updated_at": "2008-02-01T19:00:00-05:00",
              |      "body_html": "<p>The best selling ipod ever. Again</p>",
              |      "published_at": "2008-02-01T19:00:00-05:00",
              |      "sort_order": "manual",
              |      "template_suffix": null,
              |      "published_scope": "web",
              |      "admin_graphql_api_id": "gid://shopify/Collection/395646240"
              |    }
              |  ]
              |}
              |""".stripMargin
          )
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        Collection(
          id = Some(841564295),
          handle = Some("ipods"),
          title = "IPods",
          bodyHtml = Some("<p>The best selling ipod ever</p>"),
          sortOrder = Some("manual"),
          templateSuffix = None,
          productsCount = None,
          publishedScope = Some("web"),
          published = None,
          image = Some(
            CollectionImage(
              src = "https://cdn.shopify.com/s/files/1/0005/4838/0009/collections/ipod_nano_8gb.jpg?v=1647016143",
              attachment = None,
              alt = Some("MP3 Player 8gb"),
              width = 123,
              height = 456,
              createdAt = "2022-03-11T11:29:03-05:00"
            )
          ),
          publishedAt = "2008-02-01T19:00:00-05:00",
          updatedAt = "2008-02-01T19:00:00-05:00"
        ),
        Collection(
          id = Some(395646240),
          handle = Some("ipods_two"),
          title = "IPods Two",
          bodyHtml = Some("<p>The best selling ipod ever. Again</p>"),
          sortOrder = Some("manual"),
          templateSuffix = None,
          productsCount = None,
          publishedScope = Some("web"),
          published = None,
          image = None,
          publishedAt = "2008-02-01T19:00:00-05:00",
          updatedAt = "2008-02-01T19:00:00-05:00"
        )
      )
    )
  )
}