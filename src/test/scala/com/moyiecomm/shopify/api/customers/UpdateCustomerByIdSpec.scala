package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.Customer.SmsMarketingConsent
import com.moyiecomm.shopify.api.customers.models.{Address, Customer}
import sttp.model.{Method, StatusCode}

class UpdateCustomerByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateCustomerById(
      Customer(
        id = Some(207119551),
        email = "changed@email.address.com",
        firstName = "",
        lastName = "",
        acceptsMarketing = None,
        acceptsMarketingUpdatedAt = None,
        addresses = List.empty,
        currency = None,
        defaultAddress = None,
        lastOrderId = None,
        lastOrderName = None,
        metafield = None,
        marketingOptInLevel = None,
        multipassIdentifier = None,
        note = Some("Customer is a great guy"),
        ordersCount = None,
        phone = None,
        smsMarketingConsent = None,
        state = None,
        tags = None,
        taxExempt = None,
        tax_exemptions = List.empty,
        totalSpent = None,
        verifiedEmail = None,
        createdAt = None,
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customers/207119551.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some(
      """{"customer":{"id":207119551,"email":"changed@email.address.com","note":"Customer is a great guy"}}"""
    ),
    mapping = put("/admin/api/2022-01/customers/207119551.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalTo(
          """{"customer":{"id":207119551,"email":"changed@email.address.com","note":"Customer is a great guy"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "customer": {
                      |    "id": 207119551,
                      |    "email": "changed@email.address.com",
                      |    "accepts_marketing": false,
                      |    "created_at": "2022-04-05T13:04:28-04:00",
                      |    "updated_at": "2022-04-05T13:04:29-04:00",
                      |    "first_name": "Steve",
                      |    "last_name": "Lastnameson",
                      |    "orders_count": 0,
                      |    "state": "disabled",
                      |    "total_spent": "0.00",
                      |    "last_order_id": null,
                      |    "note": "Customer is a great guy",
                      |    "verified_email": true,
                      |    "multipass_identifier": null,
                      |    "tax_exempt": false,
                      |    "phone": "+15142546011",
                      |    "tags": "",
                      |    "last_order_name": null,
                      |    "currency": "USD",
                      |    "addresses": [
                      |      {
                      |        "id": 1053317301,
                      |        "customer_id": 1073339469,
                      |        "first_name": "Mother",
                      |        "last_name": "Lastnameson",
                      |        "company": null,
                      |        "address1": "123 Oak St",
                      |        "address2": null,
                      |        "city": "Ottawa",
                      |        "province": "Ontario",
                      |        "country": "Canada",
                      |        "zip": "123 ABC",
                      |        "phone": "555-1212",
                      |        "name": "Mother Lastnameson",
                      |        "province_code": "ON",
                      |        "country_code": "CA",
                      |        "country_name": "Canada",
                      |        "default": true
                      |      }
                      |    ],
                      |    "accepts_marketing_updated_at": "2022-04-05T13:04:29-04:00",
                      |    "marketing_opt_in_level": null,
                      |    "tax_exemptions": [],
                      |    "sms_marketing_consent": {
                      |      "state": "not_subscribed",
                      |      "opt_in_level": "single_opt_in",
                      |      "consent_updated_at": null,
                      |      "consent_collected_from": "OTHER"
                      |    },
                      |    "admin_graphql_api_id": "gid://shopify/Customer/1073339469",
                      |    "default_address": {
                      |      "id": 1053317301,
                      |      "customer_id": 1073339469,
                      |      "first_name": "Mother",
                      |      "last_name": "Lastnameson",
                      |      "company": null,
                      |      "address1": "123 Oak St",
                      |      "address2": null,
                      |      "city": "Ottawa",
                      |      "province": "Ontario",
                      |      "country": "Canada",
                      |      "zip": "123 ABC",
                      |      "phone": "555-1212",
                      |      "name": "Mother Lastnameson",
                      |      "province_code": "ON",
                      |      "country_code": "CA",
                      |      "country_name": "Canada",
                      |      "default": true
                      |    }
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Customer(
        id = Some(207119551),
        email = "changed@email.address.com",
        firstName = "Steve",
        lastName = "Lastnameson",
        acceptsMarketing = Some(false),
        acceptsMarketingUpdatedAt = "2022-04-05T13:04:29-04:00",
        addresses = List(
          Address(
            id = Some(1053317301),
            customerId = Some(1073339469),
            address1 = "123 Oak St",
            address2 = None,
            city = "Ottawa",
            country = "Canada",
            countryCode = Some("CA"),
            countryName = Some("Canada"),
            company = None,
            firstName = Some("Mother"),
            lastName = Some("Lastnameson"),
            latitude = None,
            longitude = None,
            name = Some("Mother Lastnameson"),
            phone = "555-1212",
            province = "Ontario",
            provinceCode = Some("ON"),
            zip = "123 ABC",
            default = Some(true)
          )
        ),
        currency = Some("USD"),
        defaultAddress = Some(
          Address(
            id = Some(1053317301),
            customerId = Some(1073339469),
            address1 = "123 Oak St",
            address2 = None,
            city = "Ottawa",
            country = "Canada",
            countryCode = Some("CA"),
            countryName = Some("Canada"),
            company = None,
            firstName = Some("Mother"),
            lastName = Some("Lastnameson"),
            latitude = None,
            longitude = None,
            name = Some("Mother Lastnameson"),
            phone = "555-1212",
            province = "Ontario",
            provinceCode = Some("ON"),
            zip = "123 ABC",
            default = Some(true)
          )
        ),
        lastOrderId = None,
        lastOrderName = None,
        metafield = None,
        marketingOptInLevel = None,
        multipassIdentifier = None,
        note = Some("Customer is a great guy"),
        ordersCount = Some(0),
        phone = Some("+15142546011"),
        smsMarketingConsent = Some(
          SmsMarketingConsent(
            state = "not_subscribed",
            optInLevel = "single_opt_in",
            consentUpdatedAt = None,
            consentCollectedFrom = "OTHER"
          )
        ),
        state = Some("disabled"),
        tags = Some(""),
        taxExempt = Some(false),
        tax_exemptions = List.empty,
        totalSpent = Some(0.00),
        verifiedEmail = Some(true),
        createdAt = "2022-04-05T13:04:28-04:00",
        updatedAt = "2022-04-05T13:04:29-04:00"
      )
    )
  )
}
