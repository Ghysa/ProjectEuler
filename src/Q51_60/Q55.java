package Q51_60;

import java.math.BigInteger;

import pojecteuler.HelperFunctions;

public class Q55 {
	public static int lychrelNumbers(int max) {
		int result = 0;
		
		for (int i = 0; i < max; i++) {
			BigInteger num = new BigInteger(Integer.toString(i));
			BigInteger reverse = HelperFunctions.reverseBigInt(num);
			for (int j = 0; j < 50; j++) {
				BigInteger add = num.add(reverse);
				if (HelperFunctions.isPalindromeString(add.toString())) {
					result++;
					break;
				}
				num = add;
				reverse = HelperFunctions.reverseBigInt(num);
			}
		}
		
		return max - result;
	}
}
