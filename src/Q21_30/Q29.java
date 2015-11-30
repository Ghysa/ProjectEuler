package Q21_30;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Q29 {
	public static int distinctPowers(int maxPow) {
		int result = 0;
		
		Set<BigInteger> list = new HashSet<>();
		
		for (int i = 2; i <= maxPow; i++) {
			for (int j = 2; j <= maxPow; j++) {
				BigInteger x = new BigInteger(Integer.toString(i));
				x = x.pow(j);
				list.add(x);
			}
		}
		
		result = list.size();
		
		return result;
	}
}
