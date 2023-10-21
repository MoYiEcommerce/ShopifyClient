package com.moyiecomm.shopify.api.v1.events.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe._
import io.circe.syntax._

import java.time.ZonedDateTime

case class Event(
    id: Long,
    arguments: List[String],
    body: Option[String],
    path: String,
    message: String,
    subjectId: Long,
    subjectType: String,
    verb: String,
    author: Option[String],
    description: Option[String],
    createdAt: Option[ZonedDateTime]
)

object Event extends CirceConfig {
  val eventListDecoder: Decoder[List[Event]] = {
    implicit val eventDecoder: Decoder[Event] = deriveConfiguredDecoder[Event]
    new Decoder[List[Event]] {
      override def apply(c: HCursor): Result[List[Event]] = c.get[List[Event]]("events")
    }
  }

  val eventDecoder: Decoder[Event] = new Decoder[Event] {
    override def apply(c: HCursor): Result[Event] = c.get[Event]("event")(deriveConfiguredDecoder)
  }
}
