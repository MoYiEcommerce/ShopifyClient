package com.moyiecomm.shopify.api.shippingFulfillment

case class FulfillmentService(
    adminGraphqlApiId: String,
    callbackUrl: String,
    format: String,
    fulfillmentOrdersOptIn: Boolean,
    handle: String,
    inventoryManagement: Boolean,
    locationId: Long,
    name: String,
    providerId: Long,
    requiresShippingMethod: Boolean,
    trackingSupport: Boolean
)
