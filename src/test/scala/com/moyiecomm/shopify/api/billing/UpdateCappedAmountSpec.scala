package com.moyiecomm.shopify.api.billing

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.billing.models.RecurringApplicationCharge
import com.moyiecomm.shopify.api.shared.models.Active
import sttp.model.{Method, StatusCode}

import java.time.LocalDate

class UpdateCappedAmountSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateCappedAmount(455696195, 200),
    expectedUrl =
      s"http://localhost:$port/admin/api/2022-01/recurring_application_charges/455696195/customize.json?recurring_application_charge%5Bcapped_amount%5D=200",
    expectedMethod = Method.PUT,
    expectedRequestBody = None,
    mapping = put(
      "/admin/api/2022-01/recurring_application_charges/455696195/customize.json?recurring_application_charge%5Bcapped_amount%5D=200"
    )
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "recurring_application_charge": {
                      |    "return_url": "http://yourapp.com/",
                      |    "id": 455696195,
                      |    "name": "Super Mega Plan",
                      |    "api_client_id": 755357713,
                      |    "price": "15.00",
                      |    "status": "active",
                      |    "billing_on": null,
                      |    "created_at": "2022-04-05T13:17:47-04:00",
                      |    "updated_at": "2022-04-05T13:27:51-04:00",
                      |    "test": null,
                      |    "activated_on": "2022-04-05",
                      |    "cancelled_on": null,
                      |    "trial_days": 0,
                      |    "capped_amount": "100.00",
                      |    "trial_ends_on": "2022-04-05",
                      |    "balance_used": 0,
                      |    "balance_remaining": 100,
                      |    "risk_level": 0,
                      |    "decorated_return_url": "http://yourapp.com/?charge_id=455696195",
                      |    "update_capped_amount_url": "https://jsmith.myshopify.com/admin/charges/755357713/455696195/RecurringApplicationCharge/confirm_update_capped_amount?signature=BAh7BzoHaWRpBENfKRs6EmF1dG9fYWN0aXZhdGVG--f22d88ab510ea02154922370bbb05763703912cd"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      RecurringApplicationCharge(
        activatedOn = Some(LocalDate.parse("2022-04-05")),
        apiClientId = Some(755357713),
        billingOn = None,
        cancelledOn = None,
        cappedAmount = Some(100.00),
        confirmationUrl = None,
        decoratedReturnUrl = Some("http://yourapp.com/?charge_id=455696195"),
        createdAt = "2022-04-05T13:17:47-04:00",
        id = Some(455696195),
        name = "Super Mega Plan",
        price = 15.00,
        returnUrl = Some("http://yourapp.com/"),
        status = Some(Active),
        terms = None,
        test = None,
        trialDays = Some(0),
        trialEndsOn = Some(LocalDate.parse("2022-04-05")),
        updatedAt = "2022-04-05T13:27:51-04:00",
        balanceUsed = Some(0),
        balanceRemaining = Some(100),
        riskLevel = Some(0),
        updateCappedAmountUrl = Some(
          "https://jsmith.myshopify.com/admin/charges/755357713/455696195/RecurringApplicationCharge/confirm_update_capped_amount?signature=BAh7BzoHaWRpBENfKRs6EmF1dG9fYWN0aXZhdGVG--f22d88ab510ea02154922370bbb05763703912cd"
        )
      )
    )
  )

}
