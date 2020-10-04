package com.interview.salesTax;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.interview.salesTax.input.InputParser;
import com.interview.salesTax.product.Product;
import com.interview.salesTax.product.ProductFactory;
import com.interview.salesTax.receipt.Receipt;

@RunWith(SpringJUnit4ClassRunner.class)
public class InputParserTest
{

	@InjectMocks
	private InputParser inputParser;

	@Mock
	private ProductFactory productFactory;

	@Mock
	private Product product;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
		when(productFactory.createProduct(anyString(),any(BigDecimal.class),anyBoolean())).thenCallRealMethod();
    }

	@Test
	public void testParseMethod() throws IOException
	{
		Receipt receipt = inputParser.parse("D:\\workspace\\eclipse-workspace\\SalesTaxAggregator_Spring\\SalesTaxAggregator\\src\\main\\resources\\input1.txt");
		
		assertEquals(3, receipt.getReceiptLineItems().size());
		
	}
}
