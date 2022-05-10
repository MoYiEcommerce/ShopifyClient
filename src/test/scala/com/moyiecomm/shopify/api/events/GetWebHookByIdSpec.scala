package com.moyiecomm.shopify.api.events

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.events.models.WebHook
import sttp.model.{Method, StatusCode}

class GetWebHookByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetWebHookById(4759306),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/webhooks/4759306.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/webhooks/4759306.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "webhook": {
                      |    "id": 4759306,
                      |    "address": "https://apple.com",
                      |    "topic": "orders/create",
                      |    "created_at": "2022-04-06T08:07:43-04:00",
                      |    "updated_at": "2022-04-06T08:07:43-04:00",
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
        address = "https://apple.com",
        apiVersion = Some("unstable"),
        fields = List.empty,
        format = "json",
        topic = "orders/create",
        metafieldNamespaces = List.empty,
        privateMetafieldNamespaces = List.empty,
        createdAt = "2022-04-06T08:07:43-04:00",
        updatedAt = "2022-04-06T08:07:43-04:00"
      )
    )
  )

}
