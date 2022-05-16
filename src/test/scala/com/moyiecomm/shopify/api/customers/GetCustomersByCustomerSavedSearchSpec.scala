package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.Customer.SmsMarketingConsent
import com.moyiecomm.shopify.api.customers.models.{Address, Customer}
import sttp.model.{Method, StatusCode}

class GetCustomersByCustomerSavedSearchSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetCustomersByCustomerSavedSearch(789629109),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customer_saved_searches/789629109/customers.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/customer_saved_searches/789629109/customers.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "customers": [
                      |    {
                      |      "id": 207119551,
                      |      "email": "bob.norman@hostmail.com",
                      |      "accepts_marketing": true,
                      |      "created_at": "2022-03-11T10:52:46-05:00",
                      |      "updated_at": "2022-03-11T10:53:46-05:00",
                      |      "first_name": "Bob",
                      |      "last_name": "Norman",
                      |      "orders_count": 1,
                      |      "state": "disabled",
                      |      "total_spent": "199.65",
                      |      "last_order_id": 450789469,
                      |      "note": null,
                      |      "verified_email": true,
                      |      "multipass_identifier": null,
                      |      "tax_exempt": false,
                      |      "phone": "+16136120707",
                      |      "tags": "",
                      |      "last_order_name": "#1001",
                      |      "currency": "USD",
                      |      "addresses": [
                      |        {
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
                      |      ],
                      |      "accepts_marketing_updated_at": "2022-03-11T10:53:46-05:00",
                      |      "marketing_opt_in_level": "single_opt_in",
                      |      "tax_exemptions": [],
                      |      "sms_marketing_consent": {
                      |        "state": "not_subscribed",
                      |        "opt_in_level": "single_opt_in",
                      |        "consent_updated_at": null,
                      |        "consent_collected_from": "OTHER"
                      |      },
                      |      "admin_graphql_api_id": "gid://shopify/Customer/207119551",
                      |      "default_address": {
                      |        "id": 207119551,
                      |        "customer_id": 207119551,
                      |        "first_name": null,
                      |        "last_name": null,
                      |        "company": null,
                      |        "address1": "Chestnut Street 92",
                      |        "address2": "",
                      |        "city": "Louisville",
                      |        "province": "Kentucky",
                      |        "country": "United States",
                      |        "zip": "40202",
                      |        "phone": "555-625-1199",
                      |        "name": "",
                      |        "province_code": "KY",
                      |        "country_code": "US",
                      |        "country_name": "United States",
                      |        "default": true
                      |      }
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        Customer(
          id = Some(207119551),
          email = "bob.norman@hostmail.com",
          firstName = "Bob",
          lastName = "Norman",
          acceptsMarketing = Some(true),
          acceptsMarketingUpdatedAt = "2022-03-11T10:53:46-05:00",
          addresses = List(
            Address(
              id = Some(207119551),
              customerId = Some(207119551),
              address1 = "Chestnut Street 92",
              address2 = Some(""),
              city = "Louisville",
              country = "United States",
              countryCode = Some("US"),
              countryName = Some("United States"),
              company = None,
              firstName = None,
              lastName = None,
              latitude = None,
              longitude = None,
              name = Some(""),
              phone = "555-625-1199",
              province = "Kentucky",
              provinceCode = Some("KY"),
              zip = "40202",
              default = Some(true)
            )
          ),
          currency = Some("USD"),
          defaultAddress = Some(
            Address(
              id = Some(207119551),
              customerId = Some(207119551),
              address1 = "Chestnut Street 92",
              address2 = Some(""),
              city = "Louisville",
              country = "United States",
              countryCode = Some("US"),
              countryName = Some("United States"),
              company = None,
              firstName = None,
              lastName = None,
              latitude = None,
              longitude = None,
              name = Some(""),
              phone = "555-625-1199",
              province = "Kentucky",
              provinceCode = Some("KY"),
              zip = "40202",
              default = Some(true)
            )
          ),
          lastOrderId = Some(450789469),
          lastOrderName = Some("#1001"),
          metafield = None,
          marketingOptInLevel = Some("single_opt_in"),
          multipassIdentifier = None,
          note = None,
          ordersCount = Some(1),
          phone = Some("+16136120707"),
          smsMarketingConsent = Some(
            SmsMarketingConsent(
              state = "not_subscribed",
              optInLevel = Some("single_opt_in"),
              consentUpdatedAt = None,
              consentCollectedFrom = Some("OTHER")
            )
          ),
          emailMarketingConsent = None,
          smsTransactionalConsent = None,
          state = Some("disabled"),
          tags = Some(""),
          taxExempt = Some(false),
          tax_exemptions = List.empty,
          totalSpent = Some(199.65),
          verifiedEmail = Some(true),
          createdAt = "2022-03-11T10:52:46-05:00",
          updatedAt = "2022-03-11T10:53:46-05:00"
        )
      )
    )
  )
}
