package pojecteuler;

import java.util.List;

public class Q70 {
	public static int totientPermutation(int max) {
		int result = 0;
		double comp = 33;
		List<Integer> primes = HelperFunctions.findPrimes(5000);
		for(int i = 0; i < 320; i++) {
			primes.remove(0);
		}
		
		for (Integer prime1 : primes) {
			for (Integer prime2 : primes) {
				int p = prime1 * prime2;
				double n = HelperFunctions.numberOfRelativePrimes(p);
				if (p > 10000000) 
					continue;
				if (HelperFunctions.isPermutation(p, (int)n)) {
					double ratio = p / n;
					if (ratio < comp) {
						comp = ratio;
						result = p;
					}
				}					
			}
		}
		
		return result;
	}
}
