package pojecteuler;

public class Q75 {
	public static int singularIntegerRightTriangles(int maxL) {
		int result = 0;
		
		int[] isSingle = new int[maxL+1];
		
		// See https://en.wikipedia.org/wiki/Pythagorean_triple#Generating_a_triple
		for (int m = 2; m < Math.sqrt(maxL/2); m++) {
			for (int n = 1; n < m; n++) {
				// It's important to check if m & n are coprime otherwise we are not
				// generating a primitive triplet and thus are generating the same triplet
				// multiple times.
				if (((m+n) % 2 == 1) && (HelperFunctions.findGCD(m, n) == 1)) {
					int a = calcA(m,n);
					int b = calcB(m,n);
					int c = calcC(m,n);
					for (int k = 1; k*c <= maxL; k++) {
						if (k*a+k*b+k*c <= maxL) {
							isSingle[k*a+k*b+k*c]++;
						}
					}
				}
			}
		}
		
		for (int i : isSingle) {
			if (i == 1) {
				result++;
			}
		}
		
		return result;
	}
	
	private static int calcA(int m, int n) {
		return ((m*m) - (n*n));
	}
	
	private static int calcB(int m, int n) {
		return 2*m*n;
	}
	
	private static int calcC(int m, int n) {
		return ((m*m) + (n*n));
	}
}
