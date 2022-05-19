package com.moyiecomm.shopify.api

import io.circe.Decoder.Result
import io.circe.{Decoder, HCursor}

trait CustomizedStringMapDecoder {
  implicit val stringMapDecoder: Decoder[Map[String, String]] = new Decoder[Map[String, String]] {
    override def apply(c: HCursor): Result[Map[String, String]] = {
      c.key match {
        case Some(_) => c.value.as[Map[String, String]]
        case None    => Right(Map.empty)
      }
    }
  }
}
