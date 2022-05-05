package com.moyiecomm.shopify.api.discounts

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import sttp.model.{Method, StatusCode}

class GetDiscountCodeLocationSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetDiscountCodeLocation("SUMMERSALE10OFF"),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/discount_codes/lookup.json?code=SUMMERSALE10OFF",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/discount_codes/lookup.json?code=SUMMERSALE10OFF")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(303)
          .withBody("""
                      |{}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.SeeOther,
    expectedResponseBody = None
  )
}
