package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.Collection
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import Collection.{customCollectionEncoder, collectionDecoder}

case class UpdateCustomCollectionById(customCollection: Collection)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Collection, Collection](customCollection)(
      customCollectionEncoder,
      collectionDecoder
    ) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(customCollection.id.nonEmpty, "custom collection id [must not] be None")
    s"/custom_collections/${customCollection.id.getOrElse("")}.json"
  }
}
