package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.orders.models.DraftOrder
import com.moyiecomm.shopify.api.shared.models.{AppliedDiscount, LineItem, TaxLine}
import sttp.model.{Method, StatusCode}

class UpdateDraftOrderByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateDraftOrderById(
      DraftOrder(
        id = Some(994118539),
        orderId = None,
        name = None,
        customer = None,
        shippingAddress = None,
        billingAddress = None,
        note = None,
        noteAttributes = List.empty,
        email = None,
        currency = None,
        invoiceUrl = None,
        invoiceSentAt = None,
        lineItems = List(
          LineItem(
            id = None,
            custom = None,
            name = None,
            fulfillmentService = None,
            fulfillmentStatus = None,
            grams = None,
            price = 20.00,
            productId = None,
            quantity = 1,
            requiresShipping = None,
            sku = None,
            title = Some("Custom Tee"),
            variantId = None,
            variantTitle = None,
            vendor = None,
            giftCard = None,
            properties = List.empty,
            appliedDiscount = Some(
              AppliedDiscount(
                title = Some("Custom"),
                description = Some("Custom discount"),
                value = "10.0",
                valueType = "percentage",
                amount = 2
              )
            ),
            taxLines = List.empty,
            taxable = None
          )
        ),
        paymentTerms = None,
        shippingLine = None,
        tags = "",
        taxExempt = None,
        taxExemptions = List.empty,
        taxLines = List.empty,
        appliedDiscount = None,
        taxesIncluded = None,
        totalTax = None,
        subtotalPrice = None,
        totalPrice = None,
        status = None,
        createdAt = None,
        updatedAt = None,
        completedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/draft_orders/994118539.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some(
      """{"draft_order":{"id":994118539,"line_items":[{"title":"Custom Tee","price":"20.0","quantity":1,"applied_discount":{"description":"Custom discount","value_type":"percentage","value":"10.0","amount":"2.0","title":"Custom"}}]}}"""
    ),
    mapping = put("/admin/api/2022-01/draft_orders/994118539.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"draft_order":{"id":994118539,"line_items":[{"title":"Custom Tee","price":"20.0","quantity":1,"applied_discount":{"description":"Custom discount","value_type":"percentage","value":"10.0","amount":"2.0","title":"Custom"}}]}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(202)
          .withBody("""
                      |{
                      |  "draft_order": {
                      |    "id": 994118539,
                      |    "note": null,
                      |    "email": null,
                      |    "taxes_included": false,
                      |    "currency": "USD",
                      |    "invoice_sent_at": null,
                      |    "created_at": "2022-04-05T12:54:25-04:00",
                      |    "updated_at": "2022-04-05T12:54:25-04:00",
                      |    "tax_exempt": false,
                      |    "completed_at": null,
                      |    "name": "#D5",
                      |    "status": "open",
                      |    "line_items": [
                      |      {
                      |        "id": 1066630381,
                      |        "variant_id": null,
                      |        "product_id": null,
                      |        "title": "Custom Tee",
                      |        "variant_title": null,
                      |        "sku": null,
                      |        "vendor": null,
                      |        "quantity": 1,
                      |        "requires_shipping": false,
                      |        "taxable": true,
                      |        "gift_card": false,
                      |        "fulfillment_service": "manual",
                      |        "grams": 0,
                      |        "tax_lines": [
                      |          {
                      |            "rate": 0.05,
                      |            "title": "GST",
                      |            "price": "0.90"
                      |          },
                      |          {
                      |            "rate": 0.08,
                      |            "title": "Tax",
                      |            "price": "1.44"
                      |          }
                      |        ],
                      |        "applied_discount": {
                      |          "description": "Custom discount",
                      |          "value": "10.0",
                      |          "title": "Custom",
                      |          "amount": "2.00",
                      |          "value_type": "percentage"
                      |        },
                      |        "name": "Custom Tee",
                      |        "properties": [],
                      |        "custom": true,
                      |        "price": "20.00",
                      |        "admin_graphql_api_id": "gid://shopify/DraftOrderLineItem/1066630381"
                      |      }
                      |    ],
                      |    "shipping_address": null,
                      |    "billing_address": null,
                      |    "invoice_url": "https://jsmith.myshopify.com/548380009/invoices/4966a710ede5c29555775c4ab82037a1",
                      |    "applied_discount": null,
                      |    "order_id": null,
                      |    "shipping_line": null,
                      |    "tax_lines": [
                      |      {
                      |        "rate": 0.05,
                      |        "title": "GST",
                      |        "price": "0.90"
                      |      },
                      |      {
                      |        "rate": 0.08,
                      |        "title": "Tax",
                      |        "price": "1.44"
                      |      }
                      |    ],
                      |    "tags": "",
                      |    "note_attributes": [],
                      |    "total_price": "20.34",
                      |    "subtotal_price": "18.00",
                      |    "total_tax": "2.34",
                      |    "presentment_currency": "USD",
                      |    "total_line_items_price_set": {
                      |      "shop_money": {
                      |        "amount": "20.00",
                      |        "currency_code": "USD"
                      |      },
                      |      "presentment_money": {
                      |        "amount": "20.00",
                      |        "currency_code": "USD"
                      |      }
                      |    },
                      |    "total_price_set": {
                      |      "shop_money": {
                      |        "amount": "20.34",
                      |        "currency_code": "USD"
                      |      },
                      |      "presentment_money": {
                      |        "amount": "20.34",
                      |        "currency_code": "USD"
                      |      }
                      |    },
                      |    "subtotal_price_set": {
                      |      "shop_money": {
                      |        "amount": "18.00",
                      |        "currency_code": "USD"
                      |      },
                      |      "presentment_money": {
                      |        "amount": "18.00",
                      |        "currency_code": "USD"
                      |      }
                      |    },
                      |    "total_tax_set": {
                      |      "shop_money": {
                      |        "amount": "2.34",
                      |        "currency_code": "USD"
                      |      },
                      |      "presentment_money": {
                      |        "amount": "2.34",
                      |        "currency_code": "USD"
                      |      }
                      |    },
                      |    "total_discounts_set": {
                      |      "shop_money": {
                      |        "amount": "2.00",
                      |        "currency_code": "USD"
                      |      },
                      |      "presentment_money": {
                      |        "amount": "2.00",
                      |        "currency_code": "USD"
                      |      }
                      |    },
                      |    "total_shipping_price_set": {
                      |      "shop_money": {
                      |        "amount": "0.00",
                      |        "currency_code": "USD"
                      |      },
                      |      "presentment_money": {
                      |        "amount": "0.00",
                      |        "currency_code": "USD"
                      |      }
                      |    },
                      |    "payment_terms": null,
                      |    "admin_graphql_api_id": "gid://shopify/DraftOrder/1069920476",
                      |    "customer": null
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Accepted,
    expectedResponseBody = Some(
      DraftOrder(
        id = Some(994118539),
        orderId = None,
        name = Some("#D5"),
        customer = None,
        shippingAddress = None,
        billingAddress = None,
        note = None,
        noteAttributes = List.empty,
        email = None,
        currency = Some("USD"),
        invoiceUrl = Some("https://jsmith.myshopify.com/548380009/invoices/4966a710ede5c29555775c4ab82037a1"),
        invoiceSentAt = None,
        lineItems = List(
          LineItem(
            id = Some(1066630381),
            custom = Some(true),
            name = Some("Custom Tee"),
            fulfillmentService = Some("manual"),
            fulfillmentStatus = None,
            grams = Some(0),
            price = 20.00,
            productId = None,
            quantity = 1,
            requiresShipping = Some(false),
            sku = None,
            title = Some("Custom Tee"),
            variantId = None,
            variantTitle = None,
            vendor = None,
            giftCard = Some(false),
            properties = List.empty,
            appliedDiscount = Some(
              AppliedDiscount(
                title = Some("Custom"),
                description = Some("Custom discount"),
                value = "10.0",
                valueType = "percentage",
                amount = 2.0
              )
            ),
            taxLines = List(
              TaxLine(
                price = 0.90,
                rate = 0.05,
                title = Some("GST"),
                channelLiable = None
              ),
              TaxLine(
                price = 1.44,
                rate = 0.08,
                title = Some("Tax"),
                channelLiable = None
              )
            ),
            taxable = Some(true)
          )
        ),
        paymentTerms = None,
        shippingLine = None,
        tags = "",
        taxExempt = Some(false),
        taxExemptions = List.empty,
        taxLines = List(
          TaxLine(
            price = 0.90,
            rate = 0.05,
            title = Some("GST"),
            channelLiable = None
          ),
          TaxLine(
            price = 1.44,
            rate = 0.08,
            title = Some("Tax"),
            channelLiable = None
          )
        ),
        appliedDiscount = None,
        taxesIncluded = Some(false),
        totalTax = Some(2.34),
        subtotalPrice = Some(18.0),
        totalPrice = Some(20.34),
        status = Some("open"),
        createdAt = "2022-04-05T12:54:25-04:00",
        updatedAt = "2022-04-05T12:54:25-04:00",
        completedAt = None
      )
    )
  )
}
