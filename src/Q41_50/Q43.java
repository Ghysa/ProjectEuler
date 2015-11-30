package Q41_50;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pojecteuler.HelperFunctions;

public class Q43 {
	public static BigInteger substringDivisibility() {
		BigInteger result = BigInteger.ZERO; 
		
		List<Integer> objects = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			objects.add(i);
		}
		
		List<BigInteger> permutations = new ArrayList<>();
		HelperFunctions.calculatePermutations(objects, permutations, 0);
		
		Collections.sort(permutations);
		
		for (BigInteger permutation : permutations) {
			if (isPandigital0to9(permutation)) {
				if (isSubDivisibile(permutation)) {
					result = result.add(permutation);
					System.out.println("SUCCESS: " +permutation);
				}
			}
		}
		
		return result;
	}
	
	public static boolean isSubDivisibile(BigInteger number) {
		List<Integer> digits = getDigits(number);
		Collections.reverse(digits);
		
		int two = Integer.parseInt(""+digits.get(1)+digits.get(2)+digits.get(3));
		int three = Integer.parseInt(""+digits.get(2)+digits.get(3)+digits.get(4));
		int five = Integer.parseInt(""+digits.get(3)+digits.get(4)+digits.get(5));
		int seven = Integer.parseInt(""+digits.get(4)+digits.get(5)+digits.get(6));
		int eleven = Integer.parseInt(""+digits.get(5)+digits.get(6)+digits.get(7));
		int thirteen = Integer.parseInt(""+digits.get(6)+digits.get(7)+digits.get(8));
		int seventeen = Integer.parseInt(""+digits.get(7)+digits.get(8)+digits.get(9));
		
		if (two%2 != 0)
			return false;
		if (three%3 != 0)
			return false;
		if (five%5 != 0)
			return false;
		if (seven%7 != 0)
			return false;
		if (eleven%11 != 0)
			return false;
		if (thirteen%13 != 0)
			return false;
		if (seventeen%17 != 0)
			return false;
		
		return true;
	}
	
	public static boolean isPandigital0to9(BigInteger number) {
		String str = number.toString();
		boolean[] containsDigit = new boolean[str.length()+1];
		List<Integer> digits = getDigits(number);
		
		for (Integer digit : digits) {
			if (digit > digits.size())
				return false;
			if (containsDigit[digit] == true)
				return false;
			containsDigit[digit] = true;
		}
		
		if (containsDigit[0] == false)
			return false;
		
		return true;
	}
	
	public static List<Integer> getDigits(BigInteger number) {
		List<Integer> list = new ArrayList<>();
		
		while (number.compareTo(BigInteger.ZERO) == 1) {
		    list.add(Integer.parseInt((number.mod(BigInteger.TEN).toString())));
		    number = number.divide(BigInteger.TEN);
		}
		
		return list;
	}
}
