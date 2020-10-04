package com.interview.salesTax.tax;

import java.math.BigDecimal;

import com.interview.salesTax.product.Product;

public interface TaxCalculator
{
	BigDecimal calculateTax(BigDecimal amount, Product product);
}
