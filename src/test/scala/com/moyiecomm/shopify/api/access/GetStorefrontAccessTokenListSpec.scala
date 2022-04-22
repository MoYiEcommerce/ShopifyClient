package com.moyiecomm.shopify.api.access

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, get}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.access.models.StorefrontAccessToken
import sttp.model.{Method, StatusCode}

class GetStorefrontAccessTokenListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetStorefrontAccessTokenList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/storefront_access_tokens.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/storefront_access_tokens.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody(
            """
              |{
              |  "storefront_access_tokens": [
              |    {
              |      "access_token": "378d95641257a4ab3feff967ee234f4d",
              |      "access_scope": "unauthenticated_read_product_listings",
              |      "created_at": "2022-04-05T12:51:55-04:00",
              |      "id": 755357713,
              |      "admin_graphql_api_id": "gid://shopify/StorefrontAccessToken/755357713",
              |      "title": "API Client Extension"
              |    }
              |  ]
              |}
              |""".stripMargin
          )
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        StorefrontAccessToken(
          id = Some(755357713),
          accessToken = Some("378d95641257a4ab3feff967ee234f4d"),
          accessScope = Some("unauthenticated_read_product_listings"),
          createdAt = "2022-04-05T12:51:55-04:00",
          title = "API Client Extension"
        )
      )
    )
  )

}
