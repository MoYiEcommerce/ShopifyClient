package com.moyiecomm.shopify.api.events

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.events.models.WebHook
import sttp.model.{Method, StatusCode}

class UpdateWebHookSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateWebHookById(
      WebHook(
        id = Some(4759306),
        address = "https://somewhere-else.com/",
        apiVersion = None,
        fields = List.empty,
        format = "",
        topic = "",
        metafieldNamespaces = List.empty,
        privateMetafieldNamespaces = List.empty,
        createdAt = None,
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/webhooks/4759306.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some(
      """{"webhook":{"id":4759306,"address":"https://somewhere-else.com/"}}"""
    ),
    mapping = put("/admin/api/2022-01/webhooks/4759306.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"webhook":{"id":4759306,"address":"https://somewhere-else.com/"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "webhook": {
                      |    "id": 4759306,
                      |    "address": "https://somewhere-else.com/",
                      |    "topic": "orders/create",
                      |    "created_at": "2022-04-06T08:07:43-04:00",
                      |    "updated_at": "2022-04-06T08:09:55-04:00",
                      |    "format": "json",
                      |    "fields": [],
                      |    "metafield_namespaces": [],
                      |    "api_version": "unstable",
                      |    "private_metafield_namespaces": []
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      WebHook(
        id = Some(4759306),
        address = "https://somewhere-else.com/",
        apiVersion = Some("unstable"),
        fields = List.empty,
        format = "json",
        topic = "orders/create",
        metafieldNamespaces = List.empty,
        privateMetafieldNamespaces = List.empty,
        createdAt = "2022-04-06T08:07:43-04:00",
        updatedAt = "2022-04-06T08:09:55-04:00"
      )
    )
  )

}
