package Q31_40;

import java.util.Collections;
import java.util.List;

import Q1_10.Q3;
import pojecteuler.HelperFunctions;

public class Q37 {
	public static int truncablePrimes() {
		int result = 0;
		
		for (int i = 10; i < 999999; i++) {
			if (Q3.largestPrimeFactor(i) == i) { // prime number!
				if (isTruncable(i)) {
					result += i;
					System.out.println(i);
				}
			}
		}
		
		return result;
	}
	
	public static boolean isTruncable(int number) {
		return (isTruncableLeft(number) && isTruncableRight(number));
		
	}

	private static boolean isTruncableRight(int number) {
		List<Integer> digits = HelperFunctions.getDigits(number);
		Collections.reverse(digits);
		
		// right to left
		int size = digits.size();
		for (int i = 0; i < size - 1; i++) {
			digits.remove(digits.size() - 1);
			if (HelperFunctions.fromListToInteger(digits) != Q3.largestPrimeFactor(HelperFunctions.fromListToInteger(digits)))
				return false;
				
		}
		return true;
	}
	
	private static boolean isTruncableLeft(int number) {
		List<Integer> digits = HelperFunctions.getDigits(number);
		Collections.reverse(digits);
		
		// left to right
		int size = digits.size();
		for (int i = 0; i < size - 1; i++) {
			digits.remove(0);
			if (HelperFunctions.fromListToInteger(digits) != Q3.largestPrimeFactor(HelperFunctions.fromListToInteger(digits)))
				return false;
				
		}
		return true;
	}
}
