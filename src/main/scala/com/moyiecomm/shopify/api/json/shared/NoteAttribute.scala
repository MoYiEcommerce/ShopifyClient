package com.moyiecomm.shopify.api.json.shared

import com.moyiecomm.shopify.api.json.CirceConfig
import io.circe._
import io.circe.generic.extras.semiauto._

case class NoteAttribute(name: String, value: String)

object NoteAttribute extends CirceConfig {
  implicit val noteAttributeEncoder: Encoder[NoteAttribute] =
    deriveConfiguredEncoder[NoteAttribute].mapJson(_.dropNullValues.dropEmptyValues.dropEmptyString)
  implicit val noteAttributeDecoder: Decoder[NoteAttribute] = deriveConfiguredDecoder[NoteAttribute]
}
