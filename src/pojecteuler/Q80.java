package pojecteuler;

import java.math.BigDecimal;

public class Q80 {
	public static int squareRootDigitalExpansion(int max) {
		int result = 475; // first irrational nr is sqrt(2) and the sum is 475 (see assignment)
		
		for (int i = 3; i <= max; i++) {
			BigDecimal bigDec = new BigDecimal(i);
			BigDecimal bigSqrt = HelperFunctions.bigSqrt(bigDec);
			char[] ca = bigSqrt.toString().toCharArray();
			result += getSumOfFirstDecimalDigits(ca, 100);
		}
		
		
		return result;
	}
	
	
	public static int getSumOfFirstDecimalDigits(char[] digits, int nrOfDigits) {
		int sum = 0;
				
		for (int i = 2; i < nrOfDigits+1; i++) {
			sum += Character.getNumericValue(digits[i]);
		}
		
		if (sum != 0) {
			sum += Character.getNumericValue(digits[0]);
		}
		
		return sum;
	}
}
