package com.interview.salesTax;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Utils
{

	@Value("${amount.rounding.scale}")
	private int roundingScale;

	@Value("${amount.rounding.nearest.digit}")
	private int roundingNearestDigit;

	private static final BigDecimal BIGDECIMAL_HUNDRED = new BigDecimal(100);

	/**
	 * @param amount
	 * @return round the amount to application-wise standard precision
	 */
	public BigDecimal setToStandardPrecision(BigDecimal amount)
	{
		BigDecimal amountMultipliedByHundred = amount.setScale(roundingScale, RoundingMode.HALF_UP).multiply(BIGDECIMAL_HUNDRED);
		
		BigDecimal correction = amountMultipliedByHundred.remainder(new BigDecimal(roundingNearestDigit));
		if (correction.compareTo(BigDecimal.ZERO) != 0)
		{
			amountMultipliedByHundred = amountMultipliedByHundred.add(new BigDecimal(roundingNearestDigit)).subtract(correction);
		}
		
		return amountMultipliedByHundred.divide(BIGDECIMAL_HUNDRED);
	}

}
