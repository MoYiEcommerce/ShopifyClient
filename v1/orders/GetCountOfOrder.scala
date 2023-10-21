package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

case class GetCountOfOrder(
    createdAtMax: Option[ZonedDateTime],
    createdAtMin: Option[ZonedDateTime],
    financialStatus: Option[String],
    fulfillmentStatus: Option[String],
    status: Option[String],
    updatedAtMax: Option[ZonedDateTime],
    updatedAtMin: Option[ZonedDateTime]
)(implicit val apiConfig: ApiConfig)
    extends GetCountOfItemRequest {
  override def path: String = {
    val parameters: String = {
      val dateTimeFormatter     = DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:mm:ssxxx")
      val createdAtMaxPara      = createdAtMax.map(_.format(dateTimeFormatter)).map(str => s"updated_at_max=$str")
      val createdAtMinPara      = createdAtMin.map(_.format(dateTimeFormatter)).map(str => s"updated_at_min=$str")
      val updatedAtMaxPara      = updatedAtMax.map(_.format(dateTimeFormatter)).map(str => s"updated_at_min=$str")
      val updatedAtMinPara      = updatedAtMin.map(_.format(dateTimeFormatter)).map(str => s"updated_at_min=$str")
      val financialStatusPara   = financialStatus.map(str => s"financial_status=$str")
      val fulfillmentStatusPara = fulfillmentStatus.map(str => s"fulfillment_status=$str")
      val statusPara            = status.map(str => s"sinceId=$str")
      Seq(
        createdAtMaxPara,
        createdAtMinPara,
        updatedAtMaxPara,
        updatedAtMinPara,
        financialStatusPara,
        fulfillmentStatusPara,
        statusPara
      ).flatten.mkString("&")
    }
    Seq(Some("/orders/count.json"), if (parameters.isBlank) None else Some(parameters)).flatten.mkString("?")
  }
}
