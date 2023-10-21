package com.moyiecomm.shopify.api.v1.events

import com.moyiecomm.shopify.api.v1.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

case class GetCountOfEvent(minimumDateTime: Option[ZonedDateTime], maximumDateTime: Option[ZonedDateTime])(implicit
    val apiConfig: ApiConfig
) extends GetCountOfItemRequest {
  override def path: String = {
    val dateTimeFormatter    = DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:mm:ssxxx")
    val minDateTimeParameter = minimumDateTime.map(_.format(dateTimeFormatter)).map(str => s"created_at_min=$str")
    val maxDateTimeParameter = maximumDateTime.map(_.format(dateTimeFormatter)).map(str => s"created_at_max=$str")
    s"/events/count.json${Seq(minimumDateTime, maximumDateTime).flatten.map(_ => "?").headOption.getOrElse("")}${minDateTimeParameter
      .map(m => s"$m&")
      .getOrElse("")}${maxDateTimeParameter.getOrElse("")}"
  }
}
