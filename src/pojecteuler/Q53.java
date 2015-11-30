package pojecteuler;

import java.math.BigInteger;

public class Q53 {
	public static int combinatoricSelections(int maxN) {
		BigInteger oneMillion = new BigInteger("1000000");
		int count = 0;
		
		for (int n = 1; n <= maxN; n++) {
			for (int r = 0; r <= n; r++) {
				BigInteger nCrResult = nCr(new BigInteger(String.valueOf(n)), new BigInteger(String.valueOf(r)));
				if (nCrResult.compareTo(oneMillion) == 1)
					count++;
			}
		}
		
		return count;
	}
	
	public static BigInteger nCr(BigInteger n, BigInteger r) {
		return HelperFunctions.bigIntegerFactorial(new BigInteger(String.valueOf(n)))
				.divide(HelperFunctions.bigIntegerFactorial(new BigInteger(String.valueOf(r))).multiply(HelperFunctions.bigIntegerFactorial(new BigInteger(String.valueOf(n.subtract(r))))));
	}
}
