package com.moyiecomm.shopify.api.v1.orders.models

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe.Decoder.Result
import io.circe.generic.extras.semiauto._
import io.circe.syntax._
import io.circe._

case class DraftOrderInvoice(to: String, from: String, bcc: List[String], subject: String, customMessage: String)

object DraftOrderInvoice extends CirceConfig {
  lazy val defaultDraftOrderInvoice: DraftOrderInvoice = DraftOrderInvoice("", "", List.empty, "", "")

  val draftOrderInvoiceEncoder: Encoder[DraftOrderInvoice] = new Encoder[DraftOrderInvoice] {
    override def apply(a: DraftOrderInvoice): Json = Json.obj(
      (
        "draft_order_invoice",
        Json
          .fromJsonObject(a.asJsonObject(deriveConfiguredEncoder))
          .dropNullValues
          .dropEmptyValues
          .dropEmptyString
          .deepDropNullValues
      )
    )
  }

  val draftOrderInvoiceDecoder: Decoder[DraftOrderInvoice] = new Decoder[DraftOrderInvoice] {
    override def apply(c: HCursor): Result[DraftOrderInvoice] =
      c.get[DraftOrderInvoice]("draft_order_invoice")(deriveConfiguredDecoder)
  }
}
