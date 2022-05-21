package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.orders.models.OrderRisk
import sttp.model.{Method, StatusCode}

class UpdateOrderRiskByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateOrderRiskById(
      OrderRisk(
        id = Some(284138680),
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
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/450789469/risks/284138680.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some(
      """{"risk":{"id":284138680,"message":"This order came from an anonymous proxy","recommendation":"cancel","score":1.0,"source":"External","cause_cancel":true,"display":true}}"""
    ),
    mapping = put("/admin/api/2022-01/orders/450789469/risks/284138680.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"risk":{"id":284138680,"message":"This order came from an anonymous proxy","recommendation":"cancel","score":1.0,"source":"External","cause_cancel":true,"display":true}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody(
            """
              |{
              |  "risk": {
              |    "id": 284138680,
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
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      OrderRisk(
        id = Some(284138680),
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
