package Q31_40;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Q1_10.Q3;
import pojecteuler.HelperFunctions;

public class Q35 {
	public static int circularPrimes(int max) {
		int result = 0;
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 1; i < max; i++) {
			if (Q3.largestPrimeFactor(i) == i) { // prime number!
				if (isCircularPrime(i)) {
					list.add(i);
					System.out.println(i);
				}
			}
		}
		
		result = list.size();
		
		return result;
	}

	public static boolean isCircularPrime(int prime) {
		List<Integer> digits = HelperFunctions.getDigits(prime);
		for(Integer digit : digits) {
			if(digit%2 == 0)
				return false;
		}
		Collections.reverse(digits);
		
		List<Integer> rotations = new ArrayList<>();
		
		for (int i = 0; i < digits.size(); i++) {
			digits.add(0, digits.get(digits.size()-1));
			digits.remove(digits.size()-1);
			rotations.add(HelperFunctions.fromListToInteger(digits));
		}
		
		for (Integer rotation : rotations) {
			if (Q3.largestPrimeFactor(rotation) != rotation)
				return false;
		}
		
		return true;
	}
}
