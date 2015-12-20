package Q51_60;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import pojecteuler.HelperFunctions;

public class Q57 {
	public static int squareRootConvergents(int maxExpansions) {
		int result = 0;
		
		Map<Integer, Integer> sequence = new HashMap<>();
		sequence.put(0, 1);
		for (int i = 1; i <= maxExpansions; i++) {
			sequence.put(i, 2);
		}
		
		Map<Integer, BigInteger> numerators = HelperFunctions.continuedFractionNumerator(sequence);
		Map<Integer, BigInteger> denominators = HelperFunctions.continuedFractionDenominator(sequence);
		
		for (int i = 1; i <= maxExpansions; i++) {
			int numLength = numerators.get(i).toString().length();
			int denomLength = denominators.get(i).toString().length();
			if (numLength > denomLength) {
				result++;
			}
		}
		
		return result;
	}
}
