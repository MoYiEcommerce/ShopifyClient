package com.moyiecomm.shopify.api.salesChannels

import com.moyiecomm.shopify.api.orders.Transaction
import com.moyiecomm.shopify.api.salesChannels.Payment._

case class Payment(
    creditCard: CreditCard,
    id: Long,
    paymentProcessingErrorMessage: String,
    nextAction: NextAction,
    transaction: Transaction,
    uniqueToken: String
)

object Payment {
  case class CreditCard()
  case class NextAction()
}
