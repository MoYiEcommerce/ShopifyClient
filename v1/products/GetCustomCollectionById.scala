package com.moyiecomm.shopify.api.v1.products

import com.moyiecomm.shopify.api.v1.products.models.Collection
import com.moyiecomm.shopify.api.v1.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig
import Collection.collectionDecoder

case class GetCustomCollectionById(id: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[Collection]()(collectionDecoder) {

  override def path: String = s"/custom_collections/$id.json"

}
