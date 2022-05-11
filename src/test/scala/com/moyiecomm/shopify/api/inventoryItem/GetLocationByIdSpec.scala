package com.moyiecomm.shopify.api.inventoryItem

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.inventory.{GetLocationById, GetLocationList}
import com.moyiecomm.shopify.api.inventory.models.Location
import sttp.model.{Method, StatusCode}

class GetLocationByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetLocationById(487838322),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/locations/487838322.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/locations/487838322.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "location": {
                      |    "id": 487838322,
                      |    "name": "Fifth Avenue AppleStore",
                      |    "address1": null,
                      |    "address2": null,
                      |    "city": null,
                      |    "zip": null,
                      |    "province": null,
                      |    "country": "US",
                      |    "phone": null,
                      |    "created_at": "2022-04-05T13:05:24-04:00",
                      |    "updated_at": "2022-04-05T13:05:24-04:00",
                      |    "country_code": "US",
                      |    "country_name": "United States",
                      |    "province_code": null,
                      |    "legacy": false,
                      |    "active": true,
                      |    "admin_graphql_api_id": "gid://shopify/Location/487838322"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      Location(
        id = 487838322,
        name = "Fifth Avenue AppleStore",
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
        localizedCountryName = None,
        localizedProvinceName = None,
        createdAt = "2022-04-05T13:05:24-04:00",
        updatedAt = "2022-04-05T13:05:24-04:00"
      )
    )
  )

}
