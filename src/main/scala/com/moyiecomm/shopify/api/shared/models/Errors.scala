package com.moyiecomm.shopify.api.shared.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe.{Decoder, HCursor}

case class Errors(messages: List[String])

object Errors extends CirceConfig {
  val errorsDecoder: Decoder[Errors] = new Decoder[Errors] {
    override def apply(c: HCursor): Result[Errors] = {
      val messages = c.values.toList.flatMap { values =>
        values.flatMap(_.asString)
      }
      Right(Errors(messages))
    }
  }
}
