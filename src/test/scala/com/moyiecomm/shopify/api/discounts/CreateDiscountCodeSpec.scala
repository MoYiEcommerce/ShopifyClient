package com.moyiecomm.shopify.api.discounts

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import sttp.model.{Method, StatusCode}

class CreateDiscountCodeSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateDiscountCode(
      507328175,
      DiscountCode(
        id = None,
        code = "SUMMERSALE10OFF",
        usageCount = None,
        priceRuleId = None,
        createdAt = None,
        updatedAt = None,
        amount = None,
        `type` = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/price_rules/507328175/discount_codes.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some("""{"discount_code":{"code":"SUMMERSALE10OFF"}}"""),
    mapping = post("/admin/api/2022-01/price_rules/507328175/discount_codes.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"discount_code":{"code":"SUMMERSALE10OFF"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "discount_code": {
                      |    "id": 1054381139,
                      |    "price_rule_id": 507328175,
                      |    "code": "SUMMERSALE10OFF",
                      |    "usage_count": 0,
                      |    "created_at": "2022-04-05T13:06:57-04:00",
                      |    "updated_at": "2022-04-05T13:06:57-04:00"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      DiscountCode(
        id = Some(1054381139),
        code = "SUMMERSALE10OFF",
        usageCount = Some(0),
        priceRuleId = Some(507328175),
        createdAt = "2022-04-05T13:06:57-04:00",
        updatedAt = "2022-04-05T13:06:57-04:00",
        amount = None,
        `type` = None
      )
    )
  )
}
