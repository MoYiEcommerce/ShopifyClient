package com.moyiecomm.shopify.api.inventoryItem

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.inventory.GetLocationList
import com.moyiecomm.shopify.api.inventory.models.Location
import sttp.model.{Method, StatusCode}

class GetLocationListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetLocationList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/locations.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/locations.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "locations": [
                      |    {
                      |      "id": 24826418,
                      |      "name": "Apple Api Shipwire",
                      |      "address1": null,
                      |      "address2": null,
                      |      "city": null,
                      |      "zip": null,
                      |      "province": null,
                      |      "country": "DE",
                      |      "phone": null,
                      |      "created_at": "2022-04-05T13:05:24-04:00",
                      |      "updated_at": "2022-04-05T13:05:24-04:00",
                      |      "country_code": "DE",
                      |      "country_name": "Germany",
                      |      "province_code": null,
                      |      "legacy": true,
                      |      "active": true,
                      |      "admin_graphql_api_id": "gid://shopify/Location/24826418",
                      |      "localized_country_name": "Germany",
                      |      "localized_province_name": null
                      |    },
                      |    {
                      |      "id": 844681632,
                      |      "name": "Apple Cupertino",
                      |      "address1": null,
                      |      "address2": null,
                      |      "city": null,
                      |      "zip": null,
                      |      "province": null,
                      |      "country": "US",
                      |      "phone": null,
                      |      "created_at": "2022-04-05T13:05:24-04:00",
                      |      "updated_at": "2022-04-05T13:05:24-04:00",
                      |      "country_code": "US",
                      |      "country_name": "United States",
                      |      "province_code": null,
                      |      "legacy": false,
                      |      "active": true,
                      |      "admin_graphql_api_id": "gid://shopify/Location/844681632",
                      |      "localized_country_name": "United States",
                      |      "localized_province_name": null
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        Location(
          id = 24826418,
          name = "Apple Api Shipwire",
          address1 = None,
          address2 = None,
          city = None,
          zip = None,
          province = None,
          country = Some("DE"),
          phone = None,
          countryCode = Some("DE"),
          provinceCode = None,
          legacy = Some(true),
          active = Some(true),
          localizedCountryName = Some("Germany"),
          localizedProvinceName = None,
          createdAt = "2022-04-05T13:05:24-04:00",
          updatedAt = "2022-04-05T13:05:24-04:00"
        ),
        Location(
          id = 844681632,
          name = "Apple Cupertino",
          address1 = None,
          address2 = None,
          city = None,
          zip = None,
          province = None,
          country = Some("US"),
          phone = None,
          countryCode = Some("US"),
          provinceCode = None,
          legacy = Some(false),
          active = Some(true),
          localizedCountryName = Some("United States"),
          localizedProvinceName = None,
          createdAt = "2022-04-05T13:05:24-04:00",
          updatedAt = "2022-04-05T13:05:24-04:00"
        )
      )
    )
  )

}
