package com.moyiecomm.shopify.api.access

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.access.models.StorefrontAccessToken
import sttp.model.{Method, StatusCode}

class CreateStorefrontAccessTokenSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateStorefrontAccessToken(
      StorefrontAccessToken(id = None, accessToken = None, accessScope = None, createdAt = None, title = "Test")
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/storefront_access_tokens.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some("""{"storefront_access_token":{"title":"Test"}}"""),
    mapping = post("/admin/api/2022-01/storefront_access_tokens.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalTo("""{"storefront_access_token":{"title":"Test"}}""")
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "storefront_access_token": {
                      |    "access_token": "acb63aef87d74a49eb3f4b994a5e342b",
                      |    "access_scope": "unauthenticated_read_product_listings",
                      |    "created_at": "2022-04-05T12:56:06-04:00",
                      |    "id": 1003303990,
                      |    "admin_graphql_api_id": "gid://shopify/StorefrontAccessToken/1003303990",
                      |    "title": "Test"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      StorefrontAccessToken(
        id = Some(1003303990),
        accessToken = Some("acb63aef87d74a49eb3f4b994a5e342b"),
        accessScope = Some("unauthenticated_read_product_listings"),
        createdAt = "2022-04-05T12:56:06-04:00",
        title = "Test"
      )
    )
  )

}
