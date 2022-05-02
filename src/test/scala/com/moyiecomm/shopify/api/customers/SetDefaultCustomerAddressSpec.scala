package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.Address
import sttp.model.{Method, StatusCode}

class SetDefaultCustomerAddressSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = SetDefaultCustomerAddress(207119551, 1053317290),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customers/207119551/addresses/1053317290/default.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = None,
    mapping = put("/admin/api/2022-01/customers/207119551/addresses/1053317290/default.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "customer_address": {
                      |    "id": 1053317290,
                      |    "customer_id": 207119551,
                      |    "first_name": "Bob",
                      |    "last_name": "Norman",
                      |    "company": null,
                      |    "address1": "Chestnut Street 92",
                      |    "address2": "",
                      |    "city": "Louisville",
                      |    "province": "Kentucky",
                      |    "country": "United States",
                      |    "zip": "40202",
                      |    "phone": "555-625-1199",
                      |    "name": "Bob Norman",
                      |    "province_code": "KY",
                      |    "country_code": "US",
                      |    "country_name": "United States",
                      |    "default": true
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Address(
        id = Some(1053317290),
        customerId = Some(207119551),
        address1 = "Chestnut Street 92",
        address2 = Some(""),
        city = "Louisville",
        country = "United States",
        countryCode = Some("US"),
        countryName = Some("United States"),
        company = None,
        firstName = Some("Bob"),
        lastName = Some("Norman"),
        latitude = None,
        longitude = None,
        name = Some("Bob Norman"),
        phone = "555-625-1199",
        province = "Kentucky",
        provinceCode = Some("KY"),
        zip = "40202",
        default = Some(true)
      )
    )
  )
}
