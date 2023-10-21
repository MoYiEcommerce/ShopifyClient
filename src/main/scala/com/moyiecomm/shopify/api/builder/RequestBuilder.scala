package com.moyiecomm.shopify.api.builder

import io.circe
import io.circe.{Decoder, Encoder, Json}
import sttp.client3.{IsOption, Request, RequestT, ResponseException, basicRequest}
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

  def deleteRequest(uri: Uri): Request[Either[String, String], Any] =
    basicRequest
      .delete(uri)

  def countRequest(uri: Uri): Request[Either[ResponseException[String, circe.Error], Int], Any] =
    getRequest[Int](uri)

  def getListRequest[Rep](uri: Uri)(implicit
      repBodyDecoder: Decoder[Rep]
  ): Request[Either[ResponseException[String, circe.Error], List[Rep]], Any] = getRequest[List[Rep]](uri)
}
