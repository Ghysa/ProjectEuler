package Q41_50;

import Q1_10.Q3;
import Q31_40.Q38;

public class Q41 {
	public static int pandigitalPrime() {
		int result = 0;
		
		for (int i = 0; i < 9999999; i++) {
			if (Q38.isPandigital1toN(i))
				if (Q3.largestPrimeFactor(i) == i)				
					if (i > result)
						result = i;
		}
		
		return result;
	}
}
