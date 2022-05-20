package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.{Address, Customer}
import com.moyiecomm.shopify.api.orders.models.DraftOrder
import com.moyiecomm.shopify.api.shared.models.LineItem
import sttp.model.{Method, StatusCode}

class GetDraftOrderListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetDraftOrderList(
      limit = Some(1),
      sinceId = None,
      status = None,
      updatedAtMax = None,
      updatedAtMin = None
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/draft_orders.json?limit=1",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/draft_orders.json?limit=1")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody(
            """
              |{
              |  "draft_orders": [
              |    {
              |      "id": 72885271,
              |      "note": "rush order",
              |      "email": "bob.norman@mail.example.com",
              |      "taxes_included": true,
              |      "currency": "USD",
              |      "invoice_sent_at": null,
              |      "created_at": "2022-04-05T12:51:55-04:00",
              |      "updated_at": "2022-04-05T12:51:55-04:00",
              |      "tax_exempt": false,
              |      "completed_at": null,
              |      "name": "#D4",
              |      "status": "completed",
              |      "line_items": [
              |        {
              |          "id": 498266019,
              |          "variant_id": 39072856,
              |          "product_id": 632910392,
              |          "title": "IPod Nano - 8gb",
              |          "variant_title": "green",
              |          "sku": "IPOD2008GREEN",
              |          "vendor": null,
              |          "quantity": 2,
              |          "requires_shipping": true,
              |          "taxable": true,
              |          "gift_card": false,
              |          "fulfillment_service": "manual",
              |          "grams": 567,
              |          "tax_lines": [],
              |          "applied_discount": null,
              |          "name": "IPod Nano - 8gb - green",
              |          "properties": [],
              |          "custom": false,
              |          "price": "199.00",
              |          "admin_graphql_api_id": "gid://shopify/DraftOrderLineItem/498266019"
              |        }
              |      ],
              |      "shipping_address": {
              |        "first_name": "Bob",
              |        "address1": "Chestnut Street 92",
              |        "phone": "555-625-1199",
              |        "city": "Louisville",
              |        "zip": "40202",
              |        "province": "Kentucky",
              |        "country": "United States",
              |        "last_name": "Norman",
              |        "address2": "",
              |        "company": null,
              |        "latitude": 45.41634,
              |        "longitude": -75.6868,
              |        "name": "Bob Norman",
              |        "country_code": "US",
              |        "province_code": "KY"
              |      },
              |      "billing_address": {
              |        "first_name": "Bob",
              |        "address1": "Chestnut Street 92",
              |        "phone": "555-625-1199",
              |        "city": "Louisville",
              |        "zip": "40202",
              |        "province": "Kentucky",
              |        "country": "United States",
              |        "last_name": "Norman",
              |        "address2": "",
              |        "company": null,
              |        "latitude": 45.41634,
              |        "longitude": -75.6868,
              |        "name": "Bob Norman",
              |        "country_code": "US",
              |        "province_code": "KY"
              |      },
              |      "invoice_url": "https://jsmith.myshopify.com/548380009/invoices/f945c7e2b158dbb69fa642cb8d79171f",
              |      "applied_discount": null,
              |      "order_id": 450789469,
              |      "shipping_line": null,
              |      "tax_lines": [],
              |      "tags": "",
              |      "note_attributes": [],
              |      "total_price": "409.94",
              |      "subtotal_price": "398.00",
              |      "total_tax": "11.94",
              |      "admin_graphql_api_id": "gid://shopify/DraftOrder/72885271",
              |      "customer": {
              |        "id": 207119551,
              |        "email": "bob.norman@mail.example.com",
              |        "accepts_marketing": false,
              |        "created_at": "2022-04-05T12:51:55-04:00",
              |        "updated_at": "2022-04-05T12:51:55-04:00",
              |        "first_name": "Bob",
              |        "last_name": "Norman",
              |        "orders_count": 1,
              |        "state": "disabled",
              |        "total_spent": "199.65",
              |        "last_order_id": 450789469,
              |        "note": null,
              |        "verified_email": true,
              |        "multipass_identifier": null,
              |        "tax_exempt": false,
              |        "phone": "+16136120707",
              |        "tags": "",
              |        "last_order_name": "#1001",
              |        "currency": "USD",
              |        "accepts_marketing_updated_at": "2005-06-12T11:57:11-04:00",
              |        "marketing_opt_in_level": null,
              |        "tax_exemptions": [],
              |        "admin_graphql_api_id": "gid://shopify/Customer/207119551",
              |        "default_address": {
              |          "id": 207119551,
              |          "customer_id": 207119551,
              |          "first_name": null,
              |          "last_name": null,
              |          "company": null,
              |          "address1": "Chestnut Street 92",
              |          "address2": "",
              |          "city": "Louisville",
              |          "province": "Kentucky",
              |          "country": "United States",
              |          "zip": "40202",
              |          "phone": "555-625-1199",
              |          "name": "",
              |          "province_code": "KY",
              |          "country_code": "US",
              |          "country_name": "United States",
              |          "default": true
              |        }
              |      }
              |    }
              |  ]
              |}
              |""".stripMargin
          )
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        DraftOrder(
          id = Some(72885271),
          orderId = Some(450789469),
          name = Some("#D4"),
          customer = Some(
            Customer(
              id = Some(207119551),
              firstName = "Bob",
              lastName = "Norman",
              email = "bob.norman@mail.example.com",
              phone = Some("+16136120707"),
              verifiedEmail = Some(true),
              acceptsMarketing = Some(false),
              acceptsMarketingUpdatedAt = "2005-06-12T11:57:11-04:00",
              addresses = List.empty,
              currency = Some("USD"),
              defaultAddress = Some(
                Address(
                  id = Some(207119551),
                  customerId = Some(207119551),
                  address1 = "Chestnut Street 92",
                  address2 = Some(""),
                  city = "Louisville",
                  province = "Kentucky",
                  phone = "555-625-1199",
                  zip = "40202",
                  company = None,
                  lastName = None,
                  firstName = None,
                  country = "United States",
                  name = Some(""),
                  provinceCode = Some("KY"),
                  countryCode = Some("US"),
                  countryName = Some("United States"),
                  latitude = None,
                  longitude = None,
                  default = Some(true)
                )
              ),
              lastOrderId = Some(450789469),
              lastOrderName = Some("#1001"),
              metafield = None,
              marketingOptInLevel = None,
              multipassIdentifier = None,
              note = None,
              ordersCount = Some(1),
              smsMarketingConsent = None,
              emailMarketingConsent = None,
              smsTransactionalConsent = None,
              state = Some("disabled"),
              tags = Some(""),
              taxExempt = Some(false),
              tax_exemptions = List.empty,
              totalSpent = Some(199.65),
              createdAt = "2022-04-05T12:51:55-04:00",
              updatedAt = "2022-04-05T12:51:55-04:00"
            )
          ),
          shippingAddress = Some(
            Address(
              id = None,
              customerId = None,
              address1 = "Chestnut Street 92",
              address2 = Some(""),
              city = "Louisville",
              province = "Kentucky",
              phone = "555-625-1199",
              zip = "40202",
              company = None,
              lastName = Some("Norman"),
              firstName = Some("Bob"),
              country = "United States",
              name = Some("Bob Norman"),
              provinceCode = Some("KY"),
              countryCode = Some("US"),
              countryName = None,
              latitude = Some(45.41634),
              longitude = Some(-75.6868),
              default = None
            )
          ),
          billingAddress = Some(
            Address(
              id = None,
              customerId = None,
              address1 = "Chestnut Street 92",
              address2 = Some(""),
              city = "Louisville",
              province = "Kentucky",
              phone = "555-625-1199",
              zip = "40202",
              company = None,
              lastName = Some("Norman"),
              firstName = Some("Bob"),
              country = "United States",
              name = Some("Bob Norman"),
              provinceCode = Some("KY"),
              countryCode = Some("US"),
              countryName = None,
              latitude = Some(45.41634),
              longitude = Some(-75.6868),
              default = None
            )
          ),
          note = Some("rush order"),
          noteAttributes = List.empty,
          email = Some("bob.norman@mail.example.com"),
          currency = Some("USD"),
          invoiceUrl = Some("https://jsmith.myshopify.com/548380009/invoices/f945c7e2b158dbb69fa642cb8d79171f"),
          invoiceSentAt = None,
          lineItems = List(
            LineItem(
              id = Some(498266019),
              custom = Some(false),
              name = Some("IPod Nano - 8gb - green"),
              fulfillmentService = Some("manual"),
              fulfillmentStatus = None,
              grams = Some(567),
              price = 199.00,
              productId = Some(632910392),
              quantity = 2,
              requiresShipping = Some(true),
              sku = Some("IPOD2008GREEN"),
              title = Some("IPod Nano - 8gb"),
              variantId = Some(39072856),
              variantTitle = Some("green"),
              vendor = None,
              giftCard = Some(false),
              properties = List.empty,
              appliedDiscount = None,
              taxLines = List.empty,
              taxable = Some(true)
            )
          ),
          paymentTerms = None,
          shippingLine = None,
          tags = "",
          taxExempt = Some(false),
          taxExemptions = List.empty,
          taxLines = List.empty,
          appliedDiscount = None,
          taxesIncluded = Some(true),
          totalTax = Some(11.94),
          subtotalPrice = Some(398.00),
          totalPrice = Some(409.94),
          status = Some("completed"),
          createdAt = "2022-04-05T12:51:55-04:00",
          updatedAt = "2022-04-05T12:51:55-04:00",
          completedAt = None
        )
      )
    )
  )

}
