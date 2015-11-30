package Q31_40;

import java.util.ArrayList;
import java.util.List;

import pojecteuler.HelperFunctions;

public class Q33 {
	public static double digitCancellingFractions() {
		double result = 1;
		
		List<Integer> numbers = new ArrayList<>();
		for (int i = 10; i < 100; i++) {
			numbers.add(i);
		}
		
		List<List<Integer>> fractions = new ArrayList<>();
		for (Integer number : numbers) {
			for (Integer num : numbers) {
				List<Integer> fraction = new ArrayList<>();
				fraction.add(number);
				fraction.add(num);
				fractions.add(fraction);
			}
		}
		
		List<List<Integer>> resultList = new ArrayList<>();
		for (List<Integer> fraction : fractions) {
			if (isDigitCancellingFraction(fraction))
				resultList.add(fraction);
		}
		System.out.println(resultList);
		
		for (List<Integer> fraction : resultList) {
			double gcd = HelperFunctions.findGCD(fraction.get(0), fraction.get(1));
			result *= ((fraction.get(0)/gcd) / (fraction.get(1)/gcd));
		}
		return result;
	}

	public static boolean isDigitCancellingFraction(List<Integer> fraction) {
		double numerator = fraction.get(0);
		double denominator = fraction.get(1);
		if (numerator == denominator)
			return false;
		
		List<Integer> numList = HelperFunctions.getDigits((int)numerator);
		List<Integer> denomList = HelperFunctions.getDigits((int)denominator);
		
		double result = numerator / denominator;
		if (result > 1)
			return false;
		
		Integer toRemove = 0;
		
		for (Integer numDigit : numList) {
			for (Integer denomDigit : denomList) {
				if (numDigit == denomDigit) {
					toRemove = numDigit;
				}					
			}
		}
		
		if(toRemove == 0)
			return false;
		
		numList.remove(toRemove);
		denomList.remove(toRemove);
		
		double comp = ((double) numList.get(0) / (double) denomList.get(0));
		if (comp == result)
			return true;
		
		return false;
	}
}
