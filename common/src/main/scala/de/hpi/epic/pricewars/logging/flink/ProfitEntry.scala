package de.hpi.epic.pricewars.logging.flink

import de.hpi.epic.pricewars.logging.base.{MerchantIDEntry, TimestampEntry, ValueEntry}
import de.hpi.epic.pricewars.logging.marketplace.BuyOfferEntry
import de.hpi.epic.pricewars.logging.producer.Order
import de.hpi.epic.pricewars.types._

/**
  * Created by Jan on 31.01.2017.
  */
case class ProfitEntry (merchant_id: Token, profit: Currency, timestamp: Timestamp) extends MerchantIDEntry
  with TimestampEntry with ValueEntry[Currency] {
  override def value: Currency = profit
}

object ProfitEntry {
  def from(entry: RevenueEntry): ProfitEntry =
    new ProfitEntry(entry.merchant_id, entry.value, entry.timestamp)
  def from(order: Order): ProfitEntry =
    new ProfitEntry(order.merchant_id, -1 * order.billing_amount, order.timestamp)
  def from(entry: BuyOfferEntry): ProfitEntry =
    new ProfitEntry(entry.merchant_id, entry.amount * entry.price, entry.timestamp)
  def from(entry: HoldingCostEntry): ProfitEntry =
    new ProfitEntry(entry.merchant_id, -1 * entry.cost, entry.timestamp)
}
