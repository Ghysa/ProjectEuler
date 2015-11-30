package Q21_30;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pojecteuler.HelperFunctions;

public class Q24 {
	public static BigInteger lexicographicPermutations() {
		BigInteger result = BigInteger.ZERO;
		
		List<Integer> objects = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			objects.add(i);
		}
		
		List<BigInteger> permutations = new ArrayList<>();
		HelperFunctions.calculatePermutations(objects, permutations, 0);
		
		Collections.sort(permutations);
		
		result = permutations.get(999999);
		
		return result;
	}	
}
