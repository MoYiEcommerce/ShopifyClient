package com.moyiecomm.shopify.api

import io.circe.Decoder.Result
import io.circe.{ACursor, Decoder, DecodingFailure, FailedCursor, HCursor}

trait CustomizedListDecoder {
  implicit def decodeList[A](implicit decodeA: Decoder[A]): Decoder[List[A]] = new Decoder[List[A]] {
    override def apply(c: HCursor): Result[List[A]] = tryDecode(c)

    override def tryDecode(c: ACursor): Decoder.Result[List[A]] = c match {
      case c: HCursor =>
        if (c.value.isNull)
          Right(List.empty)
        else
          Decoder.decodeList[A].apply(c) match {
            case Right(a) => Right(a)
            case Left(df) => Left(df)
          }
      case c: FailedCursor =>
        if (!c.incorrectFocus)
          Right(List.empty)
        else
          Left(DecodingFailure("[A]Option[A]", c.history))
    }
  }
}
