package com.interview.salesTax.product;

import java.math.BigDecimal;

public class Book extends Product
{
	public Book(String name, boolean importCategory, BigDecimal price)
	{
		super(name, importCategory, ProductCategory.BOOK, price);
	}

}
