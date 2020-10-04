package com.interview.salesTax.receipt;

import java.math.BigDecimal;
import java.util.List;

public class Receipt
{
	private List<ReceiptLineItem> receiptLineItems;

	private BigDecimal totalAmount;

	private BigDecimal totalTax;

	public Receipt()
	{
	}

	public Receipt(List<ReceiptLineItem> receiptLineItems)
	{
		this.receiptLineItems = receiptLineItems;
	}

	public List<ReceiptLineItem> getReceiptLineItems()
	{
		return receiptLineItems;
	}

	public void setReceiptLineItems(List<ReceiptLineItem> receiptLineItems)
	{
		this.receiptLineItems = receiptLineItems;
	}

	/**
	 * @return totalAmount for this product purchase including taxes
	 */
	public BigDecimal getTotalAmount()
	{
		return totalAmount;
	}

	/**
	 * @return totalTax applicable on this purchase
	 */
	public BigDecimal getTotalTax()
	{
		return totalTax;
	}

	public void setTotalAmount(BigDecimal totalAmount)
	{
		this.totalAmount = totalAmount;
	}

	public void setTotalTax(BigDecimal totalTax)
	{
		this.totalTax = totalTax;
	}

}
