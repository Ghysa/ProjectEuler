package Q41_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Q1_10.Q3;

public class Q46 {
	public static int goldbachOtherConjecture() {
		int result = 0;
		int limit = 100000;
		
		List<Boolean> primesBoolean = new ArrayList<>(Arrays.asList(new Boolean[limit]));
        Collections.fill(primesBoolean, Boolean.TRUE);
        
        for (int i = 2; i <= Math.sqrt(limit); i++) {
            if (primesBoolean.get(i) == true) {
                for (int j = (i*i); j < limit; j += i) {
                    primesBoolean.set(j, Boolean.FALSE);
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < primesBoolean.size(); i++) {
        	if (primesBoolean.get(i) == true) {
        		primes.add(i);
        	}
        }
        primes.remove(0);
        
        List<Integer> oddCompNumbers = new ArrayList<>();
        for (int i = 1; i < limit; i = i + 2) {
        	if (Q3.largestPrimeFactor(i) != i)
        		oddCompNumbers.add(i);
        }
        oddCompNumbers.remove(0);
        
        oddBlock:
        for (Integer nr : oddCompNumbers) {
        	primeBlock:
        	for (Integer prime : primes) {
        		if (prime > nr) {
        			result = nr;
        			break oddBlock;
        		}
        		for (int i = 1; i < nr; i++) {
        			if ((prime + (i*i)*2) == nr) {
        				System.out.println("nr: " + nr + " = " + prime + " + " + 2 + " * " + i + "²");
        				break primeBlock;
        			}
        		}
        	}
        }
		
		return result;
	}
}
