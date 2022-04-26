package com.moyiecomm.shopify.api.customers.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._

case class CustomerInvite(
    to: String,
    from: String,
    subject: String,
    customMessage: Option[String],
    bcc: List[String]
)

object CustomerInvite extends CirceConfig {
  val customerInviteDecoder: Decoder[CustomerInvite] = new Decoder[CustomerInvite] {
    override def apply(c: HCursor): Result[CustomerInvite] = c.get[CustomerInvite]("customer_invite")(deriveConfiguredDecoder)
  }
}
