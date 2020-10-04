package com.boku.interview.salesTax.product;

import java.math.BigDecimal;

public class Food extends Product
{
	public Food(String name, boolean importCategory, BigDecimal price)
	{
		super(name, importCategory, ProductCategory.FOOD, price);
	}

}