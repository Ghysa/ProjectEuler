package Q41_50;

import java.util.ArrayList;
import java.util.List;

import pojecteuler.HelperFunctions;

public class Q49 {
	public static String primePermutations() {
		String result = "";
		List<List<Integer>> list = new ArrayList<>();
		
		for (int i = 1000; i < 9999; i++) {
			if (HelperFunctions.isPrime(i)) {
				for (int j = 1; j < 562000; j++) {
					if ((i+j) < 9999 && HelperFunctions.isPrime(i+j)) {
						if ((i+j+j) < 9999 && HelperFunctions.isPrime(i+j+j) ) {
							List<Integer> li = new ArrayList<>();
							li.add(i);
							li.add(i+j);
							li.add(i+j+j);
							list.add(li);
						}
					}
				}
			}
		}
		
		List<List<Integer>> resultList = new ArrayList<>();
		for (List<Integer> ariSeq : list) {
			if (ariSeq.contains(1487))
				System.out.println(ariSeq);
			if (HelperFunctions.isPermutationList(ariSeq))
				resultList.add(ariSeq);
		}
		
		System.out.println(resultList);
		
		return result;
	}

	
}
