package com.interview.salesTax;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import com.interview.salesTax.service.SalesTaxService;

@SpringBootApplication
@Profile("!test")
public class SalesTaxAggregatorApplication implements CommandLineRunner
{

	@Autowired
	private SalesTaxService salesTaxService;

	public static void main(String[] args)
	{
		SpringApplication.run(SalesTaxAggregatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		if (args.length == 0)
		{
			System.out.println("No input file specified");
			System.out.println("Usage: java -jar SalesTaxAggregator.jar filename(s)");
			System.out.println("example: java -jar SalesTaxAggregator.jar input1.txt input2.txt");
			System.exit(-1);
		}

		for (String arg : args)
		{
			try
			{
				salesTaxService.processFile(arg);
			} 
			catch (IOException e)
			{
				System.err.println("Input File Does not exist");
				e.printStackTrace();
			}
			catch (Exception e)
			{
				System.err.println("System is down. Please contace IT support.");
				e.printStackTrace();
			}
			
		}

	}
}
