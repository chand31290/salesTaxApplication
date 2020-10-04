package com.boku.interview.salesTax.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boku.interview.salesTax.product.Product;
import com.boku.interview.salesTax.receipt.Receipt;
import com.boku.interview.salesTax.receipt.ReceiptFactory;
import com.boku.interview.salesTax.receipt.ReceiptLineItem;

@Service
public class SalesTaxService
{

	@Autowired
	private ReceiptService receiptService;
	
	@Autowired
	private ReceiptFactory receiptFactory;
	
	public void processFile(String filePath) throws IOException
	{
		Receipt receipt = receiptFactory.createReceiptFromFile(filePath);
		
		Receipt processedReceipt = receiptService.calculateReceiptotal(receipt);
		
		printDetails(processedReceipt);
		
	}
	
	public void printDetails(Receipt receipt)
	{
		for(ReceiptLineItem receiptLineItem : receipt.getReceiptLineItems())
		{
			Product product = receiptLineItem.getProduct();
			
			System.out.println(receiptLineItem.getQuantity() + " " + product.getName() + ": " + receiptLineItem.getTotal() );
		}
		
		System.out.println("Sales Taxes: " + receipt.getTotalTax());
		
		System.out.println("Total: " + receipt.getTotalAmount());
	}
	
}
