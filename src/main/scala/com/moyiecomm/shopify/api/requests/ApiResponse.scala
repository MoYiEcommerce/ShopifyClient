package com.moyiecomm.shopify.api

package object ApiResponse {
  type ApiResult[Rep] = Either[Error, Rep]

  case class ApiResponse[Rep](entity: ApiResult[Rep]) {
    def isError: Boolean = entity.isLeft

    def mapError[A](f: Error => A): Either[A, Rep] = entity.left.map(f)

    def mapEntity[E](f: Rep => E): Either[Error, E] = entity.map(f)
  }

  case class Error(message: String, errorCode: String)
}
