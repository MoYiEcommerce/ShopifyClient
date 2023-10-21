package com.moyiecomm.shopify.api.requests

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, equalTo, post}
import com.moyiecomm.shopify.api.RequestSpec
import com.moyiecomm.shopify.api.json.product.Collection
import com.moyiecomm.shopify.api.requests.product.CreateCustomCollection
import sttp.model.StatusCode

import java.time.ZonedDateTime

class CreateCustomCollectionSpec extends RequestSpec {
  it should behave like correctRequestResponse(
    mockRequest = post("/admin/api/2023-10/custom_collections.json")
      .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(equalTo("""{"custom_collection":{"title":"Macbooks"}}"""))
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "custom_collection": {
                      |    "id": 1063001337,
                      |    "handle": "macbooks",
                      |    "title": "Macbooks",
                      |    "updated_at": "2023-10-03T13:48:58-04:00",
                      |    "body_html": null,
                      |    "published_at": "2023-10-03T13:48:58-04:00",
                      |    "sort_order": "best-selling",
                      |    "template_suffix": null,
                      |    "published_scope": "web",
                      |    "admin_graphql_api_id": "gid://shopify/Collection/1063001337"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    shopifyRequest = CreateCustomCollection(
      Collection(
        id = None,
        title = "Macbooks",
        bodyHtml = None,
        handle = None,
        image = None,
        publishedScope = None,
        published = None,
        sortOrder = None,
        templateSuffix = None,
        productsCount = None,
        publishedAt = None,
        updatedAt = None
      ),
      requestConfig
    ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseEntity = Collection(
      id = Some(1063001337),
      title = "Macbooks",
      bodyHtml = None,
      handle = Some("macbooks"),
      image = None,
      publishedScope = Some("web"),
      published = None,
      sortOrder = Some("best-selling"),
      templateSuffix = None,
      productsCount = None,
      publishedAt = Some(ZonedDateTime.parse("2023-10-03T13:48:58-04:00")),
      updatedAt = Some(ZonedDateTime.parse("2023-10-03T13:48:58-04:00"))
    )
  )
}
