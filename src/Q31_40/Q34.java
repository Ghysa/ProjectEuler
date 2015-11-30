package Q31_40;

import java.util.List;

import pojecteuler.HelperFunctions;

public class Q34 {
	public static int digitFactorials() {
		int result = 0;
		
		for (int i = 3; i < 99999; i++) {
			List<Integer> digits = HelperFunctions.getDigits(i);
			int sum = 0;
			for (Integer digit : digits) {
				sum += HelperFunctions.factorialRecursive(digit);
			}
			if (sum == i) {
				result += sum;
			}
		}
		
		return result;
	}
	
}
