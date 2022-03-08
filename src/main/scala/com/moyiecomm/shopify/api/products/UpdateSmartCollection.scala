package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.SmartCollection
import com.moyiecomm.shopify.api.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import sttp.client3.circe._
import SmartCollection.{smartCollectionEncoder, smartCollectionDecoder}

case class UpdateSmartCollection(smartCollection: SmartCollection)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[SmartCollection, SmartCollection](smartCollection)(
      circeBodySerializer(smartCollectionEncoder),
      smartCollectionDecoder
    ) {
  override def method: Method = Method.PUT

  override def path: String = {
    require(smartCollection.id.nonEmpty, "Smart Collection id must not be empty")
    s"/smart_collections/${smartCollection.id.getOrElse("")}.json"
  }
}
