package com.moyiecomm.shopify.api.customers

import com.moyiecomm.shopify.api.customers.Customer.Metafield
import com.moyiecomm.shopify.api.customers.Customer.SmsMarketingConsent

case class Customer(
    acceptsMarketing: Boolean,
    acceptsMarketingUpdatedAt: Long,
    addresses: List[Address],
    currency: String,
    createdAt: Long,
    defaultAddress: Address,
    email: String,
    firstName: String,
    id: Long,
    lastName: String,
    lastOrderId: Long,
    lastOrderName: String,
    metafield: Metafield,
    marketingOptInLevel: String,
    multipassIdentifier: String,
    note: String,
    ordersCount: Int,
    phone: String,
    smsMarketingConsent: SmsMarketingConsent,
    state: String,
    tags: String,
    taxExempt: Boolean,
    tax_exemptions: List[String],
    totalSpent: String,
    updatedAt: Long,
    verifiedEmail: Boolean
)

object Customer {
  case class Metafield(
      key: String,
      namespace: String,
      value: String,
      valueType: String,
      description: String
  )
  case class SmsMarketingConsent(
      state: String,
      optInLevel: String,
      consentUpdatedAt: Long,
      consentCollectedFrom: String
  )
}
