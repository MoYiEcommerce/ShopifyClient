package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.CirceConfig
import com.moyiecomm.shopify.api.products.AddProductToCollection.ProductToCollect
import com.moyiecomm.shopify.api.products.models.Collect
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import io.circe.{Encoder, Json}
import io.circe.generic.extras.semiauto._
import io.circe.syntax._
import sttp.client3.circe._
import sttp.model.Method
import AddProductToCollection.productToCollectEncoder
import Collect.collectDecoder

case class AddProductToCollection(productToCollect: ProductToCollect)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ProductToCollect, Collect](productToCollect)(
      circeBodySerializer(productToCollectEncoder),
      collectDecoder
    ) {
  override def method: Method = Method.POST
  override def path: String   = "/collects.json"
}

object AddProductToCollection extends CirceConfig {
  case class ProductToCollect(productId: Long, collectionId: Long)
  implicit val productToCollectEncoder: Encoder[ProductToCollect] = new Encoder[ProductToCollect] {
    override def apply(a: ProductToCollect): Json = Json.obj(
      ("collect", Json.fromJsonObject(a.asJsonObject(deriveConfiguredEncoder)))
    )
  }
}
