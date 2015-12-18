package Q51_60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pojecteuler.HelperFunctions;

public class Q51 {
	public static int primeDigitReplacements() {
		List<Integer> primes = HelperFunctions.findPrimes(1000000);
		Set<Integer> primeSet = new HashSet<>(primes);
		
		for (Integer prime : primes) {
			if (prime < 10000)
				continue;
			
			int recurringDigit = getRecurringDigit(prime);
			if (recurringDigit == -1)
				continue;
			
			System.out.println(recurringDigit);
			List<Integer> digits = HelperFunctions.getDigits(prime);
			Collections.reverse(digits);
			List<Integer> recurringPlaces = new ArrayList<Integer>(); // 0 based index
			for (int i = 0; i < digits.size(); i++) {
				if (digits.get(i) == recurringDigit)
					recurringPlaces.add(i);
			}
			System.out.println(recurringPlaces);
			
			List<Integer> family = new ArrayList<>();
			for (int i = 0; i <= 9; i++) {
				for (Integer place : recurringPlaces) {
					digits.set(place, i);
				}
				if (HelperFunctions.fromListToInteger(digits)>100000)
				family.add(HelperFunctions.fromListToInteger(digits));
			}
			
			Collections.sort(family);
			System.out.println(family);
			int count = 0;
			for(Integer fam : family) {
				if (primeSet.contains(fam))
					count++;
			}
			System.out.println(count);
			
			if (count == 8)
				return family.get(0);
			
		}
		
		return -1;
	}
	
	public static int getRecurringDigit(int number) {
		List<Integer> digits = HelperFunctions.getDigits(number);
		Collections.reverse(digits);
		digits.remove(digits.size()-1);
		for (int i = 0; i < 3; i++) {
			if (Collections.frequency(digits, i) == 3)
				return i;
		}
		
		return -1;
	}
}
