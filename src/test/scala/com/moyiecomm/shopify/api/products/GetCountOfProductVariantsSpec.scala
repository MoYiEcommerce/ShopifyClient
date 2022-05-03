package com.moyiecomm.shopify.api.products

import com.github.tomakehurst.wiremock.client.WireMock.{aResponse, get}
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.shared.models.CountOfRequestedItems
import sttp.model.{Method, StatusCode}

class GetCountOfProductVariantsSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetCountOfProductVariants(234213466),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/products/234213466/variants/count.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/products/234213466/variants/count.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "count": 103
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      CountOfRequestedItems(103)
    )
  )
}
