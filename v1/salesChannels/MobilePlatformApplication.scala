package com.moyiecomm.shopify.api.v1.salesChannels

case class MobilePlatformApplication(
    id: Long,
    applicationId: String,
    platform: String,
    sha256CertFingerprints: String,
    enabledUniversalOrAppLinks: Boolean,
    enabled_shared_webcredentials: Boolean
)
