package com.boku.interview.salesTax.product;

import java.math.BigDecimal;

public class Medicals extends Product
{
	public Medicals(String name, boolean importCategory, BigDecimal price)
	{
		super(name, importCategory, ProductCategory.MEDICALS, price);
	}

}