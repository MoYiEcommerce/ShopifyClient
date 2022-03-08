package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.Collection
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Collection.collectionDecoder

case class GetCollectionById(id: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[Collection]()(collectionDecoder) {
  override def path: String = s"/collections/$id.json"

}
