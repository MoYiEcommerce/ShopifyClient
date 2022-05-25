package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.orders.models.{Refund, Transaction}
import com.moyiecomm.shopify.api.shared.models.{RefundLineItem, RefundableShipping}
import sttp.model.{Method, StatusCode}

class CalculateRefundSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CalculateRefund(
      Refund(
        id = None,
        orderId = Some(450789469),
        userId = None,
        note = None,
        currency = None,
        restock = None,
        shipping = Some(RefundableShipping(None, None, None, Some(true))),
        duties = List.empty,
        orderAdjustments = List.empty,
        transactions = List.empty,
        refundDuties = List.empty,
        refundLineItems = List(
          RefundLineItem(
            lineItemId = 518995019,
            quantity = 1,
            restockType = "no_restock",
            locationId = None
          )
        ),
        createdAt = None,
        processedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/450789469/refunds/calculate.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"refund":{"shipping":{"full_refund":true},"refund_line_items":[{"line_item_id":518995019,"quantity":1,"restock_type":"no_restock"}]}}"""
    ),
    mapping = post("/admin/api/2022-01/orders/450789469/refunds/calculate.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"refund":{"shipping":{"full_refund":true},"refund_line_items":[{"line_item_id":518995019,"quantity":1,"restock_type":"no_restock"}]}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody(
            """
              |{
              |  "refund": {
              |    "shipping": {
              |      "amount": "5.00",
              |      "tax": "0.00",
              |      "maximum_refundable": "5.00"
              |    },
              |    "duties": [],
              |    "total_duties_set": {
              |      "shop_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      },
              |      "presentment_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      }
              |    },
              |    "additional_fees": [],
              |    "total_additional_fees_set": {
              |      "shop_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      },
              |      "presentment_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      }
              |    },
              |    "refund_line_items": [
              |      {
              |        "quantity": 1,
              |        "line_item_id": 518995019,
              |        "location_id": null,
              |        "restock_type": "no_restock",
              |        "price": "199.00",
              |        "subtotal": "195.67",
              |        "total_tax": "3.98",
              |        "discounted_price": "199.00",
              |        "discounted_total_price": "199.00",
              |        "total_cart_discount_amount": "3.33"
              |      }
              |    ],
              |    "transactions": [
              |      {
              |        "order_id": 450789469,
              |        "kind": "suggested_refund",
              |        "gateway": "bogus",
              |        "parent_id": 801038806,
              |        "amount": "41.94",
              |        "currency": "USD",
              |        "maximum_refundable": "41.94"
              |      }
              |    ],
              |    "currency": "USD"
              |  }
              |}
              |""".stripMargin
          )
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      Refund(
        id = None,
        orderId = None,
        userId = None,
        note = None,
        currency = Some("USD"),
        restock = None,
        shipping = Some(
          RefundableShipping(
            amount = Some(5.00),
            tax = Some(0.00),
            maximumRefundable = Some(5.00),
            fullRefund = None
          )
        ),
        duties = List.empty,
        orderAdjustments = List.empty,
        transactions = List(
          Transaction(
            id = None,
            orderId = Some(450789469),
            kind = Some("suggested_refund"),
            gateway = Some("bogus"),
            status = None,
            message = None,
            createdAt = None,
            test = None,
            authorization = None,
            locationId = None,
            userId = None,
            parentId = Some(801038806),
            processedAt = None,
            sourceName = None,
            deviceId = None,
            errorCode = None,
            paymentDetails = None,
            currencyExchangeAdjustment = None,
            amount = Some("41.94"),
            paymentsRefundAttributes = None,
            currency = Some("USD"),
            authorizationExpiresAt = None,
            extendedAuthorizationAttributes = None,
            maximumRefundable = Some(41.94)
          )
        ),
        refundDuties = List.empty,
        refundLineItems = List(
          RefundLineItem(
            lineItemId = 518995019,
            quantity = 1,
            restockType = "no_restock",
            locationId = None
          )
        ),
        createdAt = None,
        processedAt = None
      )
    )
  )
}
