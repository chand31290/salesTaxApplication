package com.interview.salesTax.receipt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interview.salesTax.input.InputParser;

@Component
public class ReceiptFactory
{
	@Autowired
	private InputParser inputParser;

	public Receipt createReceiptFromFile(String filePath) throws IOException
	{
		return inputParser.parse(filePath);

	}
}
