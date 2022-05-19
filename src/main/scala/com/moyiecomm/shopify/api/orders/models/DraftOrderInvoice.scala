package com.moyiecomm.shopify.api.orders.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.syntax._
import io.circe.{Decoder, Encoder, HCursor, Json}

case class DraftOrderInvoice(to: String, from: String, bcc: List[String], subject: String, customMessage: String)

object DraftOrderInvoice extends CirceConfig {
  val draftOrderInvoiceEncoder: Encoder[DraftOrderInvoice] = new Encoder[DraftOrderInvoice] {
    override def apply(a: DraftOrderInvoice): Json = Json.obj(
      (
        "draft_order_invoice",
        Json
          .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
          .dropNullValues
          .dropEmptyValues
          .deepDropNullValues
          .dropEmptyString
      )
    )
  }

  val draftOrderInvoiceDecoder: Decoder[DraftOrderInvoice] = new Decoder[DraftOrderInvoice] {
    override def apply(c: HCursor): Result[DraftOrderInvoice] =
      c.get[DraftOrderInvoice]("draft_order_invoice")(deriveConfiguredDecoder)
  }
}
