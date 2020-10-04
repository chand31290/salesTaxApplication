package com.boku.interview.salesTax.tax;

import java.math.BigDecimal;

import com.boku.interview.salesTax.product.Product;

public interface TaxCalculator
{
	BigDecimal calculateTax(BigDecimal amount, Product product);
}
