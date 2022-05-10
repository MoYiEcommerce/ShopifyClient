package com.moyiecomm.shopify.api.events

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.events.models.WebHook
import sttp.model.{Method, StatusCode}

class GetWebHookListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetWebHookList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/webhooks.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/webhooks.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "webhooks": [
                      |    {
                      |      "id": 4759306,
                      |      "address": "https://apple.com",
                      |      "topic": "orders/create",
                      |      "created_at": "2022-04-06T08:07:43-04:00",
                      |      "updated_at": "2022-04-06T08:07:43-04:00",
                      |      "format": "json",
                      |      "fields": [],
                      |      "metafield_namespaces": [],
                      |      "api_version": "unstable",
                      |      "private_metafield_namespaces": []
                      |    },
                      |    {
                      |      "id": 892403750,
                      |      "address": "https://example.org/fully_loaded_1",
                      |      "topic": "orders/cancelled",
                      |      "created_at": "2021-12-01T05:23:43-05:00",
                      |      "updated_at": "2021-12-01T05:23:43-05:00",
                      |      "format": "json",
                      |      "fields": [],
                      |      "metafield_namespaces": [],
                      |      "api_version": "unstable",
                      |      "private_metafield_namespaces": []
                      |    },
                      |    {
                      |      "id": 901431826,
                      |      "address": "https://apple.com/uninstall",
                      |      "topic": "app/uninstalled",
                      |      "created_at": "2022-04-06T08:07:43-04:00",
                      |      "updated_at": "2022-04-06T08:07:43-04:00",
                      |      "format": "json",
                      |      "fields": [],
                      |      "metafield_namespaces": [],
                      |      "api_version": "unstable",
                      |      "private_metafield_namespaces": []
                      |    },
                      |    {
                      |      "id": 1014196360,
                      |      "address": "https://example.org/app_uninstalled",
                      |      "topic": "app/uninstalled",
                      |      "created_at": "2022-04-06T08:07:43-04:00",
                      |      "updated_at": "2022-04-06T08:07:43-04:00",
                      |      "format": "json",
                      |      "fields": [],
                      |      "metafield_namespaces": [],
                      |      "api_version": "unstable",
                      |      "private_metafield_namespaces": []
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        WebHook(
          id = Some(4759306),
          address = "https://apple.com",
          apiVersion = Some("unstable"),
          fields = List.empty,
          format = "json",
          topic = "orders/create",
          metafieldNamespaces = List.empty,
          privateMetafieldNamespaces = List.empty,
          createdAt = "2022-04-06T08:07:43-04:00",
          updatedAt = "2022-04-06T08:07:43-04:00"
        ),
        WebHook(
          id = Some(892403750),
          address = "https://example.org/fully_loaded_1",
          apiVersion = Some("unstable"),
          fields = List.empty,
          format = "json",
          topic = "orders/cancelled",
          metafieldNamespaces = List.empty,
          privateMetafieldNamespaces = List.empty,
          createdAt = "2021-12-01T05:23:43-05:00",
          updatedAt = "2021-12-01T05:23:43-05:00"
        ),
        WebHook(
          id = Some(901431826),
          address = "https://apple.com/uninstall",
          apiVersion = Some("unstable"),
          fields = List.empty,
          format = "json",
          topic = "app/uninstalled",
          metafieldNamespaces = List.empty,
          privateMetafieldNamespaces = List.empty,
          createdAt = "2022-04-06T08:07:43-04:00",
          updatedAt = "2022-04-06T08:07:43-04:00"
        ),
        WebHook(
          id = Some(1014196360),
          address = "https://example.org/app_uninstalled",
          apiVersion = Some("unstable"),
          fields = List.empty,
          format = "json",
          topic = "app/uninstalled",
          metafieldNamespaces = List.empty,
          privateMetafieldNamespaces = List.empty,
          createdAt = "2022-04-06T08:07:43-04:00",
          updatedAt = "2022-04-06T08:07:43-04:00"
        )
      )
    )
  )

}
