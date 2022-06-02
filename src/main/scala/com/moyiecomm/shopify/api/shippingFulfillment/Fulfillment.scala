package com.moyiecomm.shopify.api.shippingFulfillment

import com.moyiecomm.shopify.api.{CirceConfig, CustomizedCollectionCodec}
import com.moyiecomm.shopify.api.customers.models.Address
import com.moyiecomm.shopify.api.shared.models.{LineItem, Receipt}
import io.circe._
import io.circe.generic.extras.semiauto._

import java.time.ZonedDateTime

case class Fulfillment(
    id: Option[Long],
    orderId: Option[Long],
    lineItems: List[LineItem],
    locationId: Option[Long],
    name: Option[String],
    notifyCustomer: Option[Boolean],
    originAddress: Option[Address],
    receipt: Option[Receipt],
    service: Option[String],
    shipmentStatus: Option[String],
    status: Option[String],
    trackingCompany: Option[String],
    trackingNumbers: List[String],
    trackingUrls: List[String],
    variantInventoryManagement: Option[String],
    createdAt: Option[ZonedDateTime],
    updatedAt: Option[ZonedDateTime]
)

object Fulfillment extends CirceConfig with CustomizedCollectionCodec {
  val fulfillmentEncoder: Encoder[Fulfillment] = {
    implicit val addressEncoder: Encoder[Address] = deriveConfiguredEncoder[Address]
    deriveConfiguredEncoder[Fulfillment].mapJson(json =>
      Json.obj(("fulfillment", json.dropNullValues.dropEmptyValues.dropEmptyString.deepDropNullValues))
    )
  }

  val fulfillmentDecoder: Decoder[Fulfillment] = {
    implicit val addressDecoder: Decoder[Address] = deriveConfiguredDecoder[Address]
    deriveConfiguredDecoder[Fulfillment].prepare(_.downField("fulfillment"))
  }
}
