package com.boku.interview.salesTax.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boku.interview.salesTax.receipt.Receipt;
import com.boku.interview.salesTax.receipt.ReceiptLineItem;

@Service
public class ReceiptService
{
	@Autowired
	ReceiptLineItemService receiptLineItemService;
	
	/**
	 * Calculate the total amount of this receipt
	 * 
	 */
	public Receipt calculateReceiptotal(Receipt receipt)
	{
		
		BigDecimal totalAmount = BigDecimal.ZERO; 
		BigDecimal totalTax = BigDecimal.ZERO; 
		
		for (ReceiptLineItem receiptLineItem : receipt.getReceiptLineItems())
		{
			ReceiptLineItem processedReceiptLineItem = receiptLineItemService.caculateItemDetails(receiptLineItem);

			totalAmount = totalAmount.add(processedReceiptLineItem.getTotal());
			totalTax = totalTax.add(processedReceiptLineItem.getTotalTaxAmount());
		}
		
		receipt.setTotalAmount(totalAmount);
		receipt.setTotalTax(totalTax);
		
		return receipt;
		
	}
	
}
