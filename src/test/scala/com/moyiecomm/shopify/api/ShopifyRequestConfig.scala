package com.moyiecomm.shopify.api

import com.moyiecomm.shopify.UnitSpec
import com.moyiecomm.shopify.api.builder.ShopifyRequest
import com.typesafe.config.ConfigFactory

class ShopifyRequestConfig extends UnitSpec {
  it should "load value from config file" in {
    val shopifyConfig = ShopifyRequest.Config.load(ConfigFactory.load().getConfig("shopify"))

    shopifyConfig.apiPathPrefix should be("http://localhost/admin/api/admin_api_version")
    shopifyConfig.apiKeyId should be("api_key_id")
    shopifyConfig.apiKeySecret should be("api_key_secret")
    shopifyConfig.shopUrl should be("http://localhost")
    shopifyConfig.adminPathPrefix should be("/admin")
  }
}
