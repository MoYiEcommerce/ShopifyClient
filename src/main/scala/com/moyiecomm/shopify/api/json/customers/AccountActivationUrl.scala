package com.moyiecomm.shopify.api.json.customers

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class AccountActivationUrl(accountActivationUrl: String)

object AccountActivationUrl extends CirceConfig {
  val accountActivationUrlDecoder: Decoder[AccountActivationUrl] = deriveConfiguredDecoder[AccountActivationUrl]
}
