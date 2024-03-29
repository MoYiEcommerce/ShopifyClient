package com.moyiecomm.shopify.api.v1.shippingFulfillment

import com.moyiecomm.shopify.api.v1.customers.models.Address
import com.moyiecomm.shopify.api.v1.shared.models.LineItem
import com.moyiecomm.shopify.api.v1.shippingFulfillment.FulfillmentOrder._

case class FulfillmentOrder(
    assigned_location_id: Long,
    destination: Address,
    delivery_method: DeliveryMethod,
    fulfill_at: Long,
    fulfillment_holds: List[FulfillmentHolds],
    id: Long,
    international_duties: DutyName,
    line_items: List[LineItem],
    order_id: Long,
    request_status: String,
    shop_id: Long,
    status: String,
    supported_actions: List[String],
    merchant_requests: List[MerchantRequest],
    assigned_location: Address
)

object FulfillmentOrder {
  case class DeliveryMethod()
  case class FulfillmentHolds()
  case class DutyName()
  case class MerchantRequest()
}
