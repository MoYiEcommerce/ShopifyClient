package com.moyiecomm.shopify.request

import com.moyiecomm.shopify.request.ApiRequest._
import io.circe.{Encoder, Json}
import sttp.model.Method

trait ApiRequest {
  def method: Method
  def path: String
  def body: RequestEntity
  def apiConfig: ApiConfig
}

object ApiRequest {
  sealed trait RequestEntity
  case object EmptyBody           extends RequestEntity
  case class Entity[T](entity: T) extends RequestEntity

  val emptyBodyEncoder: Encoder[EmptyBody.type] = new Encoder[EmptyBody.type] {
    override def apply(a: EmptyBody.type): Json = Json.Null
  }

  Encoder.encodeZonedDateTime
}
