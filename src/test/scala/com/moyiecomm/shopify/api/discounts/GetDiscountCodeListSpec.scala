package com.moyiecomm.shopify.api.discounts

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import sttp.model.{Method, StatusCode}

class GetDiscountCodeListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetDiscountCodeList(507328175),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/price_rules/507328175/discount_codes.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/price_rules/507328175/discount_codes.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "discount_codes": [
                      |    {
                      |      "id": 507328175,
                      |      "price_rule_id": 507328175,
                      |      "code": "SUMMERSALE10OFF",
                      |      "usage_count": 0,
                      |      "created_at": "2022-04-05T13:05:24-04:00",
                      |      "updated_at": "2022-04-05T13:05:24-04:00"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        DiscountCode(
          id = Some(507328175),
          code = "SUMMERSALE10OFF",
          usageCount = Some(0),
          priceRuleId = Some(507328175),
          createdAt = "2022-04-05T13:05:24-04:00",
          updatedAt = "2022-04-05T13:05:24-04:00",
          amount = None,
          `type` = None
        )
      )
    )
  )

}
