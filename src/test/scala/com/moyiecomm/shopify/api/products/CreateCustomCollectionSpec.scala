package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.products.models.Collection
import sttp.model.{Method, StatusCode}
import com.github.tomakehurst.wiremock.client.WireMock._

class CreateCustomCollectionSpec extends ApiSpec {

  it should behave like correctShopifyRequestBehaviour(
    apiRequest =
      CreateCustomCollection(Collection(None, title = "testCollection", None, None, None, None, None, None, None, None)),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/custom_collections.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some("""{"custom_collection":{"title":"testCollection"}}"""),
    mapping = post("/admin/api/2022-01/custom_collections.json")
      .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(equalTo("""{"custom_collection":{"title":"testCollection"}}"""))
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "custom_collection": {
                      |    "id": 1063001399,  
                      |    "handle": "testCollection",
                      |    "title": "testCollection",
                      |    "updated_at": "2022-02-04T14:12:17-05:00",
                      |    "body_html": null,
                      |    "published_at": "2022-02-03T17:12:17-05:00",
                      |    "sort_order": "best-selling",
                      |    "template_suffix": null,
                      |    "published_scope": "web",
                      |    "admin_graphql_api_id": "gid://shopify/Collection/1063001399"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      Collection(
        id = Some(1063001399),
        title = "testCollection",
        bodyHtml = None,
        handle = Some("testCollection"),
        image = None,
        publishedScope = Some("web"),
        sortOrder = Some("best-selling"),
        templateSuffix = None,
        publishedAt = "2022-02-03T17:12:17-05:00",
        updatedAt = "2022-02-04T14:12:17-05:00"
      )
    )
  )

}
