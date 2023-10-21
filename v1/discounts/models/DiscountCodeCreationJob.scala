package com.moyiecomm.shopify.api.v1.discounts.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe._

import java.time.ZonedDateTime

case class DiscountCodeCreationJob(
    id: Long,
    price_rule_id: Long,
    started_at: Option[ZonedDateTime],
    completed_at: Option[ZonedDateTime],
    created_at: Option[ZonedDateTime],
    updated_at: Option[ZonedDateTime],
    status: String,
    codes_count: Int,
    imported_count: Int,
    failed_count: Int,
    logs: List[String]
)

object DiscountCodeCreationJob extends CirceConfig {
  val discountCodeCreationJobDecoder: Decoder[DiscountCodeCreationJob] = new Decoder[DiscountCodeCreationJob] {
    override def apply(c: HCursor): Result[DiscountCodeCreationJob] =
      c.get[DiscountCodeCreationJob]("discount_code_creation")(deriveConfiguredDecoder)
  }
}
