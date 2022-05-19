package com.moyiecomm.shopify.api

import io.circe.{Encoder, Json}
import io.circe.syntax._

trait CustomizedBaseTypeEncoder {
  implicit val doubleEncoder: Encoder[Double] = new Encoder[Double] {
    override def apply(a: Double): Json = a.toString.asJson
  }
}
