package com.moyiecomm.shopify.api.v1.marketingEvent.models

import com.moyiecomm.shopify.api.json.CirceConfig
import com.moyiecomm.shopify.api.v1.marketingEvent.models.MarketingEvent.MarketedResource
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._
import io.circe.syntax._

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

case class MarketingEvent(
    id: Option[Long],
    remoteId: Option[String],
    eventType: String,
    marketingChannel: String,
    paid: Boolean,
    referringDomain: Option[String],
    budget: Option[Double],
    currency: Option[String],
    budgetType: Option[String],
    startedAt: Option[ZonedDateTime],
    scheduledToEndAt: Option[ZonedDateTime],
    endedAt: Option[ZonedDateTime],
    description: Option[String],
    manageUrl: Option[String],
    previewUrl: Option[String],
    marketedResources: List[MarketedResource],
    utmCampaign: Option[String],
    utmSource: Option[String],
    utmMedium: Option[String]
)

object MarketingEvent extends CirceConfig {
  case class MarketedResource(id: Long, `type`: String)

  implicit val marketedResourceEncoder: Encoder[MarketedResource] = deriveConfiguredEncoder[MarketedResource]
  implicit val marketedResourceDecoder: Decoder[MarketedResource] = deriveConfiguredDecoder[MarketedResource]

  val marketingEventEncoder: Encoder[MarketingEvent] = {
    implicit val zonedDateTimeEncoder: Encoder[ZonedDateTime] = {
      val dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:mm:ssxxx")
      new Encoder[ZonedDateTime] {
        override def apply(a: ZonedDateTime): Json = Json.fromString(a.format(dateTimeFormatter))
      }
    }
    new Encoder[MarketingEvent] {
      override def apply(a: MarketingEvent): Json = Json.obj(
        (
          "marketing_event",
          Json
            .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
            .dropNullValues
            .dropEmptyValues
            .deepDropNullValues
            .dropEmptyString
        )
      )
    }
  }

  val marketingEventDecoder: Decoder[MarketingEvent] = new Decoder[MarketingEvent] {
    override def apply(c: HCursor): Result[MarketingEvent] = c.get[MarketingEvent]("marketing_event")(deriveConfiguredDecoder)
  }

  val marketingEventListDecoder: Decoder[List[MarketingEvent]] = {
    implicit val marketingEventDecoder: Decoder[MarketingEvent] = deriveConfiguredDecoder[MarketingEvent]
    new Decoder[List[MarketingEvent]] {
      override def apply(c: HCursor): Result[List[MarketingEvent]] = c.get[List[MarketingEvent]]("marketing_events")
    }
  }
}
