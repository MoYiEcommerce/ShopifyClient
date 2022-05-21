package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, get}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.{Address, Customer}
import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.orders.models.{AbandonedCheckout, OrderRisk}
import com.moyiecomm.shopify.api.shared.models._
import sttp.model.{Method, StatusCode}

import java.time.ZonedDateTime

class GetOrderRiskListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetOrderRiskList(450789469),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/450789469/risks.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/orders/450789469/risks.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "risks": [
                      |    {
                      |      "id": 284138680,
                      |      "order_id": 450789469,
                      |      "checkout_id": null,
                      |      "source": "External",
                      |      "score": "1.0",
                      |      "recommendation": "cancel",
                      |      "display": true,
                      |      "cause_cancel": true,
                      |      "message": "This order was placed from a proxy IP",
                      |      "merchant_message": "This order was placed from a proxy IP"
                      |    },
                      |    {
                      |      "id": 1029151491,
                      |      "order_id": 450789469,
                      |      "checkout_id": 901414060,
                      |      "source": "External",
                      |      "score": "1.0",
                      |      "recommendation": "cancel",
                      |      "display": true,
                      |      "cause_cancel": true,
                      |      "message": "This order came from an anonymous proxy",
                      |      "merchant_message": "This order came from an anonymous proxy"
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
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
        ),
        OrderRisk(
          id = Some(1029151491),
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
  )
}
