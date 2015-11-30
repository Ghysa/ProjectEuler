package Q21_30;

import java.util.ArrayList;
import java.util.List;

public class Q23 {
	public static long nonAbundantSums() {
		long result = 0;
		
		List<Integer> abundantNumbers = new ArrayList<>();
		
		for (int i = 1; i < 28123; i++) {
			List<Integer> divisors = Q21.findDivisors(i);
			int sumOfDivisors = Q21.sumOfList(divisors);
			if (sumOfDivisors > i)
				abundantNumbers.add(i);			
		}
		
		for (int i = 1; i < 28123; i++) {
			if (!isSumOfAbundantNumber(i, abundantNumbers))
				result += i;
		}
		
		return result;
	}

	private static boolean isSumOfAbundantNumber(int number, List<Integer> abundantNumbers) {
		
		for (int i = 0; i < abundantNumbers.size(); i++) {
			if (abundantNumbers.get(i) > number)
				break;
			for (int j = 0; j <= i; j++) {
				if (abundantNumbers.get(i) + abundantNumbers.get(j) == number)
					return true;				
			}
		}
		
		return false;
	}
}
