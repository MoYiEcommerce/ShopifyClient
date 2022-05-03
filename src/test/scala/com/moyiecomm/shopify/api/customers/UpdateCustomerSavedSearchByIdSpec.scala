package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.CustomerSavedSearch
import sttp.model.{Method, StatusCode}

class UpdateCustomerSavedSearchByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateCustomerSavedSearchById(
      CustomerSavedSearch(
        id = Some(789629109),
        name = "This Name Has Been Changed",
        query = "accepts_marketing:1",
        createdAt = None,
        updatedAt = None
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customer_saved_searches/789629109.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some(
      """{"customer_saved_search":{"id":789629109,"name":"This Name Has Been Changed","query":"accepts_marketing:1"}}"""
    ),
    mapping = put("/admin/api/2022-01/customer_saved_searches/789629109.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"customer_saved_search":{"id":789629109,"name":"This Name Has Been Changed","query":"accepts_marketing:1"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "customer_saved_search": {
                      |    "name": "This Name Has Been Changed",
                      |    "id": 789629109,
                      |    "created_at": "2022-03-04T10:52:46-05:00",
                      |    "updated_at": "2022-03-11T10:53:35-05:00",
                      |    "query": "accepts_marketing:1"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      CustomerSavedSearch(
        id = Some(789629109),
        name = "This Name Has Been Changed",
        query = "accepts_marketing:1",
        createdAt = "2022-03-04T10:52:46-05:00",
        updatedAt = "2022-03-11T10:53:35-05:00"
      )
    )
  )

}
