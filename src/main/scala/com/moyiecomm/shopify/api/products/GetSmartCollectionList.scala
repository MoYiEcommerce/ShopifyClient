package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.SmartCollection
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import SmartCollection.smartCollectionListDecoder

case class GetSmartCollectionList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[SmartCollection]]()(smartCollectionListDecoder) {
  override def path: String = s"/smart_collections.json"
}
