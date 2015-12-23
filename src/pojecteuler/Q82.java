package pojecteuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q82 {
	public static int pathSumThreeWay() {
		int result = 999999999;
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
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int tempResult = calculateMinimumPathSumThreeWay(matrix, i, j, size);
				if (tempResult < result) {
					result = tempResult;
				}
			}
		}
		
		return result;
	}

	// Left to Right minimum path (Up, Down & Right possible)
	private static int calculateMinimumPathSumThreeWay(int[][] matrix, int startY, int endY, int size) {
		
		int[][] copy = matrix.clone();
		
		if (startY+1 < size) {
			// init first col downwards
			for (int i = startY+1; i < size; i++) {
				copy[i][0] += copy[i-1][0];
			}
		}
		
		if (startY > 0) {
			// init first col upwards
			for (int i = startY-1; i >= 0; i--) {
				copy[i][0] += copy[i+1][0];
			}
		}
		
		// other values
		for (int i = 1; i < size; i++) {
			for (int j = 1; j < size; j++) {
				if (i == 0) {
					copy[i][j] += Math.min(copy[i+1][j], copy[i][j-1]);
				} else if (i == size-1) {
					copy[i][j] += Math.min(copy[i-1][j], copy[i][j-1]);
				} else {
					copy[i][j] += minOfThreeInts(copy[i][j-1], copy[i-1][j], copy[i+1][j]);
				}
			}
		}
		
		return copy[endY][size-1];
	}
	
	private static int minOfThreeInts(int x, int y, int z) {
		return Math.min(x, Math.min(y, z));
	}
}
