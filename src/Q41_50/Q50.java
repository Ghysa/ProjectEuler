package Q41_50;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pojecteuler.HelperFunctions;

public class Q50 {
	public static int consecutivePrimeSum(int max) {
		int result = 0;
		
		List<Integer> primes = HelperFunctions.findPrimes(max);
		Set<Integer> primesSet = new HashSet<>(primes);
		
		System.out.println(primes);
		
		int temp = 0;
		int count = 0;
		for (Integer prime : primes) {
			if (prime < max - max/10)
				continue;
			for (int i = 0; i < primes.size(); i++) {
				for (int j = i; temp < prime; j++) {
					temp += primes.get(j);
					if (primesSet.contains(temp) && j > i) {
						if (count < j - i) {
							count = j - i;
							result = temp;
						}
					}
				}
				temp = 0;
			}
			System.out.println(prime);
		}
		
		return result;
	}
}
