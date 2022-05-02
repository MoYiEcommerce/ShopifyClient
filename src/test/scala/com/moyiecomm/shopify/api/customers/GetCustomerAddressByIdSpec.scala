package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, get}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.Address
import sttp.model.{Method, StatusCode}

class GetCustomerAddressByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetCustomerAddressById(customerId = 207119551, addressId = 207119551),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customers/207119551/addresses/207119551.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/customers/207119551/addresses/207119551.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "customer_address": {
                      |    "id": 207119551,
                      |    "customer_id": 207119551,
                      |    "first_name": null,
                      |    "last_name": null,
                      |    "company": null,
                      |    "address1": "Chestnut Street 92",
                      |    "address2": "",
                      |    "city": "Louisville",
                      |    "province": "Kentucky",
                      |    "country": "United States",
                      |    "zip": "40202",
                      |    "phone": "555-625-1199",
                      |    "name": "",
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
    )
  )
}
