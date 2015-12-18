package pojecteuler;

import java.math.BigInteger;

public class Q97 {
	public static String largeNonMersennePrime() {
		
		BigInteger two = new BigInteger("2");
		BigInteger two8433 = new BigInteger("28433");
		
		BigInteger solution = two8433.multiply(two.pow(7830457)).add(BigInteger.ONE);
		String solString = solution.toString();
		
		return solString.substring(solString.length() - 10);
	}
}
