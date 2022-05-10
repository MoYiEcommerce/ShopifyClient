package com.moyiecomm.shopify.api.events

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.events.models.Event
import sttp.model.{Method, StatusCode}

class GetEventListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetEventList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/events.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/events.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "events": [
                      |    {
                      |      "id": 164748010,
                      |      "subject_id": 450789469,
                      |      "created_at": "2008-01-10T06:00:00-05:00",
                      |      "subject_type": "Order",
                      |      "verb": "confirmed",
                      |      "arguments": [
                      |        "#1001",
                      |        "Bob Norman"
                      |      ],
                      |      "body": null,
                      |      "message": "Received new order <a href=\"https://jsmith.myshopify.com/admin/orders/450789469\">#1001</a> by Bob Norman.",
                      |      "author": "Shopify",
                      |      "description": "Received new order #1001 by Bob Norman.",
                      |      "path": "/admin/orders/450789469"
                      |    },
                      |    {
                      |      "id": 365755215,
                      |      "subject_id": 632910392,
                      |      "created_at": "2008-01-10T07:00:00-05:00",
                      |      "subject_type": "Product",
                      |      "verb": "create",
                      |      "arguments": [
                      |        "IPod Nano - 8GB"
                      |      ],
                      |      "body": null,
                      |      "message": "Product was created: <a href=\"https://jsmith.myshopify.com/admin/products/632910392\">IPod Nano - 8GB</a>.",
                      |      "author": "Shopify",
                      |      "description": "Product was created: IPod Nano - 8GB.",
                      |      "path": "/admin/products/632910392"
                      |    },
                      |    {
                      |      "id": 677313116,
                      |      "subject_id": 921728736,
                      |      "created_at": "2008-01-10T08:00:00-05:00",
                      |      "subject_type": "Product",
                      |      "verb": "create",
                      |      "arguments": [
                      |        "IPod Touch 8GB"
                      |      ],
                      |      "body": null,
                      |      "message": "Product was created: <a href=\"https://jsmith.myshopify.com/admin/products/921728736\">IPod Touch 8GB</a>.",
                      |      "author": "Shopify",
                      |      "description": "Product was created: IPod Touch 8GB.",
                      |      "path": "/admin/products/921728736"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        Event(
          id = 164748010,
          arguments = List("#1001", "Bob Norman"),
          body = None,
          path = "/admin/orders/450789469",
          message = "Received new order <a href=\"https://jsmith.myshopify.com/admin/orders/450789469\">#1001</a> by Bob Norman.",
          subjectId = 450789469,
          subjectType = "Order",
          verb = "confirmed",
          author = Some("Shopify"),
          description = Some("Received new order #1001 by Bob Norman."),
          createdAt = "2008-01-10T06:00:00-05:00"
        ),
        Event(
          id = 365755215,
          arguments = List("IPod Nano - 8GB"),
          body = None,
          path = "/admin/products/632910392",
          message = "Product was created: <a href=\"https://jsmith.myshopify.com/admin/products/632910392\">IPod Nano - 8GB</a>.",
          subjectId = 632910392,
          subjectType = "Product",
          verb = "create",
          author = Some("Shopify"),
          description = Some("Product was created: IPod Nano - 8GB."),
          createdAt = "2008-01-10T07:00:00-05:00"
        ),
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
  )

}
