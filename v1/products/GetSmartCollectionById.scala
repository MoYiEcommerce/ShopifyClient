package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.SmartCollection
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import SmartCollection.smartCollectionDecoder

case class GetSmartCollectionById(smartCollectionId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[SmartCollection]()(smartCollectionDecoder) {
  override def path: String = s"/smart_collections/$smartCollectionId.json"
}
