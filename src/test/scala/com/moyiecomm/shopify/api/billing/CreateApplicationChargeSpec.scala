package com.moyiecomm.shopify.api.billing

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.billing.models.ApplicationCharge
import com.moyiecomm.shopify.api.shared.models.Pending
import sttp.model.{Method, StatusCode}

class CreateApplicationChargeSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateApplicationCharge(
      ApplicationCharge(
        confirmationUrl = None,
        createdAt = None,
        id = None,
        apiClientId = None,
        name = "Super Duper Expensive action",
        price = 100.0,
        returnUrl = Some("http://super-duper.shopifyapps.com"),
        status = None,
        chargeType = None,
        decoratedReturnUrl = None,
        test = Some(true),
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/application_charges.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"application_charge":{"name":"Super Duper Expensive action","price":100.0,"return_url":"http://super-duper.shopifyapps.com","test":true}}"""
    ),
    mapping = post("/admin/api/2022-01/application_charges.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalTo(
          """{"application_charge":{"name":"Super Duper Expensive action","price":100.0,"return_url":"http://super-duper.shopifyapps.com","test":true}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "application_charge": {
                      |    "id": 1017262349,
                      |    "name": "Super Duper Expensive action",
                      |    "api_client_id": 755357713,
                      |    "price": "100.00",
                      |    "status": "pending",
                      |    "return_url": "http://super-duper.shopifyapps.com/",
                      |    "test": true,
                      |    "created_at": "2022-04-05T13:06:28-04:00",
                      |    "updated_at": "2022-04-05T13:06:28-04:00",
                      |    "charge_type": null,
                      |    "decorated_return_url": "http://super-duper.shopifyapps.com/?charge_id=1017262349",
                      |    "confirmation_url": "https://jsmith.myshopify.com/admin/charges/755357713/1017262349/ApplicationCharge/confirm_application_charge?signature=BAh7BzoHaWRpBA0xojw6EmF1dG9fYWN0aXZhdGVU--1b6672b89ec9e9ef1b9d6505e962c8ab10de61a1"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      ApplicationCharge(
        confirmationUrl = Some(
          "https://jsmith.myshopify.com/admin/charges/755357713/1017262349/ApplicationCharge/confirm_application_charge?signature=BAh7BzoHaWRpBA0xojw6EmF1dG9fYWN0aXZhdGVU--1b6672b89ec9e9ef1b9d6505e962c8ab10de61a1"
        ),
        createdAt = "2022-04-05T13:06:28-04:00",
        id = Some(1017262349),
        apiClientId = Some(755357713),
        name = "Super Duper Expensive action",
        price = 100.0,
        returnUrl = Some("http://super-duper.shopifyapps.com/"),
        status = Some(Pending),
        chargeType = None,
        decoratedReturnUrl = Some("http://super-duper.shopifyapps.com/?charge_id=1017262349"),
        test = Some(true),
        updatedAt = "2022-04-05T13:06:28-04:00"
      )
    )
  )

}
