package com.moyiecomm.shopify.api.requests.inventory

import com.moyiecomm.shopify.api.builder.GetRequest
import com.moyiecomm.shopify.api.builder.ShopifyRequest.Config
import com.moyiecomm.shopify.api.json.inventory.Location
import io.circe.Decoder

case class GetLocationById(locationId: Long, override val config: Config) extends GetRequest[Location](config) {

  override val path: String                       = s"locations/$locationId.json"
  override val responseDecoder: Decoder[Location] = Location.locationDecoder
}
