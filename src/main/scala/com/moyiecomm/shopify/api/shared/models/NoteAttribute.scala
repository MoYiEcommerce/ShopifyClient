package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class NoteAttribute(name: String, value: String)

object NoteAttribute extends CirceConfig {
  implicit val noteAttributeEncoder: Encoder[NoteAttribute] = deriveConfiguredEncoder[NoteAttribute]
  implicit val noteAttributeDecoder: Decoder[NoteAttribute] = deriveConfiguredDecoder[NoteAttribute]
}
