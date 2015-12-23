package pojecteuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q81 {
	
	public static int pathSumTwoWay() {
		int result = 0;
		int size = 80; //given
		int[][] matrix = new int[size][size];
		
		try {
			int i = 0;
			for (String line : Files.readAllLines(Paths.get("res/p081_matrix.txt"))) {
				int j = 0;
			    for (String part : line.split(",")) {
			    	if (HelperFunctions.isNumeric(part)) {
				        matrix[i][j] = Integer.valueOf(part);
			    	}
			    	j++;
			    }
			    i++;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		result = calculateMinimumPathSumTwoWay(matrix, size-1, size-1);
		
		return result;
	}

	// Dynamic programming method
	private static int calculateMinimumPathSumTwoWay(int[][] matrix, int x, int y) {
		
		// initialize first col
		for (int i = 1; i <= y; i++) {
			matrix[i][0] += matrix[i-1][0];
		}
		
		// initialize first row
		for (int j = 1; j <= x; j++) {
			matrix[0][j] += matrix[0][j-1];
		}
		
		// calculate other values
		for (int i = 1; i <= y; i++) {
			for (int j = 1; j <= x; j++) {
				matrix[i][j] += Math.min(matrix[i-1][j], matrix[i][j-1]);
			}
		}
		
		return matrix[y][x];
	}

	// Bruteforce won't work here... :-(
	private static int calculateMinimumPathSumTwoWayRecursive(int[][] matrix, int x, int y) {
		if (x == 0 && y == 0) {
			return matrix[x][y];
		} else if (x == 0) {
			return matrix[x][y] + calculateMinimumPathSumTwoWayRecursive(matrix, x, y-1);
		} else if (y == 0) {
			return matrix[x][y] + calculateMinimumPathSumTwoWayRecursive(matrix, x-1, y);
		} else {
			return matrix[x][y] + Math.min(calculateMinimumPathSumTwoWayRecursive(matrix, x-1, y), calculateMinimumPathSumTwoWayRecursive(matrix, x, y-1));
		}
	}
}
