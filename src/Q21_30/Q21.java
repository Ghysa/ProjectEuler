package Q21_30;

import java.util.ArrayList;
import java.util.List;

public class Q21 {
	public static int amicableNumbers(int maxNum) {
		int result = 0;
		
		for (int i = 1; i <= maxNum; i++) {
			if (isAmicableNumber(i))
				result += i;
		}
		
		return result;
	}
	
	public static boolean isAmicableNumber(int number) {
		boolean isAmicable = false;
		
		List<Integer> divisorsNumber = findDivisors(number);
		
		int sumOfNumberList = sumOfList(divisorsNumber);
		if (sumOfNumberList == number)
			return false;
		
		List<Integer> divisorsAmicable = findDivisors(sumOfNumberList);
		
		int sumOfAmicableList = sumOfList(divisorsAmicable);
		
		if (sumOfAmicableList == number)
			isAmicable = true;		
		
		return isAmicable;
	}
	
	public static List<Integer> findDivisors(int number) {
		List<Integer> divList = new ArrayList<>();
		
		for (int i = 1; i < number; i++) {
			if (number%i == 0) {
				divList.add(i);
			}
		}
		
		return divList;
	}
	
	public static int sumOfList(List<Integer> list) {
		int sumOfList = 0;
		
		for (int i : list) {
			sumOfList += i;
		}
		
		return sumOfList;
	}
}
