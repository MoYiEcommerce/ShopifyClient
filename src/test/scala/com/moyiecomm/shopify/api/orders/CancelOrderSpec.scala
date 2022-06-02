package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.orders.models.Order
import com.moyiecomm.shopify.api.shared.models.{AmountSet, LineItem, Price}
import sttp.model.{Method, StatusCode}

class CancelOrderSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CancelOrder(450789469),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/orders/450789469/cancel.json",
    expectedMethod = Method.POST,
    expectedRequestBody = None,
    mapping = post("/admin/api/2022-01/orders/450789469/cancel.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody(
            """
              |{
              |  "order": {
              |    "id": 1073459966,
              |    "admin_graphql_api_id": "gid://shopify/Order/1073459966",
              |    "app_id": 755357713,
              |    "browser_ip": null,
              |    "buyer_accepts_marketing": false,
              |    "cancel_reason": null,
              |    "cancelled_at": null,
              |    "cart_token": null,
              |    "checkout_id": null,
              |    "checkout_token": null,
              |    "client_details": null,
              |    "closed_at": null,
              |    "confirmed": true,
              |    "contact_email": null,
              |    "created_at": "2022-04-05T13:15:18-04:00",
              |    "currency": "USD",
              |    "current_subtotal_price": "199.00",
              |    "current_subtotal_price_set": {
              |      "shop_money": {
              |        "amount": "199.00",
              |        "currency_code": "USD"
              |      },
              |      "presentment_money": {
              |        "amount": "199.00",
              |        "currency_code": "USD"
              |      }
              |    },
              |    "current_total_discounts": "0.00",
              |    "current_total_discounts_set": {
              |      "shop_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      },
              |      "presentment_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      }
              |    },
              |    "current_total_duties_set": null,
              |    "current_total_price": "199.00",
              |    "current_total_price_set": {
              |      "shop_money": {
              |        "amount": "199.00",
              |        "currency_code": "USD"
              |      },
              |      "presentment_money": {
              |        "amount": "199.00",
              |        "currency_code": "USD"
              |      }
              |    },
              |    "current_total_tax": "0.00",
              |    "current_total_tax_set": {
              |      "shop_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      },
              |      "presentment_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      }
              |    },
              |    "customer_locale": null,
              |    "device_id": null,
              |    "discount_codes": [],
              |    "email": "",
              |    "estimated_taxes": false,
              |    "financial_status": "paid",
              |    "fulfillment_status": null,
              |    "gateway": "",
              |    "landing_site": null,
              |    "landing_site_ref": null,
              |    "location_id": null,
              |    "name": "#1002",
              |    "note": null,
              |    "note_attributes": [],
              |    "number": 2,
              |    "order_number": 1002,
              |    "order_status_url": "https://jsmith.myshopify.com/548380009/orders/f333f8f057ab3708f79cf04ab1c108cb/authenticate?key=f86449591c04f9d6c7005d70c628195f",
              |    "original_total_duties_set": null,
              |    "payment_gateway_names": [],
              |    "phone": null,
              |    "presentment_currency": "USD",
              |    "processed_at": "2022-04-05T13:15:18-04:00",
              |    "processing_method": "",
              |    "reference": null,
              |    "referring_site": null,
              |    "source_identifier": null,
              |    "source_name": "755357713",
              |    "source_url": null,
              |    "subtotal_price": "199.00",
              |    "subtotal_price_set": {
              |      "shop_money": {
              |        "amount": "199.00",
              |        "currency_code": "USD"
              |      },
              |      "presentment_money": {
              |        "amount": "199.00",
              |        "currency_code": "USD"
              |      }
              |    },
              |    "tags": "",
              |    "tax_lines": [],
              |    "taxes_included": false,
              |    "test": false,
              |    "token": "f333f8f057ab3708f79cf04ab1c108cb",
              |    "total_discounts": "0.00",
              |    "total_discounts_set": {
              |      "shop_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      },
              |      "presentment_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      }
              |    },
              |    "total_line_items_price": "199.00",
              |    "total_line_items_price_set": {
              |      "shop_money": {
              |        "amount": "199.00",
              |        "currency_code": "USD"
              |      },
              |      "presentment_money": {
              |        "amount": "199.00",
              |        "currency_code": "USD"
              |      }
              |    },
              |    "total_outstanding": "199.00",
              |    "total_price": "199.00",
              |    "total_price_set": {
              |      "shop_money": {
              |        "amount": "199.00",
              |        "currency_code": "USD"
              |      },
              |      "presentment_money": {
              |        "amount": "199.00",
              |        "currency_code": "USD"
              |      }
              |    },
              |    "total_price_usd": "199.00",
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
              |    "total_tax": "0.00",
              |    "total_tax_set": {
              |      "shop_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      },
              |      "presentment_money": {
              |        "amount": "0.00",
              |        "currency_code": "USD"
              |      }
              |    },
              |    "total_tip_received": "0.00",
              |    "total_weight": 0,
              |    "updated_at": "2022-04-05T13:15:18-04:00",
              |    "user_id": null,
              |    "billing_address": null,
              |    "customer": null,
              |    "discount_applications": [],
              |    "fulfillments": [],
              |    "line_items": [
              |      {
              |        "id": 1071823188,
              |        "admin_graphql_api_id": "gid://shopify/LineItem/1071823188",
              |        "fulfillable_quantity": 1,
              |        "fulfillment_service": "shipwire-app",
              |        "fulfillment_status": null,
              |        "gift_card": false,
              |        "grams": 567,
              |        "name": "IPod Touch 8GB - Black",
              |        "price": "199.00",
              |        "price_set": {
              |          "shop_money": {
              |            "amount": "199.00",
              |            "currency_code": "USD"
              |          },
              |          "presentment_money": {
              |            "amount": "199.00",
              |            "currency_code": "USD"
              |          }
              |        },
              |        "product_exists": true,
              |        "product_id": 921728736,
              |        "properties": [],
              |        "quantity": 1,
              |        "requires_shipping": true,
              |        "sku": "IPOD2009BLACK",
              |        "taxable": true,
              |        "title": "IPod Touch 8GB",
              |        "total_discount": "0.00",
              |        "total_discount_set": {
              |          "shop_money": {
              |            "amount": "0.00",
              |            "currency_code": "USD"
              |          },
              |          "presentment_money": {
              |            "amount": "0.00",
              |            "currency_code": "USD"
              |          }
              |        },
              |        "variant_id": 447654529,
              |        "variant_inventory_management": "shipwire-app",
              |        "variant_title": "Black",
              |        "vendor": "Apple",
              |        "tax_lines": [],
              |        "duties": [],
              |        "discount_allocations": []
              |      }
              |    ],
              |    "payment_details": null,
              |    "refunds": [],
              |    "shipping_address": null,
              |    "shipping_lines": []
              |  }
              |}
              |""".stripMargin
          )
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Order(
        id = Some(1073459966),
        appId = Some(755357713),
        browserIp = None,
        buyerAcceptsMarketing = Some(false),
        cancelReason = None,
        cancelledAt = None,
        cartToken = None,
        clientDetails = None,
        closedAt = None,
        createdAt = "2022-04-05T13:15:18-04:00",
        currency = Some("USD"),
        currentSubtotalPrice = Some("199.00"),
        currentSubtotalPriceSet = Some(
          AmountSet(
            Price("199.00", "USD"),
            Price("199.00", "USD")
          )
        ),
        currentTotalDiscounts = Some("0.00"),
        currentTotalDiscountsSet = Some(
          AmountSet(
            Price("0.00", "USD"),
            Price("0.00", "USD")
          )
        ),
        currentTotalDutiesSet = None,
        currentTotalPrice = Some("199.00"),
        currentTotalPriceSet = Some(
          AmountSet(
            Price("199.00", "USD"),
            Price("199.00", "USD")
          )
        ),
        currentTotalTax = Some("0.00"),
        currentTotalTaxSet = Some(
          AmountSet(
            Price("0.00", "USD"),
            Price("0.00", "USD")
          )
        ),
        customerLocale = None,
        discountCodes = List.empty,
        email = Some(""),
        estimatedTaxes = Some(false),
        financialStatus = Some("paid"),
        fulfillmentStatus = None,
        landingSite = None,
        locationId = None,
        name = Some("#1002"),
        note = None,
        noteAttributes = List.empty,
        number = Some(2),
        orderNumber = Some(1002),
        orderStatusUrl = Some(
          "https://jsmith.myshopify.com/548380009/orders/f333f8f057ab3708f79cf04ab1c108cb/authenticate?key=f86449591c04f9d6c7005d70c628195f"
        ),
        originalTotalDutiesSet = None,
        phone = None,
        presentmentCurrency = Some("USD"),
        processedAt = "2022-04-05T13:15:18-04:00",
        processingMethod = Some(""),
        referringSite = None,
        sourceName = Some("755357713"),
        subtotalPrice = Some("199.00"),
        subtotalPriceSet = Some(
          AmountSet(
            Price("199.00", "USD"),
            Price("199.00", "USD")
          )
        ),
        tags = Some(""),
        taxLines = List.empty,
        taxesIncluded = Some(false),
        test = Some(false),
        token = Some("f333f8f057ab3708f79cf04ab1c108cb"),
        totalDiscounts = Some("0.00"),
        totalDiscountsSet = Some(
          AmountSet(
            Price("0.00", "USD"),
            Price("0.00", "USD")
          )
        ),
        totalLineItemsPrice = Some("199.00"),
        totalLineItemsPriceSet = Some(
          AmountSet(
            Price("199.00", "USD"),
            Price("199.00", "USD")
          )
        ),
        totalPrice = Some("199.00"),
        totalPriceSet = Some(
          AmountSet(
            Price("199.00", "USD"),
            Price("199.00", "USD")
          )
        ),
        totalShippingPriceSet = Some(
          AmountSet(
            Price("0.00", "USD"),
            Price("0.00", "USD")
          )
        ),
        totalTax = Some("0.00"),
        totalTaxSet = Some(
          AmountSet(
            Price("0.00", "USD"),
            Price("0.00", "USD")
          )
        ),
        totalTipReceived = Some("0.00"),
        totalWeight = Some(0),
        updatedAt = "2022-04-05T13:15:18-04:00",
        userId = None,
        billingAddress = None,
        customer = None,
        discountApplications = List.empty,
        fulfillments = List.empty,
        lineItems = List(
          LineItem(
            id = Some(1071823188),
            custom = None,
            name = Some("IPod Touch 8GB - Black"),
            fulfillmentService = Some("shipwire-app"),
            fulfillmentStatus = None,
            grams = Some(567),
            price = 199.00,
            productId = Some(921728736),
            quantity = 1,
            requiresShipping = Some(true),
            sku = Some("IPOD2009BLACK"),
            title = Some("IPod Touch 8GB"),
            variantId = Some(447654529),
            variantTitle = Some("Black"),
            vendor = Some("Apple"),
            giftCard = Some(false),
            properties = List.empty,
            appliedDiscount = None,
            taxLines = List.empty,
            taxable = Some(true)
          )
        ),
        paymentDetails = None,
        refunds = List.empty,
        shippingAddress = None,
        shippingLines = List.empty,
        paymentTerms = None
      )
    )
  )

}
