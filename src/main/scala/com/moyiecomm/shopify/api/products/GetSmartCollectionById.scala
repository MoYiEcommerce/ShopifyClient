package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.SmartCollection
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import SmartCollection.smartCollectionDecoder

case class GetSmartCollectionById(smartCollectionId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[SmartCollection]()(smartCollectionDecoder) {
  override def path: String = s"/smart_collections/$smartCollectionId.json"
}
