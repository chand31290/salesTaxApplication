package com.boku.interview.salesTax.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.boku.interview.salesTax.product.Product;
import com.boku.interview.salesTax.product.ProductFactory;
import com.boku.interview.salesTax.receipt.Receipt;
import com.boku.interview.salesTax.receipt.ReceiptLineItem;

@Component
@Scope(scopeName = "prototype")
public class InputParser implements Parser
{
	private Receipt receipt;

	private static final String IMPORTED = "imported";

	private static final String RECIPT_LINE_REGEX = "(\\d+)\\s((\\w+\\s)+)at\\s(\\d+.\\d+)";

	private static final Pattern pattern = Pattern.compile(RECIPT_LINE_REGEX);
	
	@Autowired
	private ProductFactory productFactory;

	@Override
	public Receipt parse(String fileName) throws IOException
	{
		if (fileName == null)
			throw new IllegalArgumentException("Receipt Line cannot be empty");

		List<ReceiptLineItem> receiptLineItems = constructReceiptLineItems(fileName);

		this.receipt = new Receipt(receiptLineItems);
		
		return receipt;

	}

	private List<ReceiptLineItem> constructReceiptLineItems(String fileName) throws IOException
	{

		List<ReceiptLineItem> receiptLineItems = new ArrayList<ReceiptLineItem>();

		String receiptLine;

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName)))
		{

			while ((receiptLine = bufferedReader.readLine()) != null)
			{
				Matcher matcher = parseLine(receiptLine);

				String productDescription = matcher.group(2).trim();

				boolean isImported = productDescription.contains(IMPORTED);

				BigDecimal price = new BigDecimal(matcher.group(4));

				Product product = productFactory.createProduct(productDescription, price, isImported);

				ReceiptLineItem receiptLineItem = new ReceiptLineItem(product, Integer.valueOf(matcher.group(1)));

				receiptLineItems.add(receiptLineItem);
			}

		}

		return receiptLineItems;
	}

	public Matcher parseLine(String description)
	{
		Matcher matcher = pattern.matcher(description);
		matcher.find();
		return matcher;
	}

}
