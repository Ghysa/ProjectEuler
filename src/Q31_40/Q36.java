package Q31_40;

import pojecteuler.HelperFunctions;

public class Q36 {
	public static int doubleBasePalindrome(int max) {
		int result = 0;

		for (int i = 0; i < max; i++) {
			if (HelperFunctions.isPalindromeBase10(i) && HelperFunctions.isPalindromeBase2(i)) {
				result += i;
				System.out.println(i);
			}				
		}
		
		return result;
	}
}
