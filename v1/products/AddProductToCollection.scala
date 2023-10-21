package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.AddProductToCollection.ProductToCollect
import com.moyiecomm.shopify.api.v1.products.models.Collect
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import io.circe.{Encoder, Json}
import io.circe.generic.extras.semiauto._
import io.circe.syntax._
import sttp.model.Method
import AddProductToCollection.productToCollectEncoder
import Collect.collectDecoder
import com.moyiecomm.shopify.api.json.CirceConfig

case class AddProductToCollection(productToCollect: ProductToCollect)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[ProductToCollect, Collect](productToCollect)(
      productToCollectEncoder,
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
