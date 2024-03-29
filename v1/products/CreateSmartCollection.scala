package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.SmartCollection
import com.moyiecomm.shopify.api.v1.shared.UpsertItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import sttp.model.Method
import SmartCollection.{smartCollectionEncoder, smartCollectionDecoder}

case class CreateSmartCollection(smartCollection: SmartCollection)(implicit val apiConfig: ApiConfig)
    extends UpsertItemRequest[SmartCollection, SmartCollection](smartCollection)(
      smartCollectionEncoder,
      smartCollectionDecoder
    ) {
  override def method: Method = Method.POST
  override def path: String   = "/smart_collections.json"
}
