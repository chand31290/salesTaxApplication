package com.boku.interview.salesTax.tax;

import java.math.BigDecimal;

import com.boku.interview.salesTax.product.Product;

public interface Tax
{
	BigDecimal getTaxRate();
	
	BigDecimal applyTax(BigDecimal amount, Product product);
}
