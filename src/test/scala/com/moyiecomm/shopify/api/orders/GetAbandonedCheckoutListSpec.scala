package com.moyiecomm.shopify.api.orders

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, get}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.{Address, Customer}
import com.moyiecomm.shopify.api.discounts.models.DiscountCode
import com.moyiecomm.shopify.api.orders.models.AbandonedCheckout
import com.moyiecomm.shopify.api.shared.models.{AppliedDiscount, LineItem, MarketingConsent, NoteAttribute, ShippingLine, TaxLine}
import sttp.model.{Method, StatusCode}

import java.time.ZonedDateTime

class GetAbandonedCheckoutListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetAbandonedCheckoutList(
      createdAtMax = None,
      createdAtMin = None,
      limit = Some(1),
      sinceId = None,
      status = None,
      updatedAtMax = None,
      updatedAtMin = Some(ZonedDateTime.parse("2012-10-12T07:05:27-04:00"))
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/checkouts.json?updated_at_min=2012-10-12T07:05:27-04:00&limit=1",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/checkouts.json?updated_at_min=2012-10-12T07:05:27-04:00&limit=1")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "checkouts": [
                      |    {
                      |      "id": 450789469,
                      |      "token": "2a1ace52255252df566af0faaedfbfa7",
                      |      "cart_token": "68778783ad298f1c80c3bafcddeea02f",
                      |      "email": "bob.norman@mail.example.com",
                      |      "gateway": null,
                      |      "buyer_accepts_marketing": false,
                      |      "created_at": "2012-10-12T07:05:27-04:00",
                      |      "updated_at": "2012-10-12T07:05:27-04:00",
                      |      "landing_site": null,
                      |      "note": null,
                      |      "note_attributes": [
                      |        {
                      |          "name": "custom engraving",
                      |          "value": "Happy Birthday"
                      |        },
                      |        {
                      |          "name": "colour",
                      |          "value": "green"
                      |        }
                      |      ],
                      |      "referring_site": null,
                      |      "shipping_lines": [
                      |        {
                      |          "title": "Free Shipping",
                      |          "price": "0.00",
                      |          "code": "Free Shipping",
                      |          "source": "shopify",
                      |          "applied_discounts": [],
                      |          "id": "5da41c1738454765"
                      |        }
                      |      ],
                      |      "taxes_included": false,
                      |      "total_weight": 400,
                      |      "currency": "USD",
                      |      "completed_at": null,
                      |      "closed_at": null,
                      |      "user_id": null,
                      |      "location_id": null,
                      |      "source_identifier": null,
                      |      "source_url": null,
                      |      "device_id": null,
                      |      "phone": null,
                      |      "customer_locale": "en",
                      |      "line_items": [
                      |        {
                      |          "applied_discounts": [],
                      |          "discount_allocations": [
                      |            {
                      |              "id": null,
                      |              "amount": "19.90",
                      |              "description": null,
                      |              "created_at": null,
                      |              "application_type": "discount_code"
                      |            }
                      |          ],
                      |          "key": "e920516d41fa8614",
                      |          "destination_location_id": null,
                      |          "fulfillment_service": "manual",
                      |          "gift_card": false,
                      |          "grams": 200,
                      |          "origin_location_id": null,
                      |          "presentment_title": "IPod Nano - 8GB",
                      |          "presentment_variant_title": "Red",
                      |          "product_id": 632910392,
                      |          "properties": null,
                      |          "quantity": 1,
                      |          "requires_shipping": true,
                      |          "sku": "IPOD2008RED",
                      |          "tax_lines": [],
                      |          "taxable": true,
                      |          "title": "IPod Nano - 8GB",
                      |          "variant_id": 49148385,
                      |          "variant_title": "Red",
                      |          "variant_price": null,
                      |          "vendor": "Apple",
                      |          "user_id": null,
                      |          "unit_price_measurement": null,
                      |          "rank": null,
                      |          "compare_at_price": null,
                      |          "line_price": "199.00",
                      |          "price": "199.00"
                      |        },
                      |        {
                      |          "applied_discounts": [],
                      |          "discount_allocations": [
                      |            {
                      |              "id": null,
                      |              "amount": "19.90",
                      |              "description": null,
                      |              "created_at": null,
                      |              "application_type": "discount_code"
                      |            }
                      |          ],
                      |          "key": "ac94485920309f62",
                      |          "destination_location_id": null,
                      |          "fulfillment_service": "manual",
                      |          "gift_card": false,
                      |          "grams": 200,
                      |          "origin_location_id": null,
                      |          "presentment_title": "IPod Nano - 8GB",
                      |          "presentment_variant_title": "Pink",
                      |          "product_id": 632910392,
                      |          "properties": null,
                      |          "quantity": 1,
                      |          "requires_shipping": true,
                      |          "sku": "IPOD2008PINK",
                      |          "tax_lines": [],
                      |          "taxable": true,
                      |          "title": "IPod Nano - 8GB",
                      |          "variant_id": 808950810,
                      |          "variant_title": "Pink",
                      |          "variant_price": null,
                      |          "vendor": "Apple",
                      |          "user_id": null,
                      |          "unit_price_measurement": null,
                      |          "rank": null,
                      |          "compare_at_price": null,
                      |          "line_price": "199.00",
                      |          "price": "199.00"
                      |        }
                      |      ],
                      |      "name": "#450789469",
                      |      "source": null,
                      |      "abandoned_checkout_url": "https://checkout.local/548380009/checkouts/2a1ace52255252df566af0faaedfbfa7/recover",
                      |      "discount_codes": [
                      |        {
                      |          "code": "TENOFF",
                      |          "amount": "39.80",
                      |          "type": "percentage"
                      |        }
                      |      ],
                      |      "tax_lines": [
                      |        {
                      |          "price": "21.49",
                      |          "rate": 0.06,
                      |          "title": "State Tax",
                      |          "channel_liable": null
                      |        }
                      |      ],
                      |      "source_name": "web",
                      |      "presentment_currency": "USD",
                      |      "buyer_accepts_sms_marketing": false,
                      |      "sms_marketing_phone": null,
                      |      "total_discounts": "39.80",
                      |      "total_line_items_price": "398.00",
                      |      "total_price": "379.69",
                      |      "total_tax": "21.49",
                      |      "subtotal_price": "358.20",
                      |      "total_duties": null,
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
                      |        "addresses": [],
                      |        "tags": "",
                      |        "last_order_name": "#1001",
                      |        "currency": "USD",
                      |        "accepts_marketing_updated_at": "2005-06-12T11:57:11-04:00",
                      |        "marketing_opt_in_level": null,
                      |        "tax_exemptions": [],
                      |        "email_marketing_consent": {
                      |          "state": "not_subscribed",
                      |          "opt_in_level": null,
                      |          "consent_updated_at": "2004-06-13T11:57:11-04:00"
                      |        },
                      |        "sms_marketing_consent": null,
                      |        "sms_transactional_consent": null,
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
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        AbandonedCheckout(
          id = 450789469,
          userId = None,
          abandonedCheckoutUrl = "https://checkout.local/548380009/checkouts/2a1ace52255252df566af0faaedfbfa7/recover",
          token = "2a1ace52255252df566af0faaedfbfa7",
          cartToken = "68778783ad298f1c80c3bafcddeea02f",
          email = "bob.norman@mail.example.com",
          gateway = None,
          billingAddress = Address(
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
          ),
          buyerAcceptsMarketing = Some(false),
          createdAt = "2012-10-12T07:05:27-04:00",
          updatedAt = "2012-10-12T07:05:27-04:00",
          landingSite = None,
          note = None,
          noteAttributes = List(
            NoteAttribute(
              name = "custom engraving",
              value = "Happy Birthday"
            ),
            NoteAttribute(
              name = "colour",
              value = "green"
            )
          ),
          buyerAcceptSmsMarketing = None,
          closedAt = None,
          completedAt = None,
          currency = Some("USD"),
          customer = Customer(
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
            emailMarketingConsent = Some(
              MarketingConsent(
                state = "not_subscribed",
                optInLevel = None,
                consentUpdatedAt = "2004-06-13T11:57:11-04:00",
                consentCollectedFrom = None
              )
            ),
            smsTransactionalConsent = None,
            state = Some("disabled"),
            tags = Some(""),
            taxExempt = Some(false),
            tax_exemptions = List.empty,
            totalSpent = Some(199.65),
            createdAt = "2022-04-05T12:51:55-04:00",
            updatedAt = "2022-04-05T12:51:55-04:00"
          ),
          customerLocale = Some("en"),
          deviceId = None,
          discountCodes = List(
            DiscountCode(
              id = None,
              code = "TENOFF",
              amount = Some(39.80),
              `type` = Some("percentage"),
              usageCount = None,
              priceRuleId = None,
              createdAt = None,
              updatedAt = None
            )
          ),
          lineItems = List(
            LineItem(
              id = None,
              custom = None,
              name = None,
              fulfillmentService = Some("manual"),
              fulfillmentStatus = None,
              grams = Some(200),
              price = 199.00,
              productId = Some(632910392),
              quantity = 1,
              requiresShipping = Some(true),
              sku = Some("IPOD2008RED"),
              title = Some("IPod Nano - 8GB"),
              variantId = Some(49148385),
              variantTitle = Some("Red"),
              vendor = Some("Apple"),
              giftCard = Some(false),
              properties = Map.empty,
              appliedDiscount = None,
              taxLines = List.empty,
              taxable = Some(true)
            ),
            LineItem(
              id = None,
              custom = None,
              name = None,
              fulfillmentService = Some("manual"),
              fulfillmentStatus = None,
              grams = Some(200),
              price = 199.00,
              productId = Some(632910392),
              quantity = 1,
              requiresShipping = Some(true),
              sku = Some("IPOD2008PINK"),
              title = Some("IPod Nano - 8GB"),
              variantId = Some(808950810),
              variantTitle = Some("Pink"),
              vendor = Some("Apple"),
              giftCard = Some(false),
              properties = Map.empty,
              appliedDiscount = None,
              taxLines = List.empty,
              taxable = Some(true)
            )
          ),
          locationId = None,
          phone = None,
          presentmentCurrency = "USD",
          referringSite = None,
          shippingAddress = Address(
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
          ),
          smsMarketingPhone = None,
          shippingLines = List(
            ShippingLine(
              code = "Free Shipping",
              price = 0.00,
              source = "shopify",
              title = Some("Free Shipping")
            )
          ),
          sourceName = "web",
          subtotalPrice = 358.20,
          taxLines = List(
            TaxLine(
              price = 21.49,
              rate = 0.06,
              title = Some("State Tax"),
              channelLiable = None
            )
          ),
          taxesIncluded = Some(false),
          totalDiscounts = Some(39.80),
          totalDuties = None,
          totalLineItemsPrice = Some(398.00),
          totalPrice = Some(379.69),
          totalTax = Some(21.49),
          totalWeight = Some(400)
        )
      )
    )
  )
}
