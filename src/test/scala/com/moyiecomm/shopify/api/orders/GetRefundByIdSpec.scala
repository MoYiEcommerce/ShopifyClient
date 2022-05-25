package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, get}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.orders.models.{Refund, Transaction}
import com.moyiecomm.shopify.api.shared.models.RefundLineItem
import sttp.model.{Method, StatusCode}

class GetRefundByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetRefundById(450789469, 509562969),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/450789469/refunds/509562969.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/orders/450789469/refunds/509562969.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "refund": {
                      |      "id": 509562969,
                      |      "order_id": 450789469,
                      |      "created_at": "2022-04-05T12:51:55-04:00",
                      |      "note": "it broke during shipping",
                      |      "user_id": 548380009,
                      |      "processed_at": "2022-04-05T12:51:55-04:00",
                      |      "restock": true,
                      |      "admin_graphql_api_id": "gid://shopify/Refund/509562969",
                      |      "refund_line_items": [
                      |        {
                      |          "id": 104689539,
                      |          "quantity": 1,
                      |          "line_item_id": 703073504,
                      |          "location_id": 487838322,
                      |          "restock_type": "legacy_restock",
                      |          "subtotal": 195.67,
                      |          "total_tax": 3.98,
                      |          "subtotal_set": {
                      |            "shop_money": {
                      |              "amount": "195.67",
                      |              "currency_code": "USD"
                      |            },
                      |            "presentment_money": {
                      |              "amount": "195.67",
                      |              "currency_code": "USD"
                      |            }
                      |          },
                      |          "total_tax_set": {
                      |            "shop_money": {
                      |              "amount": "3.98",
                      |              "currency_code": "USD"
                      |            },
                      |            "presentment_money": {
                      |              "amount": "3.98",
                      |              "currency_code": "USD"
                      |            }
                      |          },
                      |          "line_item": {
                      |            "id": 703073504,
                      |            "variant_id": 457924702,
                      |            "title": "IPod Nano - 8gb",
                      |            "quantity": 1,
                      |            "sku": "IPOD2008BLACK",
                      |            "variant_title": "black",
                      |            "vendor": null,
                      |            "fulfillment_service": "manual",
                      |            "product_id": 632910392,
                      |            "requires_shipping": true,
                      |            "taxable": true,
                      |            "gift_card": false,
                      |            "name": "IPod Nano - 8gb - black",
                      |            "variant_inventory_management": "shopify",
                      |            "properties": [],
                      |            "product_exists": true,
                      |            "fulfillable_quantity": 1,
                      |            "grams": 200,
                      |            "price": "199.00",
                      |            "total_discount": "0.00",
                      |            "fulfillment_status": null,
                      |            "price_set": {
                      |              "shop_money": {
                      |                "amount": "199.00",
                      |                "currency_code": "USD"
                      |              },
                      |              "presentment_money": {
                      |                "amount": "199.00",
                      |                "currency_code": "USD"
                      |              }
                      |            },
                      |            "total_discount_set": {
                      |              "shop_money": {
                      |                "amount": "0.00",
                      |                "currency_code": "USD"
                      |              },
                      |              "presentment_money": {
                      |                "amount": "0.00",
                      |                "currency_code": "USD"
                      |              }
                      |            },
                      |            "discount_allocations": [
                      |              {
                      |                "amount": "3.33",
                      |                "discount_application_index": 0,
                      |                "amount_set": {
                      |                  "shop_money": {
                      |                    "amount": "3.33",
                      |                    "currency_code": "USD"
                      |                  },
                      |                  "presentment_money": {
                      |                    "amount": "3.33",
                      |                    "currency_code": "USD"
                      |                  }
                      |                }
                      |              }
                      |            ],
                      |            "admin_graphql_api_id": "gid://shopify/LineItem/703073504",
                      |            "tax_lines": [
                      |              {
                      |                "title": "State Tax",
                      |                "price": "3.98",
                      |                "rate": 0.06,
                      |                "price_set": {
                      |                  "shop_money": {
                      |                    "amount": "3.98",
                      |                    "currency_code": "USD"
                      |                  },
                      |                  "presentment_money": {
                      |                    "amount": "3.98",
                      |                    "currency_code": "USD"
                      |                  }
                      |                }
                      |              }
                      |            ]
                      |          }
                      |        },
                      |        {
                      |          "id": 709875399,
                      |          "quantity": 1,
                      |          "line_item_id": 466157049,
                      |          "location_id": 487838322,
                      |          "restock_type": "legacy_restock",
                      |          "subtotal": 195.66,
                      |          "total_tax": 3.98,
                      |          "subtotal_set": {
                      |            "shop_money": {
                      |              "amount": "195.66",
                      |              "currency_code": "USD"
                      |            },
                      |            "presentment_money": {
                      |              "amount": "195.66",
                      |              "currency_code": "USD"
                      |            }
                      |          },
                      |          "total_tax_set": {
                      |            "shop_money": {
                      |              "amount": "3.98",
                      |              "currency_code": "USD"
                      |            },
                      |            "presentment_money": {
                      |              "amount": "3.98",
                      |              "currency_code": "USD"
                      |            }
                      |          },
                      |          "line_item": {
                      |            "id": 466157049,
                      |            "variant_id": 39072856,
                      |            "title": "IPod Nano - 8gb",
                      |            "quantity": 1,
                      |            "sku": "IPOD2008GREEN",
                      |            "variant_title": "green",
                      |            "vendor": null,
                      |            "fulfillment_service": "manual",
                      |            "product_id": 632910392,
                      |            "requires_shipping": true,
                      |            "taxable": true,
                      |            "gift_card": false,
                      |            "name": "IPod Nano - 8gb - green",
                      |            "variant_inventory_management": "shopify",
                      |            "properties": [
                      |              {
                      |                "name": "Custom Engraving Front",
                      |                "value": "Happy Birthday"
                      |              },
                      |              {
                      |                "name": "Custom Engraving Back",
                      |                "value": "Merry Christmas"
                      |              }
                      |            ],
                      |            "product_exists": true,
                      |            "fulfillable_quantity": 1,
                      |            "grams": 200,
                      |            "price": "199.00",
                      |            "total_discount": "0.00",
                      |            "fulfillment_status": null,
                      |            "price_set": {
                      |              "shop_money": {
                      |                "amount": "199.00",
                      |                "currency_code": "USD"
                      |              },
                      |              "presentment_money": {
                      |                "amount": "199.00",
                      |                "currency_code": "USD"
                      |              }
                      |            },
                      |            "total_discount_set": {
                      |              "shop_money": {
                      |                "amount": "0.00",
                      |                "currency_code": "USD"
                      |              },
                      |              "presentment_money": {
                      |                "amount": "0.00",
                      |                "currency_code": "USD"
                      |              }
                      |            },
                      |            "discount_allocations": [
                      |              {
                      |                "amount": "3.34",
                      |                "discount_application_index": 0,
                      |                "amount_set": {
                      |                  "shop_money": {
                      |                    "amount": "3.34",
                      |                    "currency_code": "USD"
                      |                  },
                      |                  "presentment_money": {
                      |                    "amount": "3.34",
                      |                    "currency_code": "USD"
                      |                  }
                      |                }
                      |              }
                      |            ],
                      |            "admin_graphql_api_id": "gid://shopify/LineItem/466157049",
                      |            "tax_lines": [
                      |              {
                      |                "title": "State Tax",
                      |                "price": "3.98",
                      |                "rate": 0.06,
                      |                "price_set": {
                      |                  "shop_money": {
                      |                    "amount": "3.98",
                      |                    "currency_code": "USD"
                      |                  },
                      |                  "presentment_money": {
                      |                    "amount": "3.98",
                      |                    "currency_code": "USD"
                      |                  }
                      |                }
                      |              }
                      |            ]
                      |          }
                      |        }
                      |      ],
                      |      "transactions": [
                      |        {
                      |          "id": 179259969,
                      |          "order_id": 450789469,
                      |          "kind": "refund",
                      |          "gateway": "bogus",
                      |          "status": "success",
                      |          "message": null,
                      |          "created_at": "2005-08-05T12:59:12-04:00",
                      |          "test": false,
                      |          "authorization": "authorization-key",
                      |          "location_id": null,
                      |          "user_id": null,
                      |          "parent_id": 801038806,
                      |          "processed_at": "2005-08-05T12:59:12-04:00",
                      |          "device_id": null,
                      |          "error_code": null,
                      |          "source_name": "web",
                      |          "receipt": {},
                      |          "amount": "209.00",
                      |          "currency": "USD",
                      |          "admin_graphql_api_id": "gid://shopify/OrderTransaction/179259969"
                      |        }
                      |      ],
                      |      "order_adjustments": []
                      |    }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Refund(
        id = Some(509562969),
        orderId = Some(450789469),
        userId = Some(548380009),
        note = Some("it broke during shipping"),
        currency = None,
        restock = Some(true),
        shipping = None,
        duties = List.empty,
        orderAdjustments = List.empty,
        transactions = List(
          Transaction(
            id = Some(179259969),
            orderId = Some(450789469),
            kind = Some("refund"),
            gateway = Some("bogus"),
            status = Some("success"),
            message = None,
            createdAt = "2005-08-05T12:59:12-04:00",
            test = Some(false),
            authorization = Some("authorization-key"),
            locationId = None,
            userId = None,
            parentId = Some(801038806),
            processedAt = "2005-08-05T12:59:12-04:00",
            sourceName = Some("web"),
            deviceId = None,
            errorCode = None,
            paymentDetails = None,
            currencyExchangeAdjustment = None,
            amount = Some("209.00"),
            paymentsRefundAttributes = None,
            currency = Some("USD"),
            authorizationExpiresAt = None,
            extendedAuthorizationAttributes = None,
            maximumRefundable = None
          )
        ),
        refundDuties = List.empty,
        refundLineItems = List(
          RefundLineItem(
            lineItemId = 703073504,
            quantity = 1,
            restockType = "legacy_restock",
            locationId = Some(487838322)
          ),
          RefundLineItem(
            lineItemId = 466157049,
            quantity = 1,
            restockType = "legacy_restock",
            locationId = Some(487838322)
          )
        ),
        createdAt = "2022-04-05T12:51:55-04:00",
        processedAt = "2022-04-05T12:51:55-04:00"
      )
    )
  )

}
