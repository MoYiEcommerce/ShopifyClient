package com.moyiecomm.shopify.api.discounts

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import sttp.model.{Method, StatusCode}

class UpdateDiscountCodeSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateDiscountCodeById(
      507328175,
      DiscountCode(
        id = Some(507328175),
        code = "WINTERSALE20OFF",
        usageCount = None,
        priceRuleId = None,
        createdAt = None,
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/price_rules/507328175/discount_codes/507328175.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some("""{"discount_code":{"id":507328175,"code":"WINTERSALE20OFF"}}"""),
    mapping = put("/admin/api/2022-01/price_rules/507328175/discount_codes/507328175.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"discount_code":{"id":507328175,"code":"WINTERSALE20OFF"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "discount_code": {
                      |    "id": 507328175,
                      |    "price_rule_id": 507328175,
                      |    "code": "WINTERSALE20OFF",
                      |    "usage_count": 0,
                      |    "created_at": "2022-04-05T13:05:24-04:00",
                      |    "updated_at": "2022-04-05T13:06:58-04:00"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      DiscountCode(
        id = Some(507328175),
        code = "WINTERSALE20OFF",
        usageCount = Some(0),
        priceRuleId = Some(507328175),
        createdAt = "2022-04-05T13:05:24-04:00",
        updatedAt = "2022-04-05T13:06:58-04:00"
      )
    )
  )
}
