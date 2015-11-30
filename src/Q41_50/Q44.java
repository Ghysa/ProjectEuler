package Q41_50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q44 {
	public static int pentagonNumbers() {
		int result = 9999999;
		Set<Integer> pentagons = new HashSet<>();
		
		for (int i = 1; i < 9999; i++) {
			pentagons.add(i*(i*3 - 1)/2);
		}
		
		System.out.println(pentagons);
		
		List<Integer> pentaDiff = new ArrayList<>();
		
		for (Integer penta : pentagons) {
			for (Integer pentagon : pentagons) {
				if (pentagons.contains(penta + pentagon)) {
					if (pentagons.contains(Math.abs(penta - pentagon))) {
						
						pentaDiff.add(Math.abs(penta - pentagon));
						
					}
				}
			}
		}
		
		for (Integer diff : pentaDiff) {
			if (diff < result)
				result = diff;
		}
		
		return result;
	}
}
