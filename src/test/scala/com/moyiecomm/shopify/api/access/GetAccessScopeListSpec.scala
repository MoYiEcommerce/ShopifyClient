package com.moyiecomm.shopify.api.access

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.access.models.AccessScope
import sttp.model.{Method, StatusCode}

class GetAccessScopeListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetAccessScopeList(),
    expectedUrl = s"http://localhost:$port/admin/oauth/access_scopes.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/oauth/access_scopes.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "access_scopes": [
                      |    {
                      |      "handle": "read_products"
                      |    },
                      |    {
                      |      "handle": "write_orders"
                      |    },
                      |    {
                      |      "handle": "read_orders"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(List(AccessScope("read_products"), AccessScope("write_orders"), AccessScope("read_orders")))
  )
}
