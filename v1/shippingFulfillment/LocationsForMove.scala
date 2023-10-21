package com.moyiecomm.shopify.api.v1.shippingFulfillment

import com.moyiecomm.shopify.api.v1.shippingFulfillment.LocationsForMove.CanBeMoveToLocation

case class LocationsForMove(locationsForMove: List[CanBeMoveToLocation])

object LocationsForMove {
  case class CanBeMoveToLocation()
}
