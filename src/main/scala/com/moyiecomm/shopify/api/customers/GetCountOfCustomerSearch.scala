package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.shared.GetCountOfItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetCountOfCustomerSearch()(implicit val apiConfig: ApiConfig) extends GetCountOfItemRequest {
  override def path: String = s"/customer_saved_searches/count.json"
}
