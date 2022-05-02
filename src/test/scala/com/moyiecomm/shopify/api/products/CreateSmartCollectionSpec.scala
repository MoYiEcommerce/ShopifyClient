package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.SmartCollection
import com.moyiecomm.shopify.api.products.models.SmartCollection.Rule
import sttp.model.{Method, StatusCode}

class CreateSmartCollectionSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateSmartCollection(
      SmartCollection(
        id = None,
        title = "IPods",
        bodyHtml = None,
        handle = None,
        image = None,
        publishedScope = None,
        rules = List(
          Rule(column = "title", relation = "starts_with", condition = "iPod")
        ),
        disjunctive = false,
        sortOrder = None,
        templateSuffix = None,
        publishedAt = None,
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/smart_collections.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"smart_collection":{"title":"IPods","rules":[{"column":"title","relation":"starts_with","condition":"iPod"}],"disjunctive":false}}"""
    ),
    mapping = post("/admin/api/2022-01/smart_collections.json")
      .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"smart_collection":{"title":"IPods","rules":[{"column":"title","relation":"starts_with","condition":"iPod"}],"disjunctive":false}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "smart_collection": {
                      |    "id": 1063001322,
                      |    "handle": "ipods-1",
                      |    "title": "IPods",
                      |    "updated_at": "2022-03-11T11:00:30-05:00",
                      |    "body_html": null,
                      |    "published_at": "2022-03-11T11:00:30-05:00",
                      |    "sort_order": "best-selling",
                      |    "template_suffix": null,
                      |    "disjunctive": false,
                      |    "rules": [
                      |      {
                      |        "column": "title",
                      |        "relation": "starts_with",
                      |        "condition": "iPod"
                      |      }
                      |    ],
                      |    "published_scope": "web",
                      |    "admin_graphql_api_id": "gid://shopify/Collection/1063001322"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      SmartCollection(
        id = Some(1063001322),
        title = "IPods",
        bodyHtml = None,
        handle = Some("ipods-1"),
        image = None,
        publishedScope = Some("web"),
        rules = List(Rule(column = "title", relation = "starts_with", condition = "iPod")),
        disjunctive = false,
        sortOrder = Some("best-selling"),
        templateSuffix = None,
        publishedAt = "2022-03-11T11:00:30-05:00",
        updatedAt = "2022-03-11T11:00:30-05:00"
      )
    )
  )
}
