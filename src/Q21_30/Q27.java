package Q21_30;

import Q1_10.Q3;

public class Q27 {
	public static int quadraticPrimes(int maxCoefValue) {
		int result = 0;
		int maxN = 0, maxA = 0, maxB = 0;
		boolean prevWasPrime = false;
		
		for (int a = -(maxCoefValue) +1 ;a < maxCoefValue; a++) {
			for(int b = -(maxCoefValue)+1 ;b < maxCoefValue; b++) {
				for (int n = 0; n < 80; n++) {
					int prime = ((int) Math.pow(n, 2)) + (n*a) + b;
					
					if (Q3.largestPrimeFactor(prime) == prime) {
						prevWasPrime = true;
					} else {
						if(prevWasPrime) {
							prevWasPrime = false;
							if (maxN < n) {
								maxN = n;
								maxA = a;
								maxB = b;
							}
						}
						break;
					}
				}
			}
		}
		
		System.out.println("maxA: " + maxA);
		System.out.println("maxB: " + maxB);
		System.out.println("maxN: " + maxN);
		result = maxA * maxB;		
		
		return result;
	}
}
