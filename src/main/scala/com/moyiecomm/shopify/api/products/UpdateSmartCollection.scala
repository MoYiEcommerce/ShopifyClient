package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.SmartCollection
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import SmartCollection.{smartCollectionEncoder, smartCollectionDecoder}

class UpdateSmartCollection(smartCollection: SmartCollection)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[SmartCollection, SmartCollection](smartCollection) {
  override def method: Method = Method.PUT

  override def path: String = s"/smart_collections/${smartCollection.id}.json"
}
