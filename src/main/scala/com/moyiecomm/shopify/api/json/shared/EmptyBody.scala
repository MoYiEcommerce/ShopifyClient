package com.moyiecomm.shopify.api.json.shared

import io.circe.Decoder
import io.circe.Decoder.Result
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json

case object EmptyBody {
  val emptyBodyEncoder: Encoder[EmptyBody.type] = new Encoder[EmptyBody.type] {
    override def apply(a: EmptyBody.type): Json = Json.fromString("")
  }

  val emptyBodyDecoder: Decoder[EmptyBody.type] = new Decoder[EmptyBody.type] {
    override def apply(c: HCursor): Result[EmptyBody.type] = Right(EmptyBody)
  }
}
