package pojecteuler;

import java.util.List;

public class Q87 {
	public static int primePowerTriples(int max) {
		int result = 0;
		// Keep array of boolean to check if made a number below max
		boolean[] numbers = new boolean[max];
		
		// We will never need a prime larger than sqrt(max) for the square
		List<Integer> primesSqrt = HelperFunctions.findPrimes((int)Math.sqrt(max));
		// We will never need a prime larger than max^(1/3) for the cube
		List<Integer> primesCubeRoot = HelperFunctions.findPrimes((int)Math.pow(max, 1.0/3));
		// We will never need a prime larger than max^(1/4) for the fourth power
		List<Integer> primes4thRoot = HelperFunctions.findPrimes((int)Math.pow(max, 1.0/4));
		
		// No rocket sience here, simply go trough all combinations.
		for (Integer prime1 : primesSqrt) {
			for (Integer prime2 : primesCubeRoot) {
				for (Integer prime3 : primes4thRoot) {
					int triple = (prime1*prime1) + (prime2*prime2*prime2) + (prime3*prime3*prime3*prime3);
					if (triple > max) {
						continue;
					}
					numbers[(int) triple] = true;
				}
			}
		}
		
		// Check which numbers we made.
		for (boolean b : numbers) {
			if (b) {
				result++;
			}
		}
		
		return result;
	}
}
