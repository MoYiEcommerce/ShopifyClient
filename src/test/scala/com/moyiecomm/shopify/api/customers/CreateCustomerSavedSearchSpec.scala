package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.CustomerSavedSearch
import sttp.model.{Method, StatusCode}

class CreateCustomerSavedSearchSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateCustomerSavedSearch(CustomerSavedSearch(None, "Spent more than $50", "total_spent:\u003e50", None, None)),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customer_saved_searches.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some("""{"customer_saved_search":{"name":"Spent more than $50","query":"total_spent:\u003e50"}}"""),
    mapping = post("/admin/api/2022-01/customer_saved_searches.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"customer_saved_search":{"name":"Spent more than $50","query":"total_spent:\u003e50"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "customer_saved_search": {
                      |    "id": 1068136102,
                      |    "name": "Spent more than $50",
                      |    "created_at": "2022-03-11T10:53:32-05:00",
                      |    "updated_at": "2022-03-11T10:53:32-05:00",
                      |    "query": "total_spent:>50"
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      CustomerSavedSearch(
        id = Some(1068136102),
        name = "Spent more than $50",
        query = "total_spent:>50",
        createdAt = "2022-03-11T10:53:32-05:00",
        updatedAt = "2022-03-11T10:53:32-05:00"
      )
    )
  )
}
