package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.Collection
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.client3.circe._
import sttp.model.Method
import Collection.{customCollectionEncoder, collectionDecoder}

case class CreateCustomCollection(collection: Collection)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[Collection, Collection](collection)(
      customCollectionEncoder,
      collectionDecoder
    ) {
  override def method: Method = Method.POST
  override def path: String   = "/custom_collections.json"
}
