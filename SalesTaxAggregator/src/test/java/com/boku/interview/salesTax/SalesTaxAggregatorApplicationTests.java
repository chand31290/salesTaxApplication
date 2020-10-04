package com.boku.interview.salesTax;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest(classes = SalesTaxAggregatorApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class SalesTaxAggregatorApplicationTests
{

	@Test
	public void testRunWithCorrectFilePath() throws Exception
	{
		String[] args = {"D:\\workspace\\eclipse-workspace\\SalesTaxAggregator_Spring\\SalesTaxAggregator\\src\\main\\resources\\input1.txt"};
		SalesTaxAggregatorApplication.main(args);
	}
	
	@Test
	public void testRunWithInCorrectFilePath() throws Exception
	{
		String[] args = {""};
		SalesTaxAggregatorApplication.main(args);
	}
	
}
