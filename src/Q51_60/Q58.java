package Q51_60;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pojecteuler.HelperFunctions;

public class Q58 {
	public static int spiralPrimes(double maxRatio) {
		int nrOfPrimes = 3;
		int number = 9;
		int add = 4;
		
		while ((double)nrOfPrimes / (2*add+1) > maxRatio) {
			for (int i = 0; i < 4; i++) {
				number += add;
				if (HelperFunctions.isPseudoPrime(number)) {
					nrOfPrimes++;
				}
			}
			add += 2;			
		}
		
		return add+1;
	} 
	
	// Old attempts, don't bother they are waaaay too slow and incorrect
	public static double spiralPrimeLoop(int dim, Set<Integer> primesSet) {
		
		List<Integer> diagonals = new ArrayList<>();
		int size = dim*dim;
		int moveAmount = 2;
		
		for(int i = 1; i <= size; ) {
			for (int j = 0; j < 4; j++) {
				i += moveAmount;
				diagonals.add(i);
			}
			moveAmount += 2;
		}
		
		int count = 0;
		for (Integer dia : diagonals) {
			if (primesSet.contains(dia)) {
				count++;
			}
		}
		
		double ratio = (double) count / (double) diagonals.size();
		
		System.out.println(count + " / " + diagonals.size());
		System.out.println("ratio: " + ratio);
		
		return ratio;
	}
	
	public static double spiralPrimeLoopEnumWay(int dim, Set<Integer> primesSet) {
		int[][] matrix = new int[dim][dim];
		
		int number = 1;
		int i = (dim/2);
		int j = (dim/2);
		Move move = Move.RIGHT;
		int moveAmount = 0;
		matrix[i][j] = number;
		number++;
		
		while (number <= dim*dim) {		// Moves in wrong directions? Nevertheless diagonals are the same...
			switch (move) {
				case RIGHT: {
					if (moveAmount < dim-1) {
						moveAmount++;
					}
					for (int n = 0; n < moveAmount; n++) {
						i++;
						matrix[i][j] = number;
						number++;
					}
					move = Move.DOWN;
					break;
				}
				case DOWN: {
					for (int n = 0; n < moveAmount; n++) {
						j++;
						matrix[i][j] = number;
						number++;
					}
					move = Move.LEFT;
					break;				
				}
				case LEFT: {
					if (moveAmount < dim-1) {
						moveAmount++;
					}
					for (int n = 0; n < moveAmount; n++) {
						i--;
						matrix[i][j] = number;
						number++;
					}
					move = Move.UP;
					break;	
				}
				case UP: {
					for (int n = 0; n < moveAmount; n++) {
						j--;
						matrix[i][j] = number;
						number++;
					}
					move = Move.RIGHT;
					break;
				}
			}
		}
		
		List<Integer> diagonals = new ArrayList<>();
		
		for (int x = 0; x < dim; x++) {
			for (int y = 0; y < dim; y++) {
				if(x == y)
					diagonals.add(matrix[x][y]);
				else if ((x+y) == dim-1)
					diagonals.add(matrix[x][y]);
//				System.out.print(matrix[x][y] + " ");
			}
//			System.out.println("");
		}
		
		
		int count = 0;
		for (Integer dia : diagonals) {
			if (primesSet.contains(dia)) {
				count++;
			}
		}
		
		double ratio = (double) count / (double) diagonals.size();
		
		System.out.println(count + " / " + diagonals.size());
		System.out.println("ratio: " + ratio);
		
		return ratio;
	}
	
	public enum Move {
		RIGHT,
		DOWN,
		LEFT,
		UP
	}
}
