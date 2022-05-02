package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.Address
import sttp.model.{Method, StatusCode}

class UpdateCustomerAddressByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateCustomerAddressById(
      Address(
        id = Some(207119551),
        customerId = Some(207119551),
        address1 = "",
        address2 = None,
        city = "",
        company = None,
        firstName = None,
        lastName = None,
        phone = "",
        province = "",
        country = "",
        zip = "90210",
        name = None,
        provinceCode = None,
        countryCode = None,
        countryName = None,
        latitude = None,
        longitude = None,
        default = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customers/207119551/addresses/207119551.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some("""{"address":{"id":207119551,"zip":"90210"}}"""),
    mapping = put("/admin/api/2022-01/customers/207119551/addresses/207119551.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"address":{"id":207119551,"zip":"90210"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "customer_address": {
                      |    "customer_id": 207119551,
                      |    "zip": "90210",
                      |    "country": "United States",
                      |    "province": "Kentucky",
                      |    "city": "Louisville",
                      |    "address1": "Chestnut Street 92",
                      |    "address2": "",
                      |    "first_name": null,
                      |    "last_name": null,
                      |    "company": null,
                      |    "phone": "555-625-1199",
                      |    "id": 207119551,
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
        zip = "90210",
        default = Some(true)
      )
    )
  )

}
