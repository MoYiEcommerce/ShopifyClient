package com.moyiecomm.shopify.api.products.requests

import com.moyiecomm.shopify.api.products.Collect
import com.moyiecomm.shopify.api.products.requests.AddProductToCollection._
import com.moyiecomm.shopify.request.ApiRequest.Entity
import com.moyiecomm.shopify.request.{ApiConfig, ShopifyRequest}
import sttp.client3.circe._
import io.circe.syntax._
import io.circe.generic.auto._
import io.circe.{Encoder, Json}
import sttp.model.Method
import Collect.collectDecoder

case class AddProductToCollection(body: Entity[ProductToCollect])(implicit val apiConfig: ApiConfig)
    extends ShopifyRequest[ProductToCollect, Collect] {
  override def method: Method = Method.POST
  override def path: String   = "/collects.json"
}

object AddProductToCollection {
  case class ProductToCollect(productId: Long, collectionId: Long)
  implicit val productToCollectEncoder: Encoder[ProductToCollect] = new Encoder[ProductToCollect] {
    override def apply(a: ProductToCollect): Json = Json.obj(
      ("collect", Json.fromJsonObject(a.asJsonObject))
    )
  }
}
