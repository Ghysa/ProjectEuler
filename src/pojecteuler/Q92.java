package pojecteuler;

import java.util.List;

public class Q92 {
	public static int squareDigitChains(int max) {
		int result = 0;
		
		for (int i = 2; i < max; i++) {
			if(getChainNumber(i) == 89) {
				result++;
			}
		}
		
		return result;
	}
	
	public static int getChainNumber(int number) {
		while (true) {
			int newNumber = getAddedSquareOfDigits(number);
			if (newNumber == 89 || newNumber == 1) {
				return newNumber;
			} else {
				number = newNumber;
			}
		}
	}
	
	public static int getAddedSquareOfDigits(int number) {
		List<Integer> digits = HelperFunctions.getDigits(number);
		int result = 0;
		
		for (Integer digit : digits) {
			result += (digit*digit);
		}
		
		return result;
	}
}
