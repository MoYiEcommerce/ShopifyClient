package com.moyiecomm.shopify.api.customers

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.customers.models.AccountActivationUrl
import sttp.model.{Method, StatusCode}

class CreateAccountActivationUrlSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateAccountActivationUrl(207119551),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/customers/207119551/account_activation_url.json",
    expectedMethod = Method.POST,
    expectedRequestBody = None,
    mapping = post("/admin/api/2022-01/customers/207119551/account_activation_url.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "account_activation_url": "https://jsmith.myshopify.com/account/activate/207119551/0023d06f591109967cba97f8752d0bbb-1649177895"
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      AccountActivationUrl("https://jsmith.myshopify.com/account/activate/207119551/0023d06f591109967cba97f8752d0bbb-1649177895")
    )
  )

}
