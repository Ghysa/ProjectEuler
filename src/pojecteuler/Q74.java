package pojecteuler;

import java.util.HashSet;
import java.util.Set;

public class Q74 {
	public static int digitFactorialChains(int max) {
		int result = 0;
		
		for (int i = 0; i < max; i++) {
			if(getFactorialChainLength(i) == 60) {
				result++;
			}
		}
		
		return result;
	}

	public static int getFactorialChainLength(int number) {
		int count = 1; // 1 because original number is not counted otherwise
		Set<Integer> chain = new HashSet<>();
		
		while (true) {
			number = HelperFunctions.getFactorialDigitSum(number);
			if (chain.contains(number)) {
				break;
			}
			chain.add(number);
			count++;
		}		
		
		return count;
	}
}
