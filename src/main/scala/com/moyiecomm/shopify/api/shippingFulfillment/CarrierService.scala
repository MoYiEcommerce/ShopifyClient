package com.moyiecomm.shopify.api.shippingFulfillment

case class CarrierService(
    active: Boolean,
    callbackUrl: String,
    carrierServiceType: String,
    id: Long,
    format: String,
    name: String,
    serviceDiscovery: Boolean,
    adminGraphqlApiId: String
)
