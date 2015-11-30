package Q21_30;

import java.util.ArrayList;
import java.util.List;

public class Q30 {
	public static int digitFifthPowers() {
		int result = 0;
		
		for (int i = 10; i < 1000000; i++) {
			if(isSumOfDigitPowers(i)) {
				result += i;
				System.out.println("succes + i: " + i);
			}
		}
		
		return result;
	}

	private static boolean isSumOfDigitPowers(int number) {
		
		List<Integer> list = new ArrayList<>();
		int temp = number;
		
		while (temp > 0) {
		    list.add(temp%10);
		    temp = temp / 10;
		}
		
		double sum = 0;
		
		for (Integer i : list) {
			sum += Math.pow(i, 5);
		}
		
		if (sum == number)
			return true;
		
		return false;
	}
}
