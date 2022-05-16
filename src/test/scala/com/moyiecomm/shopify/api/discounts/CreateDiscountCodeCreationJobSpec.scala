package com.moyiecomm.shopify.api.discounts

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.discounts.models.{DiscountCode, DiscountCodeCreationJob}
import sttp.model.{Method, StatusCode}

class CreateDiscountCodeCreationJobSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateDiscountCodeCreationJob(
      507328175,
      List(
        DiscountCode(
          id = None,
          code = "SUMMER1",
          usageCount = None,
          priceRuleId = None,
          createdAt = None,
          updatedAt = None,
          amount = None,
          `type` = None
        ),
        DiscountCode(
          id = None,
          code = "SUMMER2",
          usageCount = None,
          priceRuleId = None,
          createdAt = None,
          updatedAt = None,
          amount = None,
          `type` = None
        ),
        DiscountCode(
          id = None,
          code = "SUMMER3",
          usageCount = None,
          priceRuleId = None,
          createdAt = None,
          updatedAt = None,
          amount = None,
          `type` = None
        )
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/price_rules/507328175/batch.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some("""{"discount_codes":[{"code":"SUMMER1"},{"code":"SUMMER2"},{"code":"SUMMER3"}]}"""),
    mapping = post("/admin/api/2022-01/price_rules/507328175/batch.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"discount_codes":[{"code":"SUMMER1"},{"code":"SUMMER2"},{"code":"SUMMER3"}]}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "discount_code_creation": {
                      |    "id": 989355119,
                      |    "price_rule_id": 507328175,
                      |    "started_at": null,
                      |    "completed_at": null,
                      |    "created_at": "2022-04-05T13:06:51-04:00",
                      |    "updated_at": "2022-04-05T13:06:51-04:00",
                      |    "status": "queued",
                      |    "codes_count": 3,
                      |    "imported_count": 0,
                      |    "failed_count": 0,
                      |    "logs": []
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      DiscountCodeCreationJob(
        id = 989355119,
        price_rule_id = 507328175,
        started_at = None,
        completed_at = None,
        created_at = "2022-04-05T13:06:51-04:00",
        updated_at = "2022-04-05T13:06:51-04:00",
        status = "queued",
        codes_count = 3,
        imported_count = 0,
        failed_count = 0,
        logs = List.empty
      )
    )
  )

}
