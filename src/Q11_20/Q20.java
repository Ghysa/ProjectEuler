package Q11_20;

import java.math.BigInteger;

public class Q20 {
	public static int factorialSum(int number) {
		BigInteger result = BigInteger.ONE;
		char[] charResult;
		int sumOfChars = 0;
		
		for (int i = 1; i <= number; i++) {
			BigInteger big = new BigInteger(Integer.toString(i));
			result = result.multiply(big);
		}
		
		System.out.println(result);
		charResult = result.toString().toCharArray();
		
		for (char c : charResult) {
			sumOfChars += Character.getNumericValue(c);
		}
		return sumOfChars;
	}
}
