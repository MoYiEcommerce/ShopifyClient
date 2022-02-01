package com.moyiecomm.shopify.request

import com.typesafe.config.Config

case class ApiConfig(
    apiKeyId: String,
    apiKeySecret: String,
    shopUrl: String,
    adminApiVersion: String
) {
  val pathPrefix: String = s"/admin/api/$adminApiVersion"
}

object ApiConfig {
  def load(config: Config): ApiConfig = {
    val apiKeyId        = config.getString("apiKeyId")
    val apiKeySecret    = config.getString("apiKeySecret")
    val shopUrl         = config.getString("shopUrl")
    val adminApiVersion = config.getString("adminApiVersion")
    ApiConfig(
      apiKeyId = apiKeyId,
      apiKeySecret = apiKeySecret,
      shopUrl = shopUrl,
      adminApiVersion = adminApiVersion
    )
  }
}
