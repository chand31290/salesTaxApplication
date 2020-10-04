package com.boku.interview.salesTax.receipt;

import java.math.BigDecimal;

import com.boku.interview.salesTax.product.Product;

public class ReceiptLineItem
{
	private Product product;

	private int quantity;

	private BigDecimal totalPrice;

	private BigDecimal totalTaxAmount;

	public ReceiptLineItem()
	{
	}

	public ReceiptLineItem(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @return totalTaxAmount applicable on this product purchase
	 */
	public BigDecimal getTotalTaxAmount()
	{
		return totalTaxAmount;
	}

	/**
	 * @return totalPrice for this product purchase including taxes
	 */
	public BigDecimal getTotal()
	{
		return totalPrice;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public void setTotalTaxAmount(BigDecimal totalTaxAmount)
	{
		this.totalTaxAmount = totalTaxAmount;
	}

	

}
