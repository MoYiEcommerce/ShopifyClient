package com.moyiecomm.shopify.api.billing

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.billing.models.UsageCharge
import sttp.model.{Method, StatusCode}

class GetUsageChargeListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetUsageChargeList(455696195),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/recurring_application_charges/455696195/usage_charges.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/recurring_application_charges/455696195/usage_charges.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "usage_charges": [
                      |    {
                      |      "id": 1034618211,
                      |      "description": "Super Mega Plan Add-ons",
                      |      "price": "10.00",
                      |      "created_at": "2022-04-05T12:56:03-04:00",
                      |      "billing_on": null,
                      |      "balance_used": 10,
                      |      "balance_remaining": 90,
                      |      "risk_level": 0
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        UsageCharge(
          createdAt = "2022-04-05T12:56:03-04:00",
          description = "Super Mega Plan Add-ons",
          id = Some(1034618211),
          price = 10.00,
          recurringApplicationChargeId = None,
          updatedAt = None,
          billingOn = None,
          balanceUsed = Some(10),
          balanceRemaining = Some(90),
          riskLevel = Some(0)
        )
      )
    )
  )

}
