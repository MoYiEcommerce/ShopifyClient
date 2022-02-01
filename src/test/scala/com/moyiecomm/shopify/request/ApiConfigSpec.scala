package com.moyiecomm.shopify.request

import com.moyiecomm.shopify.UnitSpec
import com.typesafe.config.ConfigFactory

class ApiConfigSpec extends UnitSpec {
  "ApiConfig" should "load value from config file" in {
    val apiConfig = ApiConfig.load(ConfigFactory.load().getConfig("shopify"))

    apiConfig.pathPrefix should be("/admin/api/admin_api_version")
  }
}
