package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.Collection
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import Collection.{customCollectionEncoder, collectionDecoder}

case class UpdateCustomCollectionById(customCollection: Collection)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Collection, Collection](customCollection) {
  override def method: Method = Method.PUT

  override def path: String = s"/custom_collections/${customCollection.id}.json"
}
