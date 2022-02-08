package com.moyiecomm.shopify.api

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

import scala.util.Try

import io.circe.Decoder
import io.circe.generic.extras.Configuration

trait CirceConfig {
  private val formatter                    = DateTimeFormatter.ISO_OFFSET_DATE_TIME
  implicit val customConfig: Configuration = Configuration.default.withSnakeCaseMemberNames

  // zone id should configurable
  implicit val timeStringToEpocMilli: Decoder[ZonedDateTime] = Decoder.decodeString.emapTry { timeString =>
    Try(LocalDateTime.parse(timeString, formatter).atZone(ZoneId.of("Europe/Amsterdam")))
  }
}
