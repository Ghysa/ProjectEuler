package Q41_50;

import java.util.ArrayList;
import java.util.List;

import pojecteuler.HelperFunctions;

public class Q47 {
	public static int distincPrimeFactors(int digits) {
		int result = 0;
		int max = 999999;
		List<Integer> nrOfPrimeFactors = new ArrayList<>();
		nrOfPrimeFactors.add(0);
		for (int i = 1; i < max; i++) {
			nrOfPrimeFactors.add(HelperFunctions.findDistinctPrimeFactors(i).size());
		}
		
		System.out.println(nrOfPrimeFactors);
		
		int count = 0;
		for (int i = 1; i < max; i++) {
			if (nrOfPrimeFactors.get(i) == digits) {
				count++;
				if (count == digits) {
					result = i-digits+1;
					break;
				}
			} else {
				count = 0;
			}			
		}
		
		return result;
	}
}
