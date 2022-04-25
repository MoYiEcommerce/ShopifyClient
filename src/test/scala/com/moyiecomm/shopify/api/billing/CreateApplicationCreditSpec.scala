package com.moyiecomm.shopify.api.billing

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, equalTo, post}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.billing.models.ApplicationCredit
import sttp.model.{Method, StatusCode}

class CreateApplicationCreditSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateApplicationCredit(
      ApplicationCredit(description = Some("application credit for refund"), id = None, amount = 5.0, test = None)
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/application_credits.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some("""{"application_credit":{"description":"application credit for refund","amount":5.0}}"""),
    mapping = post("/admin/api/2022-01/application_credits.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalTo(
          """{"application_credit":{"description":"application credit for refund","amount":5.0}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "application_credit": {
                      |    "id": 1031636127,
                      |    "amount": "5.00",
                      |    "description": "application credit for refund",
                      |    "test": null
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      ApplicationCredit(
        description = Some("application credit for refund"),
        id = Some(1031636127),
        amount = 5.0,
        test = None
      )
    )
  )

}
