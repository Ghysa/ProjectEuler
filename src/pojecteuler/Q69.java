package pojecteuler;

import java.util.List;

public class Q69 {
	public static int totientMaximum(int max) {
		int result = 1;
		int i = 0;
		
		List<Integer> primes = HelperFunctions.findPrimes(500);
		
		while (result * primes.get(i) < max) {
			result *= primes.get(i);
			i++;
		}
		
		return result;
	}	
}
