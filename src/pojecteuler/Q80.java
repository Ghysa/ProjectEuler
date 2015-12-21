package pojecteuler;

import java.math.BigDecimal;

public class Q80 {
	public static int squareRootDigitalExpansion(int max) {
		int result = 475; // first irrational nr is sqrt(2) and the sum is 475 (see assignment)
		
		BigDecimal bf = new BigDecimal(2.0);
		bf = HelperFunctions.bigSqrt(bf);
		System.out.println(bf);
		
		for (int i = 3; i <= max; i++) {
			BigDecimal bigDec = new BigDecimal(i);
			bigDec = HelperFunctions.bigSqrt(bigDec);
			String str = bigDec.toString();
			System.out.println(str);
		}
		
		return result;
	}
}
