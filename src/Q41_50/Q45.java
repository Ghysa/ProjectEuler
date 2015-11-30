package Q41_50;

import java.util.HashSet;
import java.util.Set;

public class Q45 {
	public static int triPentaAndHex() {
		int result = 0;
		
		Set<Long> triangulars = new HashSet<>();
		Set<Long> pentagons = new HashSet<>();
		Set<Long> hexagons = new HashSet<>();
		
		for (int i = 1; i < 999999; i++) {
			triangulars.add((long)i*(i + 1)/2);
		}
		for (int i = 1; i < 999999; i++) {
			pentagons.add((long)i*(i*3 - 1)/2);
		}
		for (int i = 1; i < 999999; i++) {
			hexagons.add((long)i*(i*2 - 1));
		}
		
		for (Long tri : triangulars) {
			if (pentagons.contains(tri)) {
				if (hexagons.contains(tri)) {
					System.out.println(tri);
				}
			}
		}
		
		return result;
	}
}
