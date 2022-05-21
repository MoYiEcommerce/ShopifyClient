package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, get}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.orders.models.OrderRisk
import sttp.model.{Method, StatusCode}

class GetOrderRiskByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetOrderRiskById(450789469, 284138680),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/450789469/risks/284138680.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/orders/450789469/risks/284138680.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "risk": {
                      |    "id": 284138680,
                      |    "order_id": 450789469,
                      |    "checkout_id": null,
                      |    "source": "External",
                      |    "score": "1.0",
                      |    "recommendation": "cancel",
                      |    "display": true,
                      |    "cause_cancel": true,
                      |    "message": "This order was placed from a proxy IP",
                      |    "merchant_message": "This order was placed from a proxy IP"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      OrderRisk(
        id = Some(284138680),
        orderId = 450789469,
        checkoutId = None,
        source = "External",
        score = 1.0,
        recommendation = "cancel",
        display = true,
        causeCancel = true,
        message = "This order was placed from a proxy IP",
        merchantMessage = Some("This order was placed from a proxy IP")
      )
    )
  )
}
