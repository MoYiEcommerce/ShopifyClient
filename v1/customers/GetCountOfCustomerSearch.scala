package com.moyiecomm.shopify.api.v1.customers

import com.moyiecomm.shopify.api.v1.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfCustomerSearch()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = s"/customer_saved_searches/count.json"
}
