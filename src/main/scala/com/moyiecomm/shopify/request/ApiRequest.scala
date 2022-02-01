package com.moyiecomm.shopify.request

import com.moyiecomm.shopify.request.ApiRequest._
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
}
