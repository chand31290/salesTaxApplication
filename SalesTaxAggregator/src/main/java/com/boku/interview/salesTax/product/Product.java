package com.boku.interview.salesTax.product;

import java.math.BigDecimal;

/**
 * This abstract class will store generic product related information
 * 
 * @author Chandan 
 */
public abstract class Product
{

	private String name;

	private boolean isImported;

	private ProductCategory productCategory;

	private BigDecimal price;

	public Product(String name, boolean importCategory, ProductCategory productCategory, BigDecimal price)
	{
		this.name = name;
		this.isImported = importCategory;
		this.productCategory = productCategory;
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public boolean isImported()
	{
		return isImported;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public ProductCategory getProductCategory()
	{
		return productCategory;
	}
}
