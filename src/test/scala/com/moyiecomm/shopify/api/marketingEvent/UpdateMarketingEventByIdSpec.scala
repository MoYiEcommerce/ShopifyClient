package com.moyiecomm.shopify.api.marketingEvent

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.marketingEvent.models.MarketingEvent
import sttp.model.{Method, StatusCode}

class UpdateMarketingEventByIdSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = UpdateMarketingEventById(
      MarketingEvent(
        id = Some(998730532),
        remoteId = Some("1000:2000"),
        eventType = "ad",
        marketingChannel = "social",
        paid = false,
        referringDomain = Some("instagram.com"),
        budget = Some(11.1),
        currency = Some("CAD"),
        budgetType = Some("daily"),
        startedAt = "2022-02-02T00:00+00:00",
        scheduledToEndAt = "2022-02-04T00:00+00:00",
        endedAt = "2022-02-03T00:00+00:00",
        description = None,
        manageUrl = None,
        previewUrl = None,
        marketedResources = List.empty,
        utmMedium = Some("other"),
        utmCampaign = Some("other"),
        utmSource = Some("other")
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/marketing_events/998730532.json",
    expectedMethod = Method.PUT,
    expectedRequestBody = Some(
      """{"marketing_event":{"id":998730532,"remote_id":"1000:2000","paid":false,"marketing_channel":"social","started_at":"2022-02-02T00:00:00+00:00","ended_at":"2022-02-03T00:00:00+00:00","scheduled_to_end_at":"2022-02-04T00:00:00+00:00","budget":11.1,"budget_type":"daily","currency":"CAD","utm_campaign":"other","utm_source":"other","utm_medium":"other","event_type":"ad","referring_domain":"instagram.com"}}"""
    ),
    mapping = put("/admin/api/2022-01/marketing_events/998730532.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"marketing_event":{"id":998730532,"remote_id":"1000:2000","paid":false,"marketing_channel":"social","started_at":"2022-02-02T00:00:00+00:00","ended_at":"2022-02-03T00:00:00+00:00","scheduled_to_end_at":"2022-02-04T00:00:00+00:00","budget":11.1,"budget_type":"daily","currency":"CAD","utm_campaign":"other","utm_source":"other","utm_medium":"other","event_type":"ad","referring_domain":"instagram.com"}}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(200)
          .withBody("""
                      |{
                      |  "marketing_event": {
                      |    "started_at": "2022-02-01T19:00:00-05:00",
                      |    "ended_at": "2022-02-02T19:00:00-05:00",
                      |    "scheduled_to_end_at": "2022-02-03T19:00:00-05:00",
                      |    "remote_id": "1000:2000",
                      |    "currency": "CAD",
                      |    "budget": "11.1",
                      |    "budget_type": "daily",
                      |    "id": 998730532,
                      |    "event_type": "post",
                      |    "manage_url": null,
                      |    "preview_url": null,
                      |    "utm_campaign": "1234567890",
                      |    "utm_source": "facebook",
                      |    "utm_medium": "facebook-post",
                      |    "description": null,
                      |    "marketing_channel": "social",
                      |    "paid": false,
                      |    "referring_domain": "facebook.com",
                      |    "breadcrumb_id": null,
                      |    "marketing_activity_id": null,
                      |    "admin_graphql_api_id": "gid://shopify/MarketingEvent/998730532",
                      |    "marketed_resources": []
                      |  }
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Ok,
    expectedResponseBody = Some(
      MarketingEvent(
        id = Some(998730532),
        remoteId = Some("1000:2000"),
        eventType = "post",
        marketingChannel = "social",
        paid = false,
        referringDomain = Some("facebook.com"),
        budget = Some(11.1),
        currency = Some("CAD"),
        budgetType = Some("daily"),
        startedAt = "2022-02-01T19:00:00-05:00",
        scheduledToEndAt = "2022-02-03T19:00:00-05:00",
        endedAt = "2022-02-02T19:00:00-05:00",
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

}
