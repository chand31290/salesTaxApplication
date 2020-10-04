package com.boku.interview.salesTax.product;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.boku.interview.salesTax.CategoryFinder;

/**
 * Create appropriate product on the basis of productDescription
 * 
 * @author Chandan
 *
 */

@Component
public class ProductFactory
{
	public Product createProduct(String productDescription, BigDecimal price, boolean isImported)
	{

		Product product = null;

		ProductCategory productCategory = CategoryFinder.getInstance().getCategoryFor(productDescription.toLowerCase());

		if (productCategory.equals(ProductCategory.BOOK))
		{
			product = new Book(productDescription, isImported, price);
		} 
		else if (productCategory.equals(ProductCategory.FOOD))
		{
			product = new Food(productDescription, isImported, price);
		} 
		else if (productCategory.equals(ProductCategory.MEDICALS))
		{
			product = new Medicals(productDescription, isImported, price);
		} 
		else
		{
			product = new Other(productDescription, isImported, price);
		}

		return product;
	}
}
