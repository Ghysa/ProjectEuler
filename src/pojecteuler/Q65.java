package pojecteuler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Q65 {
	public static int convergentsOfE(int seqNr) {
		int result = 0;
		
		Map<Integer, Integer> sequence = new HashMap<>();
		sequence.put(0, 2);
		int k = 1;
		
		for (int i = 1; i <= seqNr + 2; i++) {
			if ((i+1) % 3 == 0) {
				sequence.put(i, 2*k);
				k++;
			} else {
				sequence.put(i, 1);
			}
		}
		
		System.out.println(sequence);
		
		Map<Integer, BigInteger> kn = HelperFunctions.continuedFractionNumerator(sequence);
		
		System.out.println(kn);
		
		result = HelperFunctions.sumOfDigitsBigInt(kn.get(seqNr - 1));
		
		return result;
	}
}
