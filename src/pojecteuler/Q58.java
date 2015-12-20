package pojecteuler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Q58 {
	public static int spiralPrimes(double maxRatio) {
		int result = 0;
		double ratio = 1.0;
		int c = 7;
		int nrOfPrimes = 0;
		int add = 2;
		
		while ((double)nrOfPrimes / (2*add+1) > maxRatio) {
			add += 2;
			for (int i = 0; i < 3; i++) {
				c += add;
				if (isPseudoPrime(c)) nrOfPrimes++;
			}
			c += add;
		}
		
		return add+1;
	} 
	
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
	
	private static boolean isPseudoPrime(int n) {
		if (n <= 1) return false;
		if (n == 2) return true;
		if (n % 2 == 0) return false;
		if (n < 9) return true;
		if (n % 3 == 0) return false;
		if (n % 5 == 0) return false;

		int[] ar = new int[] {2, 3};
		for (int i = 0; i < ar.length; i++) {
			if (Witness(ar[i], n)) return false;
		}
		return true;
	}


	private static boolean Witness(int a, int n) {
		int t = 0;
		int u = n - 1;
		while ((u & 1) == 0) {
			t++;
			u >>= 1;
		}

		long xi1 = ModularExp(a, u, n);
		long xi2;

		for (int i = 0; i < t; i++) {
			xi2 = xi1 * xi1 % n;                
			if ((xi2 == 1) && (xi1 != 1) && (xi1 != (n - 1))) return true;
			xi1 = xi2;
		}
		if (xi1 != 1) return true;
		return false;
	}
	
	private static long ModularExp(int a, int b, int n) {
		long d = 1;
		int k = 0;
		while ((b >> k) > 0) k++;

		for (int i = k - 1; i >= 0; i--) {
			d = d * d % n;
			if (((b >> i) & 1) > 0) d = d * a % n;
		}

		return d;
	}
	
	public enum Move {
		RIGHT,
		DOWN,
		LEFT,
		UP
	}
}
