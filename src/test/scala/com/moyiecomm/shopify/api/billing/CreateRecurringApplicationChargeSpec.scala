package com.moyiecomm.shopify.api.billing

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.billing.models.RecurringApplicationCharge
import com.moyiecomm.shopify.api.shared.models.Pending
import sttp.model.{Method, StatusCode}

class CreateRecurringApplicationChargeSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateRecurringApplicationCharge(
      RecurringApplicationCharge(
        activatedOn = None,
        apiClientId = None,
        billingOn = None,
        cancelledOn = None,
        cappedAmount = None,
        confirmationUrl = None,
        decoratedReturnUrl = None,
        createdAt = None,
        id = None,
        name = "Super Duper Plan",
        price = 10.0,
        returnUrl = Some("http://super-duper.shopifyapps.com"),
        status = None,
        terms = None,
        test = None,
        trialDays = None,
        trialEndsOn = None,
        updatedAt = None,
        balanceUsed = None,
        balanceRemaining = None,
        riskLevel = None,
        updateCappedAmountUrl = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/recurring_application_charges.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"recurring_application_charge":{"name":"Super Duper Plan","price":10.0,"return_url":"http://super-duper.shopifyapps.com"}}"""
    ),
    mapping = post("/admin/api/2022-01/recurring_application_charges.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"recurring_application_charge":{"name":"Super Duper Plan","price":10.0,"return_url":"http://super-duper.shopifyapps.com"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "recurring_application_charge": {
                      |    "id": 1029266959,
                      |    "name": "Super Duper Plan",
                      |    "api_client_id": 755357713,
                      |    "price": "10.00",
                      |    "status": "pending",
                      |    "return_url": "http://super-duper.shopifyapps.com/",
                      |    "billing_on": null,
                      |    "created_at": "2022-04-05T13:28:11-04:00",
                      |    "updated_at": "2022-04-05T13:28:11-04:00",
                      |    "test": null,
                      |    "activated_on": null,
                      |    "cancelled_on": null,
                      |    "trial_days": 0,
                      |    "trial_ends_on": null,
                      |    "decorated_return_url": "http://super-duper.shopifyapps.com/?charge_id=1029266959",
                      |    "confirmation_url": "https://jsmith.myshopify.com/admin/charges/755357713/1029266959/RecurringApplicationCharge/confirm_recurring_application_charge?signature=BAh7BzoHaWRpBA9eWT06EmF1dG9fYWN0aXZhdGVU--f6da6826caf9441c9fc206dd50a0882bd41fd770"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      RecurringApplicationCharge(
        activatedOn = None,
        apiClientId = Some(755357713),
        billingOn = None,
        cancelledOn = None,
        cappedAmount = None,
        confirmationUrl = Some(
          "https://jsmith.myshopify.com/admin/charges/755357713/1029266959/RecurringApplicationCharge/confirm_recurring_application_charge?signature=BAh7BzoHaWRpBA9eWT06EmF1dG9fYWN0aXZhdGVU--f6da6826caf9441c9fc206dd50a0882bd41fd770"
        ),
        decoratedReturnUrl = Some("http://super-duper.shopifyapps.com/?charge_id=1029266959"),
        createdAt = "2022-04-05T13:28:11-04:00",
        id = Some(1029266959),
        name = "Super Duper Plan",
        price = 10.0,
        returnUrl = Some("http://super-duper.shopifyapps.com/"),
        status = Some(Pending),
        terms = None,
        test = None,
        trialDays = Some(0),
        trialEndsOn = None,
        updatedAt = "2022-04-05T13:28:11-04:00",
        balanceUsed = None,
        balanceRemaining = None,
        riskLevel = None,
        updateCappedAmountUrl = None
      )
    )
  )

}
