package com.moyiecomm.shopify.api.billing

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.billing.models.ApplicationCredit
import sttp.model.{Method, StatusCode}

class GetApplicationCreditListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetApplicationCreditList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/application_credits.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/application_credits.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "application_credits": [
                      |    {
                      |      "id": 140583599,
                      |      "amount": "5.00",
                      |      "description": "credit for application refund",
                      |      "test": null
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        ApplicationCredit(description = Some("credit for application refund"), id = Some(140583599), amount = 5.0, test = None)
      )
    )
  )

}
