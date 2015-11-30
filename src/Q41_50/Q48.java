package Q41_50;

import java.math.BigInteger;

public class Q48 {
	public static BigInteger selfPowers(int maxNum) {
		BigInteger result = BigInteger.ONE;
		
		for (int i = 2; i <= maxNum; i++) {
			BigInteger temp = new BigInteger(Integer.toString(i));
			temp = temp.pow(i);
			result = result.add(temp);
		}	
		
		return result;
	}
}
