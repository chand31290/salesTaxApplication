package com.boku.interview.salesTax.input;

import java.io.IOException;

import com.boku.interview.salesTax.receipt.Receipt;

public interface Parser
{

	Receipt parse(String fileName) throws IOException;

}
