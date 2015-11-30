package pojecteuler;

import java.util.ArrayList;
import java.util.List;

public class Q52 {
	public static int permutedMultiples() {
		
		List<List<Integer>> multiples = new ArrayList<>();
		for (int i = 50001; i < 166667; i++) {
			List<Integer> li = new ArrayList<>();
			li.add(i*2);
			li.add(i*3);
			li.add(i*4);
			li.add(i*5);
			li.add(i*6);
			multiples.add(li);
		}
		
		for (List<Integer> li : multiples) {
			if (HelperFunctions.isPermutationList(li))
				return li.get(0)/2;
		}
		
		return -1;
	}
}
