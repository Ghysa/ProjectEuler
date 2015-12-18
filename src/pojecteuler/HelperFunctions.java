package pojecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	
	public static Map<Integer, Integer> findPrimeFactorsAndMultiplicity(int number) {
		List<Integer> primeFactors = findPrimeFactors(number);
		Set<Integer> primeFactorsSet = new HashSet<>(primeFactors);
		Map<Integer, Integer> map = new HashMap<>();
		
		for (Integer prime : primeFactorsSet) {
			map.put(prime, Collections.frequency(primeFactors, prime));
		}
		
		return map;
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
	
	public static List<Integer> getDigitsString(String number) {
		List<Integer> list = new ArrayList<>();
		char[] ca = number.toCharArray();
		for (char c : ca) {
			list.add(Character.getNumericValue(c));
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
	
	public static boolean isPermutation(int number1, int number2) {
		List<Integer> digitsN1 = getDigits(number1);
		List<Integer> digitsN2 = getDigits(number2);
		
		Collections.sort(digitsN1);
		Collections.sort(digitsN2);
		
		if (digitsN1.equals(digitsN2)) {
			return true;
		}
		return false;
	}

	public static boolean isPalindromeBase10(int number) {
		String num = Integer.toString(number);
		return isPalindromeString(num);
	}
	
	public static boolean isPalindromeBase2(int number) {
		String num = Integer.toBinaryString(number);
		return isPalindromeString(num);
	}

	public static boolean isPalindromeString(String string) {
		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length/2; i++) {
			if (chars[i] != chars[chars.length-i-1])
				return false;
		}
		return true;
	}

	public static int reverseInt(int number) {
		return Integer.parseInt(reverseString(Integer.toString(number)));
	}
	
	public static BigInteger reverseBigInt(BigInteger number) {
		return new BigInteger(reverseString(number.toString()));
	}

	public static String reverseString(String num) {
		char[] ca = num.toCharArray();
		List<Character> li = new ArrayList<>();
		for (char c : ca) {
			li.add(c);
		}
		Collections.reverse(li);
		return stringFromCharacterList(li);
	}

	public static String stringFromCharacterList(List<Character> li) {
		StringBuilder str = new StringBuilder();
		for (Character c : li) {
			str.append(c);
		}		
		return str.toString();
	}

	public static int sumOfDigitsInt(int number) {
		return sumOfDigitsString(Integer.toString(number));
	}

	public static int sumOfDigitsBigInt(BigInteger number) {
		return sumOfDigitsString(number.toString());
	}
	
	public static int sumOfDigitsString(String num) {
		int result = 0;
		char[] arr = num.toCharArray();        
        for (char c : arr) {
            result += Character.getNumericValue(c);
        }        
        return result;
	}

	public static int concatenateInts(int num1, int num2) {
		return Integer.parseInt(String.valueOf(num1) + String.valueOf(num2));
	}

	public static List<Integer> generateTriangleNumbers(int min, int max) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		for (int n = 2; list.get(list.size()-1) < max; n++) {
			if (n*(n+1)/2 > min)
				list.add(n*(n+1)/2);
		}
		
		list.remove(list.size()-1);
		if (min > 1)
			list.remove(0);
		return list;
	}
	
	public static List<Integer> generateSquareNumbers(int min, int max) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		for (int n = 2; list.get(list.size()-1) < max; n++) {
			if(n*n > min)
				list.add(n*n);
		}
		
		list.remove(list.size()-1);
		if (min > 1)
			list.remove(0);
		return list;
	}

	public static List<Integer> generatePentagonalNumbers(int min, int max) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		for (int n = 2; list.get(list.size()-1) < max; n++) {
			if (n*(3*n-1)/2 > min)
				list.add(n*(3*n-1)/2);
		}
		
		list.remove(list.size()-1);
		if (min > 1)
			list.remove(0);
		return list;
	}
	
	public static List<Integer> generateHexagonalNumbers(int min, int max) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		for (int n = 2; list.get(list.size()-1) < max; n++) {
			if (n*(2*n-1) > min)
				list.add(n*(2*n-1));
		}
		
		list.remove(list.size()-1);
		if (min > 1)
			list.remove(0);
		return list;
	}
	
	public static List<Integer> generateHeptagonalNumbers(int min, int max) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		for (int n = 2; list.get(list.size()-1) < max; n++) {
			if (n*(5*n-3)/2 > min)
				list.add(n*(5*n-3)/2);
		}
		
		list.remove(list.size()-1);
		if (min > 1)
			list.remove(0);
		return list;
	}
	
	public static List<Integer> generateOctagonalNumbers(int min, int max) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		
		for (int n = 2; list.get(list.size()-1) < max; n++) {
			if (n*(3*n-2) > min)
				list.add(n*(3*n-2));
		}
		
		list.remove(list.size()-1);
		if (min > 1)
			list.remove(0);
		return list;
	}

	public static int getFactorialDigitSum(int number) {
		int result = 0;
		List<Integer> digits = getDigits(number);
		
		for(Integer digit : digits) {
			result += factorialRecursive(digit);
		}
		
		return result;
	}


	public static List<Integer> getDivisors(int number) {
		Map<Integer, Integer> primes = findPrimeFactorsAndMultiplicity(number);
		List<Integer> divisors = new ArrayList<>();
		List<List<Integer>> temp = new ArrayList<>();
		
		for (Integer prime : primes.keySet()) {
			List<Integer> factorList = new ArrayList<>();
			int factor = 1;
			for (int i = 1; i <= primes.get(prime); i++) {
				factor *= prime;
				factorList.add(factor);
			}
			temp.add(factorList);
		}
		for (int i = 0; i < temp.size(); i++) {
			for (int j = 0; j < temp.get(i).size(); j++) {
				// TODO: multiply every element of each list with each other.
			}
		}
		
		return divisors;
	}
	
	public static int numberOfRelativePrimes(int number) {
		List<Integer> factors = HelperFunctions.findDistinctPrimeFactors(number);
		Set<Integer> nonRelPrimes = new HashSet<>();
		
		for (Integer factor : factors) {
			for (int i = 1, result = 0; result < number; i++) {
				result = factor * i;
				nonRelPrimes.add(result);
			}
		}
		
		return number - nonRelPrimes.size();
	}
}
