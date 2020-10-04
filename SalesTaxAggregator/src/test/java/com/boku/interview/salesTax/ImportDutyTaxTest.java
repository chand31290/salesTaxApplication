package com.boku.interview.salesTax;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boku.interview.salesTax.product.Book;
import com.boku.interview.salesTax.tax.ImportDutyTax;

@RunWith(SpringJUnit4ClassRunner.class)
public class ImportDutyTaxTest
{

	@InjectMocks
	private ImportDutyTax importDutyTax;
	
	@Mock
	private Utils utils;
	
	private Book bookProductDomestic;

	@Before
	public void init()
	{
		bookProductDomestic = new Book("book", true, new BigDecimal(12.49));
	}


	@Test
	public void applyTaxTest()
	{
		
		when(utils.setToStandardPrecision(new BigDecimal(0.50))).thenReturn(new BigDecimal(0.50));
		
		importDutyTax.setTaxRate(new BigDecimal(5));
		
		assertEquals(0 , new BigDecimal(0.50).setScale(2, RoundingMode.HALF_UP).compareTo(importDutyTax.applyTax(new BigDecimal(10), bookProductDomestic).setScale(2, RoundingMode.HALF_UP)));
	}
}
