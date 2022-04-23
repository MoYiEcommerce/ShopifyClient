package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}
import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.products.models.Collection.CollectionImage
import com.moyiecomm.shopify.api.products.models.SmartCollection
import com.moyiecomm.shopify.api.products.models.SmartCollection.Rule

class GetSmartCollectionByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetSmartCollectionById(482865238),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/smart_collections/482865238.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/smart_collections/482865238.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "smart_collection": {
                      |    "id": 482865238,
                      |    "handle": "smart-ipods",
                      |    "title": "Smart iPods",
                      |    "updated_at": "2008-02-01T19:00:00-05:00",
                      |    "body_html": "<p>The best selling ipod ever</p>",
                      |    "published_at": "2008-02-01T19:00:00-05:00",
                      |    "sort_order": "manual",
                      |    "template_suffix": null,
                      |    "products_count": 2,
                      |    "disjunctive": false,
                      |    "rules": [
                      |      {
                      |        "column": "type",
                      |        "relation": "equals",
                      |        "condition": "Cult Products"
                      |      }
                      |    ],
                      |    "published_scope": "web",
                      |    "admin_graphql_api_id": "gid://shopify/Collection/482865238",
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
      SmartCollection(
        id = Some(482865238),
        title = "Smart iPods",
        bodyHtml = Some("<p>The best selling ipod ever</p>"),
        handle = Some("smart-ipods"),
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
        rules = List(
          Rule(
            column = "type",
            relation = "equals",
            condition = "Cult Products"
          )
        ),
        disjunctive = false,
        sortOrder = Some("manual"),
        templateSuffix = None,
        publishedAt = "2008-02-01T19:00:00-05:00",
        updatedAt = "2008-02-01T19:00:00-05:00"
      )
    )
  )

}