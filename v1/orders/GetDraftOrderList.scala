package com.moyiecomm.shopify.api.v1.orders

import com.moyiecomm.shopify.api.v1.orders.models.DraftOrder
import com.moyiecomm.shopify.api.v1.orders.models.DraftOrder.draftOrderListDecoder
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

case class GetDraftOrderList(
    limit: Option[Int],
    sinceId: Option[Long],
    status: Option[String],
    updatedAtMax: Option[ZonedDateTime],
    updatedAtMin: Option[ZonedDateTime]
)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[DraftOrder]]()(draftOrderListDecoder) {
  override def path: String = {
    val parameters: String = {
      val dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:mm:ssxxx")
      val updatedAtMaxPara  = updatedAtMax.map(_.format(dateTimeFormatter)).map(str => s"updated_at_max=$str")
      val updatedAtMinPara  = updatedAtMin.map(_.format(dateTimeFormatter)).map(str => s"updated_at_min=$str")
      val limitPara         = limit.map(str => s"limit=$str")
      val sinceIdPara       = sinceId.map(str => s"sinceId=$str")
      val statusPara        = status.map(str => s"status=$str")
      Seq(updatedAtMaxPara, updatedAtMinPara, limitPara, sinceIdPara, statusPara).flatten
        .mkString("&")
    }
    Seq("/draft_orders.json", parameters).mkString("?")
  }
}
