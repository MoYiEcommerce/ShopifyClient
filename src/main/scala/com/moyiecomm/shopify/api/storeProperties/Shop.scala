package com.moyiecomm.shopify.api.storeProperties

case class Shop(
    address1: String,
    address2: String,
    checkoutApiSupported: Boolean,
    city: String,
    country: String,
    countryCode: String,
    countryName: String,
    countryTaxes: Boolean,
    createdAt: Long,
    customerEmail: String,
    currency: String,
    domain: String,
    enabledPresentmentCurrencies: List[String],
    eligibleForCardReaderGiveaway: Boolean,
    eligibleForPayments: Boolean,
    email: String,
    googleAppsDomain: String,
    googleAppsLoginEnabled: Boolean,
    hasDiscounts: Boolean,
    hasGiftCards: Boolean,
    hasStorefront: Boolean,
    ianaTimezone: String,
    id: Long,
    latitude: Double,
    longitude: Double,
    moneyFormat: String,
    moneyInEmailsFormat: String,
    moneyWithCurrencyFormat: String,
    moneyWithCurrencyInEmailsFormat: String,
    multiLocationEnabled: Boolean,
    myshopifyDomain: String,
    name: String,
    passwordEnabled: Boolean,
    phone: String,
    planDisplayName: String,
    preLaunchEnabled: Boolean,
    cookieConsentLevel: String,
    planName: String,
    primaryLocale: String,
    province: String,
    provinceCode: String,
    requiresExtraPaymentsAgreement: Boolean,
    setupRequired: Boolean,
    shopOwner: String,
    source: String,
    taxesIncluded: Boolean,
    taxShipping: Boolean,
    timezone: String,
    updatedAt: Long,
    weightUnit: String,
    zip: String
)
