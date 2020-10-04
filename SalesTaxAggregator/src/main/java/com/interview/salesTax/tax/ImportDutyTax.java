package com.interview.salesTax.tax;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.interview.salesTax.Utils;
import com.interview.salesTax.product.Product;

@Component
public class ImportDutyTax implements Tax
{

	@Value("${tax.importDuty.rate}")
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
		if(product.isImported())
		{
			return utils.setToStandardPrecision(amount.multiply(getTaxRate()).divide(new BigDecimal(100)));
		}
		
		return BigDecimal.ZERO;
	}

	public void setTaxRate(BigDecimal taxRate)
	{
		this.taxRate = taxRate;
	}

}
