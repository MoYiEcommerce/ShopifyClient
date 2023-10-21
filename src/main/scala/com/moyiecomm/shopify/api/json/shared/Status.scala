package com.moyiecomm.shopify.api.json.shared

import io.circe.Decoder.Result
import io.circe._

sealed trait Status
case object Pending   extends Status
case object Accepted  extends Status
case object Active    extends Status
case object Declined  extends Status
case object Expired   extends Status
case object Frozen    extends Status
case object Cancelled extends Status

object Status {
  implicit val statusEncoder: Encoder[Status] = new Encoder[Status] {
    override def apply(a: Status): Json = a match {
      case Pending   => Json.fromString("pending")
      case Accepted  => Json.fromString("accepted")
      case Active    => Json.fromString("active")
      case Declined  => Json.fromString("declined")
      case Expired   => Json.fromString("expired")
      case Frozen    => Json.fromString("frozen")
      case Cancelled => Json.fromString("cancelled")
    }
  }

  Encoder.encodeZonedDateTime

  implicit val statusDecoder: Decoder[Status] = new Decoder[Status] {
    override def apply(c: HCursor): Result[Status] = c.value.asString
      .map {
        case "pending"   => Pending
        case "accepted"  => Accepted
        case "active"    => Active
        case "declined"  => Declined
        case "expired"   => Expired
        case "frozen"    => Frozen
        case "cancelled" => Cancelled
      }
      .fold[Result[Status]](Left(DecodingFailure(s"${c.value.asString} is not expected status", c.history)))(v => Right(v))
  }
}
