package com.moyiecomm.shopify.api.billing

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.billing.models.UsageCharge
import sttp.model.{Method, StatusCode}

class CreateUsageChargeSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateUsageCharge(
      UsageCharge(
        createdAt = None,
        description = "Super Mega Plan 1000 emails",
        id = None,
        price = 1.0,
        recurringApplicationChargeId = Some(455696195),
        updatedAt = None,
        billingOn = None,
        balanceUsed = None,
        balanceRemaining = None,
        riskLevel = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/recurring_application_charges/455696195/usage_charges.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some("""{"usage_charge":{"description":"Super Mega Plan 1000 emails","price":1.0}}"""),
    mapping = post("/admin/api/2022-01/recurring_application_charges/455696195/usage_charges.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalTo(
          """{"usage_charge":{"description":"Super Mega Plan 1000 emails","price":1.0}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "usage_charge": {
                      |    "id": 1034618208,
                      |    "description": "Super Mega Plan 1000 emails",
                      |    "price": "1.00",
                      |    "created_at": "2022-04-05T12:56:00-04:00",
                      |    "billing_on": null,
                      |    "balance_used": 11,
                      |    "balance_remaining": 89,
                      |    "risk_level": 0
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      UsageCharge(
        createdAt = "2022-04-05T12:56:00-04:00",
        description = "Super Mega Plan 1000 emails",
        id = Some(1034618208),
        price = 1.00,
        recurringApplicationChargeId = None,
        updatedAt = None,
        billingOn = None,
        balanceUsed = Some(11),
        balanceRemaining = Some(89),
        riskLevel = Some(0)
      )
    )
  )

}
