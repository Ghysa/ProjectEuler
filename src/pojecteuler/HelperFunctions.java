package pojecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HelperFunctions {
	public static List<Integer> findPrimes(int N) {

        // initially assume all integers are prime
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i*i <= N; i++) {

            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i*j <= N; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        // create list
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i])
            	primes.add(i);
        }
        return primes;
	}
	
	public static List<Integer> findPrimeFactors(int number) {
		int d = 2;
		List<Integer> list = new ArrayList<>();
        
        while (number > 1) {
            while (number % d == 0) {
                list.add(d);
                number /= d;
            }
            d++;
        }
        return list;
	}
	
	public static List<Integer> findDistinctPrimeFactors(int number) {
		int d = 2;
		Set<Integer> set = new HashSet<>();
        
        while (number > 1) {
            while (number % d == 0) {
                set.add(d);
                number /= d;
            }
            d++;
        }
        List<Integer> list = new ArrayList<>(set);
        return list;
	}
	
	public static boolean isPrime(long n) {
		if(n < 2) return false;
	    if(n == 2 || n == 3) return true;
	    if(n%2 == 0 || n%3 == 0) return false;
	    long sqrtN = (long)Math.sqrt(n)+1;
	    for(long i = 6L; i <= sqrtN; i += 6) {
	        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
	    }
	    return true;
	}
	
	public static Integer fromListToInteger(List<Integer> digits) {
		String tempString = "";
		
		for (Integer digit : digits) {
			tempString += Integer.toString(digit);
		}
		
		return Integer.parseInt(tempString);
	}
	
	public static List<Integer> getDigits(int number) {
		List<Integer> list = new ArrayList<>();
		int temp = number;
		
		while (temp > 0) {
		    list.add(temp%10);
		    temp = temp / 10;
		}
		
		return list;
	}

	public static int factorialRecursive(int i) {
		if (i > 1)			
			return i*factorialRecursive(i-1);
		else
			return 1;
	}
	
	public static BigInteger bigIntegerFactorial(BigInteger i) {
		if (i.compareTo(BigInteger.ONE) == 1)
			return i.multiply(bigIntegerFactorial(i.subtract(BigInteger.ONE)));
		else
			return BigInteger.ONE;
	}
	
	public static int findGCD(int a, int b) {
		if (b==0) return a;
		return findGCD(b,a%b);
	}
	
	public static void calculatePermutations(List<Integer> objects, List<BigInteger> permutations, int k) {
		
		for (int i = k; i < objects.size(); i++) {
            Collections.swap(objects, i, k);
            calculatePermutations(objects, permutations, k+1);
            Collections.swap(objects, k, i);
		}
		
		if (k == objects.size()-1){
			String number = "";
			for (int i = 0; i < objects.size(); i++) {
				int num = objects.get(i);
				number += Integer.toString(num);
			}			
            permutations.add(new BigInteger(number));
        }
	}

	public static boolean isPermutationList(List<Integer> ariSeq) {
		List<List<Integer>> digits = new ArrayList<>();
		for (Integer permutation : ariSeq) {
			List<Integer> permuDigits = getDigits(permutation);
			digits.add(permuDigits);
		}		
		
		for (List<Integer> list : digits) {
			Collections.sort(list);
		}
		
		for (int i = 0; i < digits.size() - 1; i++) {
			if (!digits.get(i).equals(digits.get(i+1)))
				return false;
		}
		return true;
	}
}
