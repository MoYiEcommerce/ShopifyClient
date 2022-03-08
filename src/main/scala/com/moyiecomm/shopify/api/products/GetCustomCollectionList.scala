package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.Collection
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Collection.customCollectionListDecoder

case class GetCustomCollectionList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[Collection]]()(customCollectionListDecoder) {
  override def path: String = "/custom_collections.json"

}
