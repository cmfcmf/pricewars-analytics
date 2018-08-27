package de.hpi.epic.pricewars.logging.producer

import de.hpi.epic.pricewars.logging.base.{AmountEntry, MerchantIDEntry, TimestampEntry}
import de.hpi.epic.pricewars.types._

case class Order(billing_amount: Currency, product_id: ID, name: Name, unit_price: Currency,
                 amount: Amount, merchant_id: Token, timestamp: Timestamp)
  extends MerchantIDEntry with AmountEntry with TimestampEntry
