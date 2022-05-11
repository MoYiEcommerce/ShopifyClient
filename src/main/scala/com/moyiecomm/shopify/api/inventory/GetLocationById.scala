package com.moyiecomm.shopify.api.inventory

import com.moyiecomm.shopify.api.inventory.models.Location
import com.moyiecomm.shopify.api.inventory.models.Location.locationDecoder
import com.moyiecomm.shopify.api.shared.GetItemRequest
import com.moyiecomm.shopify.request.ApiConfig

case class GetLocationById(locationId: Long)(implicit val apiConfig: ApiConfig)
    extends GetItemRequest[Location]()(locationDecoder) {
  override def path: String = s"/locations/$locationId.json"
}
