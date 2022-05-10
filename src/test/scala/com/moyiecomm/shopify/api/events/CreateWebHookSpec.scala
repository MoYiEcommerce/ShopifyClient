package com.moyiecomm.shopify.api.events

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.events.models.WebHook
import sttp.model.{Method, StatusCode}

class CreateWebHookSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateWebHook(
      WebHook(
        id = None,
        address = "https://example.hostname.com/",
        apiVersion = None,
        fields = List("id", "note"),
        format = "json",
        topic = "orders/create",
        metafieldNamespaces = List.empty,
        privateMetafieldNamespaces = List.empty,
        createdAt = None,
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/webhooks.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"webhook":{"topic":"orders/create","address":"https://example.hostname.com/","format":"json","fields":["id","note"]}}"""
    ),
    mapping = post("/admin/api/2022-01/webhooks.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"webhook":{"topic":"orders/create","address":"https://example.hostname.com/","format":"json","fields":["id","note"]}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "webhook": {
                      |    "id": 7458897695,
                      |    "address": "https://example.hostname.com/",
                      |    "topic": "orders/create",
                      |    "created_at": "2022-04-06T08:09:50-04:00",
                      |    "updated_at": "2022-04-06T08:09:50-04:00",
                      |    "format": "json",
                      |    "fields": [
                      |      "id",
                      |      "note"
                      |    ],
                      |    "metafield_namespaces": [],
                      |    "api_version": "unstable",
                      |    "private_metafield_namespaces": []
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      WebHook(
        id = Some(7458897695L),
        address = "https://example.hostname.com/",
        apiVersion = Some("unstable"),
        fields = List("id", "note"),
        format = "json",
        topic = "orders/create",
        metafieldNamespaces = List.empty,
        privateMetafieldNamespaces = List.empty,
        createdAt = "2022-04-06T08:09:50-04:00",
        updatedAt = "2022-04-06T08:09:50-04:00"
      )
    )
  )

}
