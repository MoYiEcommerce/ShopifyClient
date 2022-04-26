package com.moyiecomm.shopify.api.customers.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class AccountActivationUrl(accountActivationUrl: String)

object AccountActivationUrl extends CirceConfig {
  val accountActivationUrlDecoder: Decoder[AccountActivationUrl] = deriveConfiguredDecoder[AccountActivationUrl]
}
