package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.orders.models.{Refund, Transaction}
import com.moyiecomm.shopify.api.shared.models.{AmountSet, OrderAdjustment, Price}
import sttp.model.{Method, StatusCode}

class CreateRefundSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateRefund(
      450789469,
      Refund(
        id = None,
        orderId = None,
        userId = None,
        note = None,
        currency = Some("USD"),
        restock = None,
        shipping = None,
        duties = List.empty,
        orderAdjustments = List.empty,
        transactions = List(
          Transaction(
            id = None,
            orderId = None,
            kind = Some("refund"),
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
            amount = Some("5.0"),
            paymentsRefundAttributes = None,
            currency = None,
            authorizationExpiresAt = None,
            extendedAuthorizationAttributes = None,
            maximumRefundable = None
          )
        ),
        refundDuties = List.empty,
        refundLineItems = List.empty,
        createdAt = None,
        processedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/450789469/refunds.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"refund":{"currency":"USD","transactions":[{"parent_id":801038806,"amount":"5.0","kind":"refund","gateway":"bogus"}]}}"""
    ),
    mapping = post("/admin/api/2022-01/orders/450789469/refunds.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"refund":{"currency":"USD","transactions":[{"parent_id":801038806,"amount":"5.0","kind":"refund","gateway":"bogus"}]}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody(
            """
              |{
              |  "refund": {
              |    "id": 929361464,
              |    "order_id": 450789469,
              |    "created_at": "2022-04-05T12:55:25-04:00",
              |    "note": null,
              |    "user_id": null,
              |    "processed_at": "2022-04-05T12:55:25-04:00",
              |    "restock": false,
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
              |    "admin_graphql_api_id": "gid://shopify/Refund/929361464",
              |    "refund_line_items": [],
              |    "transactions": [
              |      {
              |        "id": 1068278467,
              |        "order_id": 450789469,
              |        "kind": "refund",
              |        "gateway": "bogus",
              |        "status": "success",
              |        "message": "Bogus Gateway: Forced success",
              |        "created_at": "2022-04-05T12:55:25-04:00",
              |        "test": true,
              |        "authorization": null,
              |        "location_id": null,
              |        "user_id": null,
              |        "parent_id": 801038806,
              |        "processed_at": "2022-04-05T12:55:25-04:00",
              |        "device_id": null,
              |        "error_code": null,
              |        "source_name": "755357713",
              |        "receipt": {},
              |        "amount": "5.00",
              |        "currency": "USD",
              |        "admin_graphql_api_id": "gid://shopify/OrderTransaction/1068278467"
              |      }
              |    ],
              |    "order_adjustments": [
              |      {
              |        "id": 1030976843,
              |        "order_id": 450789469,
              |        "refund_id": 929361464,
              |        "amount": "-5.00",
              |        "tax_amount": "0.00",
              |        "kind": "shipping_refund",
              |        "reason": "Shipping refund",
              |        "amount_set": {
              |          "shop_money": {
              |            "amount": "-5.00",
              |            "currency_code": "USD"
              |          },
              |          "presentment_money": {
              |            "amount": "-5.00",
              |            "currency_code": "USD"
              |          }
              |        },
              |        "tax_amount_set": {
              |          "shop_money": {
              |            "amount": "0.00",
              |            "currency_code": "USD"
              |          },
              |          "presentment_money": {
              |            "amount": "0.00",
              |            "currency_code": "USD"
              |          }
              |        }
              |      }
              |    ]
              |  }
              |}
              |""".stripMargin
          )
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      Refund(
        id = Some(929361464),
        orderId = Some(450789469),
        userId = None,
        note = None,
        currency = None,
        restock = Some(false),
        shipping = None,
        duties = List.empty,
        orderAdjustments = List(
          OrderAdjustment(
            id = 1030976843,
            orderId = 450789469,
            refundId = 929361464,
            amount = -5.00,
            taxAmount = 0.00,
            kind = "shipping_refund",
            reason = "Shipping refund",
            amountSet = AmountSet(Price("-5.00", "USD"), presentmentMoney = Price("-5.00", "USD")),
            taxAmountSet = AmountSet(Price("0.00", "USD"), presentmentMoney = Price("0.00", "USD"))
          )
        ),
        transactions = List(
          Transaction(
            id = Some(1068278467),
            orderId = Some(450789469),
            kind = Some("refund"),
            gateway = Some("bogus"),
            status = Some("success"),
            message = Some("Bogus Gateway: Forced success"),
            createdAt = "2022-04-05T12:55:25-04:00",
            test = Some(true),
            authorization = None,
            locationId = None,
            userId = None,
            parentId = Some(801038806),
            processedAt = "2022-04-05T12:55:25-04:00",
            sourceName = Some("755357713"),
            deviceId = None,
            errorCode = None,
            paymentDetails = None,
            currencyExchangeAdjustment = None,
            amount = Some("5.00"),
            paymentsRefundAttributes = None,
            currency = Some("USD"),
            authorizationExpiresAt = None,
            extendedAuthorizationAttributes = None,
            maximumRefundable = None
          )
        ),
        refundDuties = List.empty,
        refundLineItems = List.empty,
        createdAt = "2022-04-05T12:55:25-04:00",
        processedAt = "2022-04-05T12:55:25-04:00"
      )
    )
  )
}
