package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.Address
import sttp.model.{Method, StatusCode}

class CreateCustomerAddressSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateCustomerAddress(
      Address(
        id = None,
        address1 = "1 Rue des Carrieres",
        address2 = Some("Suite 1234"),
        city = "Montreal",
        company = Some("Fancy Co."),
        firstName = Some("Samuel"),
        lastName = Some("de Champlain"),
        phone = "819-555-5555",
        province = "Quebec",
        country = "Canada",
        zip = "G1R 4P5",
        name = Some("Samuel de Champlain"),
        provinceCode = Some("QC"),
        countryCode = Some("CA"),
        countryName = Some("Canada"),
        customerId = Some(207119551),
        latitude = None,
        longitude = None,
        default = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customers/207119551/addresses.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"address":{"address1":"1 Rue des Carrieres","address2":"Suite 1234","city":"Montreal","company":"Fancy Co.","first_name":"Samuel","last_name":"de Champlain","phone":"819-555-5555","province":"Quebec","country":"Canada","zip":"G1R 4P5","name":"Samuel de Champlain","province_code":"QC","country_code":"CA","country_name":"Canada"}}"""
    ),
    mapping = post("/admin/api/2022-01/customers/207119551/addresses.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalTo(
          """{"address":{"address1":"1 Rue des Carrieres","address2":"Suite 1234","city":"Montreal","company":"Fancy Co.","first_name":"Samuel","last_name":"de Champlain","phone":"819-555-5555","province":"Quebec","country":"Canada","zip":"G1R 4P5","name":"Samuel de Champlain","province_code":"QC","country_code":"CA","country_name":"Canada"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "customer_address": {
                      |    "id": 1053317287,
                      |    "customer_id": 207119551,
                      |    "first_name": "Samuel",
                      |    "last_name": "de Champlain",
                      |    "company": "Fancy Co.",
                      |    "address1": "1 Rue des Carrieres",
                      |    "address2": "Suite 1234",
                      |    "city": "Montreal",
                      |    "province": "Quebec",
                      |    "country": "Canada",
                      |    "zip": "G1R 4P5",
                      |    "phone": "819-555-5555",
                      |    "name": "Samuel de Champlain",
                      |    "province_code": "QC",
                      |    "country_code": "CA",
                      |    "country_name": "Canada",
                      |    "default": false
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      Address(
        id = Some(1053317287),
        customerId = Some(207119551),
        address1 = "1 Rue des Carrieres",
        address2 = Some("Suite 1234"),
        city = "Montreal",
        country = "Canada",
        countryCode = Some("CA"),
        countryName = Some("Canada"),
        company = Some("Fancy Co."),
        firstName = Some("Samuel"),
        lastName = Some("de Champlain"),
        latitude = None,
        longitude = None,
        name = Some("Samuel de Champlain"),
        phone = "819-555-5555",
        province = "Quebec",
        provinceCode = Some("QC"),
        zip = "G1R 4P5",
        default = Some(false)
      )
    )
  )

}
