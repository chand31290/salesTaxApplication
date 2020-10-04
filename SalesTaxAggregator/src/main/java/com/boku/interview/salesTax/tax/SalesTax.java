package com.boku.interview.salesTax.tax;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.boku.interview.salesTax.Utils;
import com.boku.interview.salesTax.product.Product;
import com.boku.interview.salesTax.product.ProductCategory;

@Component
public class SalesTax implements Tax
{
	@Value("${tax.sales.rate}")
	private BigDecimal taxRate;
	
	@Autowired
	private Utils utils;

	@Override
	public BigDecimal getTaxRate()
	{
		return taxRate;
	}

	@Override
	public BigDecimal applyTax(BigDecimal amount, Product product)
	{
		if (ProductCategory.OTHERS != product.getProductCategory())
		{
			return BigDecimal.ZERO;
		}
		
		return utils.setToStandardPrecision(amount.multiply(getTaxRate()).divide(new BigDecimal(100)));
	}

}
