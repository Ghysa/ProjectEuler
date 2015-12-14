package pojecteuler;

import java.math.BigInteger;

public class Q63 {
	public static int powerfulDigitCounts() {
		int result = 0;
		
		for (int exponent = 1; exponent < 100; exponent++) {
			for (BigInteger base = new BigInteger("2"); base.pow(exponent).toString().length() <= exponent; ) {
				if (base.pow(exponent).toString().length() == exponent) {
					System.out.println(base.toString() + " ^ " + exponent + " = " + base.pow(exponent).toString());
					result++;
				}
				base = base.add(BigInteger.ONE);
			}
		}
		
		return result;
	}
}
