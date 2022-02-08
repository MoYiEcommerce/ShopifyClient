package com.moyiecomm.shopify.api.products

import com.moyiecomm.shopify.api.products.models.Collection
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCustomCollectionById(id: Long)(implicit val apiConfig: ApiConfig) extends GetItemRequest[Collection] {

  override def path: String = s"/custom_collections/$id.json"

}
