package com.moyiecomm.shopify.api.access.models

import com.moyiecomm.shopify.api.CirceConfig
import io.circe.Decoder.Result
import io.circe._
import io.circe.generic.extras.semiauto._

case class AccessScope(handle: String)

object AccessScope extends CirceConfig {
  val accessScopesDecoder: Decoder[List[AccessScope]] = {
    implicit val accessScopeDecoder: Decoder[AccessScope] = deriveConfiguredDecoder[AccessScope]
    new Decoder[List[AccessScope]] {
      override def apply(c: HCursor): Result[List[AccessScope]] = c.get[List[AccessScope]]("access_scopes")
    }
  }
}
