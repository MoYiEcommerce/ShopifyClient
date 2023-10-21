package com.moyiecomm.shopify.api.v1.marketingEvent.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe._
import io.circe.syntax._

import java.time.{LocalDate, ZonedDateTime}
import java.time.format.DateTimeFormatter

case class Engagement(
    occurredOn: LocalDate,
    adSpend: Option[Double],
    fetchedAt: Option[ZonedDateTime],
    viewsCount: Option[Int],
    impressionsCount: Option[Int],
    clicksCount: Option[Int],
    favoritesCount: Option[Int],
    commentsCount: Option[Int],
    sharesCount: Option[Int],
    currencyCode: Option[String],
    isCumulative: Option[Boolean],
    unsubscribesCount: Option[Int],
    complaintsCount: Option[Int],
    failsCount: Option[Int],
    sendsCount: Option[Int],
    uniqueViewsCount: Option[Int],
    uniqueClicksCount: Option[Int],
    utcOffset: Option[String]
)

object Engagement extends CirceConfig {
  val engagementListEncoder: Encoder[List[Engagement]] = new Encoder[List[Engagement]] {
    override def apply(a: List[Engagement]): Json = Json.obj(
      (
        "engagements",
        Json.fromValues(
          a.map(engagement =>
            deriveConfiguredEncoder[Engagement].mapJson(_.dropEmptyValues.dropNullValues.dropEmptyString)(engagement)
          )
        )
      )
    )
  }

  val engagementListDecoder: Decoder[List[Engagement]] = {
    implicit val egDecoder: Decoder[Engagement] = deriveConfiguredDecoder[Engagement]
    new Decoder[List[Engagement]] {
      override def apply(c: HCursor): Result[List[Engagement]] = c.get[List[Engagement]]("engagements")
    }
  }
}
