package com.moyiecomm.shopify.api.marketingEvent

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.marketingEvent.models.MarketingEvent
import sttp.model.{Method, StatusCode}

class GetMarketingEventListSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = GetMarketingEventList(),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/marketing_events.json",
    expectedMethod = Method.GET,
    expectedRequestBody = None,
    mapping = get("/admin/api/2022-01/marketing_events.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "marketing_events": [
                      |    {
                      |      "id": 998730532,
                      |      "event_type": "post",
                      |      "remote_id": "12345678",
                      |      "started_at": "2022-01-15T10:56:18-05:00",
                      |      "ended_at": null,
                      |      "scheduled_to_end_at": null,
                      |      "budget": "10.11",
                      |      "currency": "GBP",
                      |      "manage_url": null,
                      |      "preview_url": null,
                      |      "utm_campaign": "1234567890",
                      |      "utm_source": "facebook",
                      |      "utm_medium": "facebook-post",
                      |      "budget_type": "daily",
                      |      "description": null,
                      |      "marketing_channel": "social",
                      |      "paid": false,
                      |      "referring_domain": "facebook.com",
                      |      "breadcrumb_id": null,
                      |      "marketing_activity_id": null,
                      |      "admin_graphql_api_id": "gid://shopify/MarketingEvent/998730532",
                      |      "marketed_resources": []
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      List(
        MarketingEvent(
          id = Some(998730532),
          remoteId = Some("12345678"),
          eventType = "post",
          marketingChannel = "social",
          paid = false,
          referringDomain = Some("facebook.com"),
          budget = Some(10.11),
          currency = Some("GBP"),
          budgetType = Some("daily"),
          startedAt = "2022-01-15T10:56:18-05:00",
          scheduledToEndAt = None,
          endedAt = None,
          description = None,
          manageUrl = None,
          previewUrl = None,
          marketedResources = List.empty,
          utmMedium = Some("facebook-post"),
          utmCampaign = Some("1234567890"),
          utmSource = Some("facebook")
        )
      )
    )
  )

}
