package com.moyiecomm.shopify.api

import com.moyiecomm.shopify.request.ApiConfig
import com.moyiecomm.shopify.{MockServer, UnitSpec}
import sttp.client3.SttpBackend
import sttp.client3.asynchttpclient.future.AsyncHttpClientFutureBackend

import java.time.{LocalDateTime, ZoneId, ZonedDateTime}
import java.time.format.DateTimeFormatter
import scala.concurrent.Future
import scala.language.implicitConversions

trait ApiSpec extends UnitSpec with MockServer {
  implicit val apiConfig: ApiConfig =
    ApiConfig(
      apiKeyId = "testKeyId",
      apiKeySecret = "testKeySecret",
      shopUrl = s"localhost:$port",
      adminApiVersion = "2022-01"
    )
  implicit val httpBackend: SttpBackend[Future, Any] = AsyncHttpClientFutureBackend()

  implicit def timeStringToZonedDateTime(time: String): ZonedDateTime = {
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    LocalDateTime.parse(time, formatter).atZone(ZoneId.of("Europe/Amsterdam"))
  }
}
