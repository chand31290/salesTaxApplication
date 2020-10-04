package com.interview.salesTax.tax;

import java.math.BigDecimal;

import com.interview.salesTax.product.Product;

public interface Tax
{
	BigDecimal getTaxRate();
	
	BigDecimal applyTax(BigDecimal amount, Product product);
}
