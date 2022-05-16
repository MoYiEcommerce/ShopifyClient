package com.moyiecomm.shopify.api.orders

import com.moyiecomm.shopify.api.orders.models.AbandonedCheckout
import com.moyiecomm.shopify.api.orders.models.AbandonedCheckout.abandonedCheckoutListDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetAbandonedCheckoutList()(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[List[AbandonedCheckout]]()(abandonedCheckoutListDecoder) {
  override def path: String = "/checkouts.json"
}
