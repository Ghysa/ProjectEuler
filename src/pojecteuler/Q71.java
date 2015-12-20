package pojecteuler;

import java.util.Set;
import java.util.TreeSet;

public class Q71 {
	public static double orderedFractions(int d) {
		double result = 0.0;
		
		Set<BigFraction> fractions = new TreeSet<>();
		fractions.add(new BigFraction(3.0, 7.0));
		fractions.add(new BigFraction(423752.0, 999725.0));
		
		for (double i = d*0.999; i <= d; i++) {
			for (double j = d*0.42; j <= d*0.43 && j < i; j++) {
				fractions.add(new BigFraction(j, i));
			}
			System.out.println(i);
		}
		BigFraction[] da = new BigFraction[fractions.size()];
		System.out.println(fractions.size());
		fractions.toArray(da);
		
		for(int i = da.length-1; i > 0; i--) {
			if (da[i].equals(new BigFraction(3.0, 7.0))) {
				System.out.println(da[i-1]);
				break;
			}
		}
		
		return result;
	}
}
