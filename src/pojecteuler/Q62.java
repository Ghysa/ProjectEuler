package pojecteuler;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q62 {
	public static BigInteger cubicPermutations() {
		
		List<BigInteger> cubes = new ArrayList<>();
		
		for (int base = 2; base < 10000; base++) {
			BigInteger baseBig = new BigInteger(String.valueOf(base));
			cubes.add(baseBig.pow(3));
		}
		
		for (int i = 0 ; i < 30; i++) {
			cubes.remove(0);
		}
		System.out.println(cubes);
		Set<BigInteger> cubeSet = new HashSet<>(cubes);
		
		for (BigInteger cube : cubes) {
			List<BigInteger> permutations = new ArrayList<>();
			List<Integer> digits = HelperFunctions.getDigitsString(cube.toString());
			HelperFunctions.calculatePermutations(digits, permutations, 0);
			Set<BigInteger> permuSet = new HashSet<>(permutations);
			int count = 0;
			for (BigInteger permu : permuSet) {
				if (cubeSet.contains(permu)) {
					count++;
					if (count == 5) {
						System.out.println(permuSet);
						return cube;						
					}
				}
			}
		}
		
		return BigInteger.ONE;
	}
}
