package pojecteuler;

import java.math.BigInteger;

public class Q56 {
	public static int powerDigitSum(int maxFactor) {
		int result = 0;
		
		for (int i = 1; i < maxFactor; i++) {
			for (int j = 1; j < maxFactor; j++) {
				BigInteger bigI = new BigInteger(String.valueOf(i));
				BigInteger bigPow = bigI.pow(j);
				int sumOfDigits = HelperFunctions.sumOfDigitsBigInt(bigPow);
				if (sumOfDigits > result) {
					result = sumOfDigits;
				}
			}
		}
		
		return result;
	}
}
