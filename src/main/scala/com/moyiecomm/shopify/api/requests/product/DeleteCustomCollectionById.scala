package com.moyiecomm.shopify.api.requests.product

import com.moyiecomm.shopify.api.ApiResponse.Ignored
import com.moyiecomm.shopify.api.builder.RequestBuilder
import com.moyiecomm.shopify.api.requests.{DeleteRequest, ShopifyRequest}
import com.moyiecomm.shopify.api.requests.ShopifyRequest.Config
import io.circe
import sttp.client3.{Request, ResponseException, UriContext}

case class DeleteCustomCollectionById(id: Long, override val config: Config) extends DeleteRequest(config) {
  override val path: String = s"custom_collections/$id.json"

}
