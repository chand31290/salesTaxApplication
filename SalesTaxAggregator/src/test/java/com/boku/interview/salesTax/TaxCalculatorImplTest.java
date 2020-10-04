package com.boku.interview.salesTax;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.boku.interview.salesTax.product.Book;
import com.boku.interview.salesTax.product.Other;
import com.boku.interview.salesTax.product.Product;
import com.boku.interview.salesTax.tax.ImportDutyTax;
import com.boku.interview.salesTax.tax.SalesTax;
import com.boku.interview.salesTax.tax.Tax;
import com.boku.interview.salesTax.tax.TaxCalculatorImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaxCalculatorImplTest
{

	@InjectMocks
	private TaxCalculatorImpl taxCalculatorImpl;
	
	@Mock
	private SalesTax salesTax;

	@Mock
	private ImportDutyTax importDutyTax;
	
	@Spy
	private List<Tax> taxes = new ArrayList<Tax>();
	
	private Product bookProductDomestic;
	
	private Product otherProductImported; 

	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        taxes.add(salesTax);
        taxes.add(importDutyTax);
        bookProductDomestic = new Book("book", false, new BigDecimal(12.49));
        otherProductImported = new Other("perfume", true, new BigDecimal(47.50));
    }

	@Test
	public void calculateDomesticNonOthersTaxTest()
	{
		when(salesTax.applyTax(Mockito.any(BigDecimal.class), Mockito.any(Book.class))).thenReturn(BigDecimal.ZERO);
		when(importDutyTax.applyTax(Mockito.any(BigDecimal.class), Mockito.any(Book.class))).thenReturn(BigDecimal.ZERO);
		
		assertEquals(BigDecimal.ZERO, taxCalculatorImpl.calculateTax(new BigDecimal(12.49), bookProductDomestic));
	}	
	
	@Test
	public void calculateImportedOthersTaxTest()
	{
		when(salesTax.applyTax(Mockito.any(BigDecimal.class), Mockito.any(Other.class))).thenReturn(new BigDecimal(5.46));
		when(importDutyTax.applyTax(Mockito.any(BigDecimal.class), Mockito.any(Other.class))).thenReturn(new BigDecimal(2.75));
		
		assertEquals(0 , new BigDecimal(8.21).setScale(2, RoundingMode.HALF_UP).compareTo(taxCalculatorImpl.calculateTax(new BigDecimal(54.65), otherProductImported).setScale(2, RoundingMode.HALF_UP)));
	}	

}
