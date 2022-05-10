package com.moyiecomm.shopify.api.events

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.events.models.Event
import com.moyiecomm.shopify.api.shared.models.CountOfRequestedItems
import sttp.model.{Method, StatusCode}

import java.time.ZonedDateTime

class GetCountOfEventSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetCountOfEvent(None, Some(ZonedDateTime.parse("2008-01-10T13:00:00+00:00"))),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/events/count.json?created_at_max=2008-01-10T13:00:00+00:00",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/events/count.json?created_at_max=2008-01-10T13:00:00+00:00")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "count": 1
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      CountOfRequestedItems(1)
    )
  )

}
