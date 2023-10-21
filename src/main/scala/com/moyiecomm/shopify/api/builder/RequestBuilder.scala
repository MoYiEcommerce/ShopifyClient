package com.moyiecomm.shopify.api.builder

import com.moyiecomm.shopify.api.ApiResponse.Ignored
import com.moyiecomm.shopify.api.json.shared.EmptyBody
import io.circe
import io.circe.{Decoder, Encoder}
import sttp.client3.{Request, ResponseException, basicRequest}
import sttp.client3.circe._
import sttp.model.{MediaType, Uri}

object RequestBuilder {
  def getRequest[Rep](
      uri: Uri
  )(implicit repBodyDecoder: Decoder[Rep]): Request[Either[ResponseException[String, circe.Error], Rep], Any] =
    basicRequest
      .get(uri)
      .contentType(MediaType.ApplicationJson.charset("UTF-8"))
      .response(asJson[Rep])

  def postRequest[Req, Rep](uri: Uri, body: Req)(implicit
      reqBodyEncoder: Encoder[Req],
      repBodyDecoder: Decoder[Rep]
  ): Request[Either[ResponseException[String, circe.Error], Rep], Any] =
    basicRequest
      .post(uri)
      .contentType(MediaType.ApplicationJson.charset("UTF-8"))
      .body(body)
      .response(asJson[Rep])

  def putRequest[Req, Rep](uri: Uri, body: Req)(implicit
      reqBodyEncoder: Encoder[Req],
      repBodyDecoder: Decoder[Rep]
  ): Request[Either[ResponseException[String, circe.Error], Rep], Any] =
    basicRequest
      .put(uri)
      .contentType(MediaType.ApplicationJson.charset("UTF-8"))
      .body(body)
      .response(asJson[Rep])

  def deleteRequest(uri: Uri): Request[Either[ResponseException[String, circe.Error], Ignored], Any] = {
    implicit val decoder: Decoder[EmptyBody.type] = EmptyBody.emptyBodyDecoder
    basicRequest.delete(uri).response(asJson[Ignored])
  }

  def countRequest(uri: Uri): Request[Either[ResponseException[String, circe.Error], Int], Any] =
    getRequest[Int](uri)

}
