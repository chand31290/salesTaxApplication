package com.boku.interview.salesTax.tax;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.boku.interview.salesTax.product.Product;

@Service
public class TaxCalculatorImpl implements TaxCalculator
{

	@Autowired
	private List<Tax> taxes;

	@Autowired
	private SalesTax salesTax;

	@Autowired
	private ImportDutyTax importDutyTax;


	@Override
	public BigDecimal calculateTax(BigDecimal amount, Product product)
	{

		BigDecimal taxAppliedAmount = taxes.stream().map(tax -> tax.applyTax(amount, product))
				.reduce(BigDecimal.ZERO, (taxAmtOne, taxAmtOther) -> taxAmtOne.add(taxAmtOther));

		return taxAppliedAmount;
	}

	@Bean
	public List<Tax> getTaxes()
	{
		return Arrays.asList(salesTax, importDutyTax);
	}

	public SalesTax getSalesTax()
	{
		return salesTax;
	}

	public void setSalesTax(SalesTax salesTax)
	{
		this.salesTax = salesTax;
	}

	public ImportDutyTax getImportDutyTax()
	{
		return importDutyTax;
	}

	public void setImportDutyTax(ImportDutyTax importDutyTax)
	{
		this.importDutyTax = importDutyTax;
	}

}
