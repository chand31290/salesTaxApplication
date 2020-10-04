package com.interview.salesTax.input;

import java.io.IOException;

import com.interview.salesTax.receipt.Receipt;

public interface Parser
{

	Receipt parse(String fileName) throws IOException;

}
