package Q31_40;

import java.util.ArrayList;
import java.util.List;

import pojecteuler.HelperFunctions;

public class Q38 {
	public static int pandigitalMultiples() {
		int result = 0;
		String concatProduct = "";
		List<Integer> list = new ArrayList<>();
		
		for (int i = 1; i < 9999; i++) {
			for (int j = 1; j < 10; j++) {
				concatProduct += (i*j);
				if (concatProduct.length() == 9) {
					if (isPandigital1toN(Integer.parseInt(concatProduct))) {
						list.add(Integer.parseInt(concatProduct));
						System.out.println("i: " + i);
						System.out.println("j: " + j);
						System.out.println(concatProduct);
					}
					concatProduct = "";
					break;
				} else if (concatProduct.length() > 9) {
					concatProduct = "";
					break;
				}
			}
		}
		
		for (Integer i : list) {
			if (i > result)
				result = i;
		}
		
		return result;
	}
	
	public static boolean isPandigital1toN(int number) {
		String str = Integer.toString(number);
		boolean[] containsDigit = new boolean[str.length()+1];
		List<Integer> digits = HelperFunctions.getDigits(number);
		
		for (Integer digit : digits) {
			if (digit > digits.size())
				return false;
			if (containsDigit[digit] == true)
				return false;
			containsDigit[digit] = true;
		}
		
		if (containsDigit[0])
			return false;
		
		return true;
	}
}
