package com.moyiecomm.shopify.api.json

import io.circe.Decoder
import io.circe.Encoder
import io.circe.Json
import io.circe.syntax.EncoderOps

trait CustomizedBaseTypeEncoder {
  implicit val doubleEncoder: Encoder[Double] = new Encoder[Double] {
    override def apply(a: Double): Json = a.toString.asJson
  }

  implicit val optionStringDecoder: Decoder[Option[String]] = Decoder.decodeOption[String].map {
    case Some(value) =>
      if (value.isBlank || value.isEmpty) {
        None
      } else {
        Some(value)
      }
    case None => None
  }
}
