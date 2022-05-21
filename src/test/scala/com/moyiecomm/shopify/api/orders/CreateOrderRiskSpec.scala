package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, equalToJson, post}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.orders.models.OrderRisk
import sttp.model.{Method, StatusCode}

class CreateOrderRiskSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateOrderRisk(
      OrderRisk(
        id = None,
        orderId = 450789469,
        checkoutId = None,
        source = "External",
        score = 1.0,
        recommendation = "cancel",
        display = true,
        causeCancel = true,
        message = "This order came from an anonymous proxy",
        merchantMessage = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/450789469/risks.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"risk":{"message":"This order came from an anonymous proxy","recommendation":"cancel","score":1.0,"source":"External","cause_cancel":true,"display":true}}"""
    ),
    mapping = post("/admin/api/2022-01/orders/450789469/risks.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"risk":{"message":"This order came from an anonymous proxy","recommendation":"cancel","score":1.0,"source":"External","cause_cancel":true,"display":true}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody(
            """
              |{
              |  "risk": {
              |    "id": 1029151489,
              |    "order_id": 450789469,
              |    "checkout_id": 901414060,
              |    "source": "External",
              |    "score": "1.0",
              |    "recommendation": "cancel",
              |    "display": true,
              |    "cause_cancel": true,
              |    "message": "This order came from an anonymous proxy",
              |    "merchant_message": "This order came from an anonymous proxy"
              |  }
              |}
              |""".stripMargin
          )
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      OrderRisk(
        id = Some(1029151489),
        orderId = 450789469,
        checkoutId = Some(901414060),
        source = "External",
        score = 1.0,
        recommendation = "cancel",
        display = true,
        causeCancel = true,
        message = "This order came from an anonymous proxy",
        merchantMessage = Some("This order came from an anonymous proxy")
      )
    )
  )

}
