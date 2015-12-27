package pojecteuler;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q62 {
	public static BigInteger cubicPermutations() {
		
		// Make a list with all cubes with base smaller than 10000
		List<BigInteger> cubes = new ArrayList<>();
		for (int base = 1; base < 10000; base++) {
			BigInteger baseBig = new BigInteger(String.valueOf(base));
			cubes.add(baseBig.pow(3));
		}
		
		// Get a list of the digits of a cube, then sort it so all permutations
		// will have the same list.
		List<List<Integer>> cubesDigits = new ArrayList<>();
		for (BigInteger cube : cubes) {
			List<Integer> digits = HelperFunctions.getDigitsString(cube.toString());
			Collections.sort(digits);
			cubesDigits.add(digits);
		}
		
		// Then find a list that occurs 5 times and get the first index of that list.
		BigInteger result = BigInteger.ZERO;
		for (List<Integer> digits : cubesDigits) {
			int count = Collections.frequency(cubesDigits, digits);
			if (count == 5) {
				result = new BigInteger(String.valueOf(cubesDigits.indexOf(digits)+1));
				result = result.pow(3);
				break;
			}
		}
		
		return result;
	}
}
