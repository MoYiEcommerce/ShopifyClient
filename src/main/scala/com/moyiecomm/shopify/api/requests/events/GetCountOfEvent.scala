package com.moyiecomm.shopify.api.requests.events

import com.moyiecomm.shopify.api.builder.CountRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

case class GetCountOfEvent(
    minimumDateTime: Option[ZonedDateTime],
    maximumDateTime: Option[ZonedDateTime],
    override val config: Config
) extends CountRequest(config) {
  override val path: String = {
    val dateTimeFormatter    = DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:mm:ssxxx")
    val minDateTimeParameter = minimumDateTime.map(_.format(dateTimeFormatter)).map(str => s"created_at_min=$str")
    val maxDateTimeParameter = maximumDateTime.map(_.format(dateTimeFormatter)).map(str => s"created_at_max=$str")
    s"events/count.json${Seq(minimumDateTime, maximumDateTime).flatten.map(_ => "?").headOption.getOrElse("")}${minDateTimeParameter
      .map(m => s"$m&")
      .getOrElse("")}${maxDateTimeParameter.getOrElse("")}"
  }
}
