package Q31_40;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pojecteuler.HelperFunctions;

public class Q32 {
	public static int pandigitalProducts() {
		int result = 0;
		
		Set<Integer> productSet = new HashSet<>();
		
		for (int i = 0; i <= 9999; i++) {
			for (int j = 0; j <= 9999; j++) {
				if (isPandigitalProduct(i,j)) {
					productSet.add(i*j);
					System.out.println("i: " + i);
					System.out.println("j: " + j);
					System.out.println("product: " + (i*j));
				}
			}
		}
		
		for (Integer i : productSet) {
			result += i;
		}
		
		return result;
	}

	public static boolean isPandigitalProduct(int i, int j) {
		int product = i * j;
		
		if (product > 99999)
			return false;
		
		List<Integer> iDigits = HelperFunctions.getDigits(i);
		List<Integer> jDigits = HelperFunctions.getDigits(j);
		List<Integer> productDigits = HelperFunctions.getDigits(product);
		
		boolean[] digits = new boolean[10];
		
		for (Integer digit : iDigits) {
			if (digits[digit] == true)
				return false;
			digits[digit] = true;
		}
		
		for (Integer digit : jDigits) {
			if (digits[digit] == true)
				return false;
			digits[digit] = true;
		}
		
		for (Integer digit : productDigits) {
			if (digits[digit] == true)
				return false;
			digits[digit] = true;
		}
		
		if (digits[0]) {
			return false;
		} else {
			digits[0] = true;
		}
		for (boolean digit : digits) {
			if (!digit)
				return false;
		}
		
		return true;
	}
}
