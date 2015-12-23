package pojecteuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q83 {
	public static int pathSumFourWays() {
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
		
		// There's only path that needs to be examined in this case
		return HelperFunctions.AStar(matrix, 0, 0, size-1, size-1, size);
	}
	
	
}
