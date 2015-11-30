package Q21_30;

import java.math.BigInteger;

public class Q25 {
	public static int indexOfNDigitFibonacciNumber(int n) {
		int index = 2;
		BigInteger number = BigInteger.ONE;
		BigInteger prevNumber = BigInteger.ONE;
		
		while (number.toString().length() < n && prevNumber.toString().length() < n) {
			if (index%2 == 0)
				number = number.add(prevNumber);
			else
				prevNumber = number.add(prevNumber);
			index++;
		}
		
		return index;
	}
}
