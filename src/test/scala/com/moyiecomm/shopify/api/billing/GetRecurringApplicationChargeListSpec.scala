package com.moyiecomm.shopify.api.billing

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.billing.models.RecurringApplicationCharge
import com.moyiecomm.shopify.api.shared.models.Accepted
import sttp.model.{Method, StatusCode}

import java.time.LocalDate

class GetRecurringApplicationChargeListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetRecurringApplicationChargeList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/recurring_application_charges.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/recurring_application_charges.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "recurring_application_charges": [
                      |    {
                      |      "id": 455696195,
                      |      "name": "Super Mega Plan",
                      |      "api_client_id": 755357713,
                      |      "price": "15.00",
                      |      "status": "accepted",
                      |      "return_url": "http://yourapp.com",
                      |      "billing_on": "2022-04-05",
                      |      "created_at": "2022-04-05T13:17:47-04:00",
                      |      "updated_at": "2022-04-05T13:27:42-04:00",
                      |      "test": null,
                      |      "activated_on": null,
                      |      "cancelled_on": null,
                      |      "trial_days": 0,
                      |      "trial_ends_on": null,
                      |      "decorated_return_url": "http://yourapp.com?charge_id=455696195"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        RecurringApplicationCharge(
          activatedOn = None,
          apiClientId = Some(755357713),
          billingOn = Some(LocalDate.parse("2022-04-05")),
          cancelledOn = None,
          cappedAmount = None,
          confirmationUrl = None,
          decoratedReturnUrl = Some("http://yourapp.com?charge_id=455696195"),
          createdAt = "2022-04-05T13:17:47-04:00",
          id = Some(455696195),
          name = "Super Mega Plan",
          price = 15.00,
          returnUrl = Some("http://yourapp.com"),
          status = Some(Accepted),
          terms = None,
          test = None,
          trialDays = Some(0),
          trialEndsOn = None,
          updatedAt = "2022-04-05T13:27:42-04:00",
          balanceUsed = None,
          balanceRemaining = None,
          riskLevel = None,
          updateCappedAmountUrl = None
        )
      )
    )
  )

}
