package com.moyiecomm.shopify.api.shippingFulfillment

import com.moyiecomm.shopify.api.customers.Address
import com.moyiecomm.shopify.api.orders.LineItem
import com.moyiecomm.shopify.api.orders.Receipt

case class Fulfillment(
    createdAt: Long,
    id: Long,
    lineItems: List[LineItem],
    locationId: Long,
    name: String,
    notifyCustomer: Boolean,
    orderId: Long,
    originAddress: Address,
    receipt: Receipt,
    service: String,
    shipmentStatus: String,
    status: String,
    trackingCompany: String,
    tracking_numbers: List[String],
    trackingUrls: List[String],
    updatedAt: Long,
    variantInventoryManagement: String
)
