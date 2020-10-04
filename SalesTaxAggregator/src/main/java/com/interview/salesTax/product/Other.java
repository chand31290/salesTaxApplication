package com.interview.salesTax.product;

import java.math.BigDecimal;

public class Other extends Product
{
	public Other(String name, boolean importCategory, BigDecimal price)
	{
		super(name, importCategory, ProductCategory.OTHERS, price);
	}

}