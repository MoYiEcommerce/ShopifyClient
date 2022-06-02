package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.Order
import com.moyiecomm.shopify.api.orders.models.Order.orderListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

case class GetOrderList(
    createdAtMax: Option[ZonedDateTime],
    createdAtMin: Option[ZonedDateTime],
    financialStatus: Option[String],
    fulfillmentStatus: Option[String],
    ids: List[Long],
    limit: Option[Int],
    processedAtMax: Option[ZonedDateTime],
    processedAtMin: Option[ZonedDateTime],
    sinceId: Option[Long]
)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[Order]]()(orderListDecoder) {
  override def path: String = {
    val parameters: String = {
      val dateTimeFormatter     = DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:mm:ssxxx")
      val createdAtMaxPara      = createdAtMax.map(_.format(dateTimeFormatter)).map(str => s"updated_at_max=$str")
      val createdAtMinPara      = createdAtMin.map(_.format(dateTimeFormatter)).map(str => s"updated_at_min=$str")
      val processedAtMaxPara    = processedAtMax.map(_.format(dateTimeFormatter)).map(str => s"updated_at_min=$str")
      val processedAtMinPara    = processedAtMin.map(_.format(dateTimeFormatter)).map(str => s"updated_at_min=$str")
      val financialStatusPara   = financialStatus.map(str => s"financial_status=$str")
      val fulfillmentStatusPara = fulfillmentStatus.map(str => s"fulfillment_status=$str")
      val limitPara             = limit.map(str => s"limit=$str")
      val sinceIdPara           = sinceId.map(str => s"sinceId=$str")
      val idsParam              = if (ids.nonEmpty) Some(s"ids=[${ids.mkString(",")}]") else None
      Seq(
        createdAtMaxPara,
        createdAtMinPara,
        processedAtMaxPara,
        processedAtMinPara,
        financialStatusPara,
        fulfillmentStatusPara,
        limitPara,
        sinceIdPara,
        idsParam
      ).flatten
        .mkString("&")
    }
    Seq("/orders.json", parameters).mkString("?")
  }
}
