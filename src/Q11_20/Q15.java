package Q11_20;

import java.math.BigInteger;

public class Q15 {
	public static String latticePaths(int dim) {
		BigInteger[][] matrix = new BigInteger[dim][dim];
		
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				matrix[i][j] = BigInteger.ONE;
			}
		}
		
		for (int i = 1; i < dim; i++) {
			for (int j = 1; j < dim; j++) {
				matrix[i][j] = matrix[i-1][j].add(matrix[i][j-1]);
			}
		}
		
		return matrix[dim-1][dim-1].toString();
	}
}
