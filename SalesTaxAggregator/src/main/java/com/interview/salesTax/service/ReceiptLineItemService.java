package com.interview.salesTax.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.salesTax.Utils;
import com.interview.salesTax.product.Product;
import com.interview.salesTax.receipt.ReceiptLineItem;
import com.interview.salesTax.tax.TaxCalculator;

@Service
public class ReceiptLineItemService
{
	@Autowired
	private TaxCalculator taxCalculator;
	
	@Autowired
	private Utils utils;

	/**
	 * Calculate the product total in this receipt line
	 * 
	 * @return
	 */
	public ReceiptLineItem caculateItemDetails(ReceiptLineItem receiptLineItem)
	{
		Product product = receiptLineItem.getProduct();

		BigDecimal totalNonTaxedPrice = new BigDecimal(receiptLineItem.getQuantity()).multiply(product.getPrice());

		BigDecimal totalTaxAmount = utils
				.setToStandardPrecision(taxCalculator.calculateTax(totalNonTaxedPrice, product));

		BigDecimal totalPrice = totalNonTaxedPrice.add(totalTaxAmount);

		receiptLineItem.setTotalPrice(totalPrice);

		receiptLineItem.setTotalTaxAmount(totalTaxAmount);

		return receiptLineItem;
	}

	public TaxCalculator getTaxCalculator()
	{
		return taxCalculator;
	}

	public void setTaxCalculator(TaxCalculator taxCalculator)
	{
		this.taxCalculator = taxCalculator;
	}
}
