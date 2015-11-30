package Q31_40;

import java.util.ArrayList;
import java.util.List;

public class Q39 {
	public static int integerRightTriangles(int max) {
		int result = 0;
		List<Integer> maxList = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();

		
		for (int i = 100; i < max; i++) {
			for (int j = 10; j < i/2; j++) {
				for (int k = 10; k < i/2; k++) {
					int sq = i - j - k;
					if ( isTriangle(j, k, sq) ) {
						tempList.add(i);
						System.out.println("succes");
					}
				}
			}
			if(tempList.size() > maxList.size()) {
				maxList = tempList;
			}
			tempList = new ArrayList<>();
		}
		
		result = maxList.get(0);
		System.out.println("list size: " + maxList.size());
		
		return result;
	}
	
	public static boolean isTriangle(int i, int j, int sq) {
		return Math.pow(sq, 2) == ( Math.pow(i, 2) + Math.pow(j, 2) );
	}
}
