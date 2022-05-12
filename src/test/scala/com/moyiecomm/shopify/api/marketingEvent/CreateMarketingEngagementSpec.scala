package com.moyiecomm.shopify.api.marketingEvent

import com.github.tomakehurst.wiremock.client.WireMock._
import com.moyiecomm.shopify.api.ApiSpec
import com.moyiecomm.shopify.api.marketingEvent.models.Engagement
import sttp.model.{Method, StatusCode}

import java.time.{LocalDate, ZonedDateTime}
import java.time.format.DateTimeFormatter

class CreateMarketingEngagementSpec extends ApiSpec {
  it should behave like correctShopifyRequestBehaviour(
    apiRequest = CreateMarketingEngagement(
      998730532,
      List(
        Engagement(
          occurredOn = LocalDate.parse("2022-01-15"),
          adSpend = Some(10.0),
          fetchedAt = None,
          viewsCount = Some(0),
          impressionsCount = None,
          clicksCount = Some(0),
          favoritesCount = Some(0),
          commentsCount = None,
          sharesCount = None,
          currencyCode = None,
          isCumulative = Some(true),
          unsubscribesCount = None,
          complaintsCount = None,
          failsCount = None,
          sendsCount = None,
          uniqueViewsCount = None,
          uniqueClicksCount = None,
          utcOffset = None
        ),
        Engagement(
          occurredOn = LocalDate.parse("2022-01-16"),
          adSpend = None,
          fetchedAt = None,
          viewsCount = Some(100),
          impressionsCount = None,
          clicksCount = Some(50),
          favoritesCount = None,
          commentsCount = None,
          sharesCount = None,
          currencyCode = None,
          isCumulative = Some(true),
          unsubscribesCount = None,
          complaintsCount = None,
          failsCount = None,
          sendsCount = None,
          uniqueViewsCount = None,
          uniqueClicksCount = None,
          utcOffset = None
        ),
        Engagement(
          occurredOn = LocalDate.parse("2022-01-17"),
          adSpend = None,
          fetchedAt = None,
          viewsCount = Some(200),
          impressionsCount = None,
          clicksCount = Some(100),
          favoritesCount = None,
          commentsCount = None,
          sharesCount = None,
          currencyCode = None,
          isCumulative = Some(true),
          unsubscribesCount = None,
          complaintsCount = None,
          failsCount = None,
          sendsCount = None,
          uniqueViewsCount = None,
          uniqueClicksCount = None,
          utcOffset = None
        )
      )
    ),
    expectedUrl = s"http://localhost:$port/admin/api/2022-01/marketing_events/998730532/engagements.json",
    expectedMethod = Method.POST,
    expectedRequestBody = Some(
      """{"engagements":[{"occurred_on":"2022-01-15","views_count":0,"clicks_count":0,"favorites_count":0,"ad_spend":10.0,"is_cumulative":true},{"occurred_on":"2022-01-16","views_count":100,"clicks_count":50,"is_cumulative":true},{"occurred_on":"2022-01-17","views_count":200,"clicks_count":100,"is_cumulative":true}]}"""
    ),
    mapping = post("/admin/api/2022-01/marketing_events/998730532/engagements.json")
      .withBasicAuth("testKeyId", "testKeySecret")
      .withRequestBody(
        equalToJson(
          """{"engagements":[{"occurred_on":"2022-01-15","views_count":0,"clicks_count":0,"favorites_count":0,"ad_spend":10.0,"is_cumulative":true},{"occurred_on":"2022-01-16","views_count":100,"clicks_count":50,"is_cumulative":true},{"occurred_on":"2022-01-17","views_count":200,"clicks_count":100,"is_cumulative":true}]}"""
        )
      )
      .willReturn(
        aResponse()
          .withStatus(201)
          .withBody("""
                      |{
                      |  "engagements": [
                      |    {
                      |      "occurred_on": "2022-01-15",
                      |      "fetched_at": null,
                      |      "views_count": 0,
                      |      "impressions_count": null,
                      |      "clicks_count": 0,
                      |      "favorites_count": 0,
                      |      "comments_count": null,
                      |      "shares_count": null,
                      |      "ad_spend": "10.0",
                      |      "currency_code": null,
                      |      "is_cumulative": true,
                      |      "unsubscribes_count": null,
                      |      "complaints_count": null,
                      |      "fails_count": null,
                      |      "sends_count": null,
                      |      "unique_views_count": null,
                      |      "unique_clicks_count": null,
                      |      "utc_offset": null
                      |    },
                      |    {
                      |      "occurred_on": "2022-01-16",
                      |      "fetched_at": null,
                      |      "views_count": 100,
                      |      "impressions_count": null,
                      |      "clicks_count": 50,
                      |      "favorites_count": null,
                      |      "comments_count": null,
                      |      "shares_count": null,
                      |      "ad_spend": null,
                      |      "currency_code": null,
                      |      "is_cumulative": true,
                      |      "unsubscribes_count": null,
                      |      "complaints_count": null,
                      |      "fails_count": null,
                      |      "sends_count": null,
                      |      "unique_views_count": null,
                      |      "unique_clicks_count": null,
                      |      "utc_offset": null
                      |    },
                      |    {
                      |      "occurred_on": "2022-01-17",
                      |      "fetched_at": null,
                      |      "views_count": 200,
                      |      "impressions_count": null,
                      |      "clicks_count": 100,
                      |      "favorites_count": null,
                      |      "comments_count": null,
                      |      "shares_count": null,
                      |      "ad_spend": null,
                      |      "currency_code": null,
                      |      "is_cumulative": true,
                      |      "unsubscribes_count": null,
                      |      "complaints_count": null,
                      |      "fails_count": null,
                      |      "sends_count": null,
                      |      "unique_views_count": null,
                      |      "unique_clicks_count": null,
                      |      "utc_offset": null
                      |    }
                      |  ]
                      |}
                      |""".stripMargin)
      ),
    expectedStatusCode = StatusCode.Created,
    expectedResponseBody = Some(
      List(
        Engagement(
          occurredOn = LocalDate.parse("2022-01-15"),
          adSpend = Some(10.0),
          fetchedAt = None,
          viewsCount = Some(0),
          impressionsCount = None,
          clicksCount = Some(0),
          favoritesCount = Some(0),
          commentsCount = None,
          sharesCount = None,
          currencyCode = None,
          isCumulative = Some(true),
          unsubscribesCount = None,
          complaintsCount = None,
          failsCount = None,
          sendsCount = None,
          uniqueViewsCount = None,
          uniqueClicksCount = None,
          utcOffset = None
        ),
        Engagement(
          occurredOn = LocalDate.parse("2022-01-16"),
          adSpend = None,
          fetchedAt = None,
          viewsCount = Some(100),
          impressionsCount = None,
          clicksCount = Some(50),
          favoritesCount = None,
          commentsCount = None,
          sharesCount = None,
          currencyCode = None,
          isCumulative = Some(true),
          unsubscribesCount = None,
          complaintsCount = None,
          failsCount = None,
          sendsCount = None,
          uniqueViewsCount = None,
          uniqueClicksCount = None,
          utcOffset = None
        ),
        Engagement(
          occurredOn = LocalDate.parse("2022-01-17"),
          adSpend = None,
          fetchedAt = None,
          viewsCount = Some(200),
          impressionsCount = None,
          clicksCount = Some(100),
          favoritesCount = None,
          commentsCount = None,
          sharesCount = None,
          currencyCode = None,
          isCumulative = Some(true),
          unsubscribesCount = None,
          complaintsCount = None,
          failsCount = None,
          sendsCount = None,
          uniqueViewsCount = None,
          uniqueClicksCount = None,
          utcOffset = None
        )
      )
    )
  )

}
