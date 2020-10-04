package com.boku.interview.salesTax.receipt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boku.interview.salesTax.input.InputParser;

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
