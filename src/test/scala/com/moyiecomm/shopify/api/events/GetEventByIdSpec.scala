package com.moyiecomm.shopify.api.events

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.events.models.Event
import sttp.model.{Method, StatusCode}

class GetEventByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetEventById(677313116),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/events/677313116.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/events/677313116.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "event": {
                      |    "id": 677313116,
                      |    "subject_id": 921728736,
                      |    "created_at": "2008-01-10T08:00:00-05:00",
                      |    "subject_type": "Product",
                      |    "verb": "create",
                      |    "arguments": [
                      |      "IPod Touch 8GB"
                      |    ],
                      |    "body": null,
                      |    "message": "Product was created: <a href=\"https://jsmith.myshopify.com/admin/products/921728736\">IPod Touch 8GB</a>.",
                      |    "author": "Shopify",
                      |    "description": "Product was created: IPod Touch 8GB.",
                      |    "path": "/admin/products/921728736"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Event(
        id = 677313116,
        arguments = List("IPod Touch 8GB"),
        body = None,
        path = "/admin/products/921728736",
        message = "Product was created: <a href=\"https://jsmith.myshopify.com/admin/products/921728736\">IPod Touch 8GB</a>.",
        subjectId = 921728736,
        subjectType = "Product",
        verb = "create",
        author = Some("Shopify"),
        description = Some("Product was created: IPod Touch 8GB."),
        createdAt = "2008-01-10T08:00:00-05:00"
      )
    )
  )

}
