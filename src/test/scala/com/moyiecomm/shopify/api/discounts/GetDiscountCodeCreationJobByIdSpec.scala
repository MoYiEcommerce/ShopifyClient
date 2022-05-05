package com.moyiecomm.shopify.api.discounts

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.discounts.models.DiscountCodeCreationJob
import sttp.model.{Method, StatusCode}

class GetDiscountCodeCreationJobByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetDiscountCodeCreationJobById(507328175, 173232803),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/price_rules/507328175/batch/173232803.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/price_rules/507328175/batch/173232803.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "discount_code_creation": {
                      |    "id": 173232803,
                      |    "price_rule_id": 507328175,
                      |    "started_at": null,
                      |    "completed_at": null,
                      |    "created_at": "2022-04-05T13:05:24-04:00",
                      |    "updated_at": "2022-04-05T13:05:24-04:00",
                      |    "status": "queued",
                      |    "codes_count": 3,
                      |    "imported_count": 0,
                      |    "failed_count": 0,
                      |    "logs": []
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      DiscountCodeCreationJob(
        id = 173232803,
        price_rule_id = 507328175,
        started_at = None,
        completed_at = None,
        created_at = "2022-04-05T13:05:24-04:00",
        updated_at = "2022-04-05T13:05:24-04:00",
        status = "queued",
        codes_count = 3,
        imported_count = 0,
        failed_count = 0,
        logs = List.empty
      )
    )
  )

}
