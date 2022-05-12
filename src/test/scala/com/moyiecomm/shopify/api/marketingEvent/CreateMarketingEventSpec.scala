package com.moyiecomm.shopify.api.marketingEvent

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.marketingEvent.models.MarketingEvent
import sttp.model.{Method, StatusCode}

class CreateMarketingEventSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateMarketingEvent(
      MarketingEvent(
        id = None,
        remoteId = None,
        eventType = "ad",
        marketingChannel = "social",
        paid = true,
        referringDomain = Some("facebook.com"),
        budget = None,
        currency = None,
        budgetType = None,
        startedAt = "2022-12-14T19:00:00-05:00",
        scheduledToEndAt = None,
        endedAt = None,
        description = None,
        manageUrl = None,
        previewUrl = None,
        marketedResources = List.empty,
        utmMedium = Some("cpc"),
        utmCampaign = Some("Christmas2022"),
        utmSource = Some("facebook")
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/marketing_events.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"marketing_event":{"started_at":"2022-12-14T19:00:00-05:00","utm_campaign":"Christmas2022","utm_source":"facebook","utm_medium":"cpc","event_type":"ad","referring_domain":"facebook.com","marketing_channel":"social","paid":true}}"""
    ),
    mapping = post("/admin/api/2022-01/marketing_events.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"marketing_event":{"started_at":"2022-12-14T19:00:00-05:00","utm_campaign":"Christmas2022","utm_source":"facebook","utm_medium":"cpc","event_type":"ad","referring_domain":"facebook.com","marketing_channel":"social","paid":true}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "marketing_event": {
                      |    "id": 1065859216,
                      |    "event_type": "ad",
                      |    "remote_id": null,
                      |    "started_at": "2022-12-14T19:00:00-05:00",
                      |    "ended_at": null,
                      |    "scheduled_to_end_at": null,
                      |    "budget": null,
                      |    "currency": null,
                      |    "manage_url": null,
                      |    "preview_url": null,
                      |    "utm_campaign": "Christmas2022",
                      |    "utm_source": "facebook",
                      |    "utm_medium": "cpc",
                      |    "budget_type": null,
                      |    "description": null,
                      |    "marketing_channel": "social",
                      |    "paid": true,
                      |    "referring_domain": "facebook.com",
                      |    "breadcrumb_id": null,
                      |    "marketing_activity_id": 1063897333,
                      |    "admin_graphql_api_id": "gid://shopify/MarketingEvent/1065859216",
                      |    "marketed_resources": []
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      MarketingEvent(
        id = Some(1065859216),
        remoteId = None,
        eventType = "ad",
        marketingChannel = "social",
        paid = true,
        referringDomain = Some("facebook.com"),
        budget = None,
        currency = None,
        budgetType = None,
        startedAt = "2022-12-14T19:00:00-05:00",
        scheduledToEndAt = None,
        endedAt = None,
        description = None,
        manageUrl = None,
        previewUrl = None,
        marketedResources = List.empty,
        utmMedium = Some("cpc"),
        utmCampaign = Some("Christmas2022"),
        utmSource = Some("facebook")
      )
    )
  )

}
