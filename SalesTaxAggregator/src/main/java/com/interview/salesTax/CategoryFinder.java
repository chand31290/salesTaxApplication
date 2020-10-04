package com.interview.salesTax;

import java.util.HashMap;
import java.util.Map;

import com.interview.salesTax.product.ProductCategory;

/**
 * Singleton Instance to map products to appropriate categories
 * 
 * @author Chandan
 *
 */
public class CategoryFinder
{
	private static Map<String, ProductCategory> itemsByCategories;

	private static CategoryFinder instance;
	
	public static CategoryFinder getInstance()
	{
		if (instance == null)
		{
			instance = new CategoryFinder();
		}
		return instance;
	}

	private CategoryFinder()
	{
		itemsByCategories = new HashMap<String, ProductCategory>();
		itemsByCategories.put("book", ProductCategory.BOOK);
		itemsByCategories.put("chocolate", ProductCategory.FOOD);
		itemsByCategories.put("chocolates", ProductCategory.FOOD);
		itemsByCategories.put("CD", ProductCategory.OTHERS);
		itemsByCategories.put("perfume", ProductCategory.OTHERS);
		itemsByCategories.put("pills", ProductCategory.MEDICALS);

	}

	public void addProduct(String item, ProductCategory productCategory)
	{
		itemsByCategories.put(item, productCategory);
	}

	public void removeProduct(String productName)
	{
		if (itemsByCategories.containsKey(productName))
			itemsByCategories.remove(productName);
	}

	/**
	 * Determine category of product based on the keywords in productDescription
	 * 
	 * @param productDescription name of the product
	 * @return category of the product if found else default value
	 */
	public ProductCategory getCategoryFor(String productDescription)
	{
		String[] productKeyWords = productDescription.split(" ");
		ProductCategory productCategory = ProductCategory.OTHERS;
		for (int keyWordIndex = 0; keyWordIndex < productKeyWords.length; keyWordIndex++)
		{
			if (itemsByCategories.containsKey(productKeyWords[keyWordIndex]))
			{
				productCategory = itemsByCategories.get(productKeyWords[keyWordIndex]);
			}
		}
		return productCategory;
	}
}
