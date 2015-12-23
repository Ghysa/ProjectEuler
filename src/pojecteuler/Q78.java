package pojecteuler;

import java.math.BigInteger;
import java.util.List;

public class Q78 {
	public static int coinPartitions(int max) {
		int result = 0;
		
		List<BigInteger> partitions = HelperFunctions.partition(max);
		
		for (BigInteger partition : partitions) {
			if (partition.mod(new BigInteger("1000000")) == BigInteger.ZERO) {
				return partitions.indexOf(partition);
			}
		}
		
		return result;
	}
}
