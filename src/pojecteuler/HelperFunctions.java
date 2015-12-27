package pojecteuler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HelperFunctions {
	
	private static final BigDecimal SQRT_DIG = new BigDecimal(150);
	private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());
	
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
	
	public static int findLargestPrimeFactor(int number) {
		int factor = 0;
		int d = 2;
		while (number > 1) {
            while (number % d == 0) {
                if (factor < d) {
                	factor = d;
                }
                number /= d;
            }
            d++;
        }
		return factor;
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
	
	public static boolean isPseudoPrime(int n) {
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

	public static Map<Integer, BigInteger> continuedFractionNumerator(Map<Integer, Integer> sequence) {
		Map<Integer, BigInteger> kn = new HashMap<>();
		kn.put(-2, new BigInteger("0"));
		kn.put(-1, new BigInteger("1"));
		
		for (int i = 0; i < sequence.size(); i ++) {
			BigInteger num = new BigInteger(String.valueOf(sequence.get(i)));
			num = num.multiply(kn.get(i-1));
			num = num.add(kn.get(i-2));
			kn.put(i, num);
		}
		
		return kn;
	}
	
	public static Map<Integer, BigInteger> continuedFractionDenominator(Map<Integer, Integer> sequence) {
		Map<Integer, BigInteger> kn = new HashMap<>();
		kn.put(-2, new BigInteger("1"));
		kn.put(-1, new BigInteger("0"));
		
		for (int i = 0; i < sequence.size(); i ++) {
			BigInteger num = new BigInteger(String.valueOf(sequence.get(i)));
			num = num.multiply(kn.get(i-1));
			num = num.add(kn.get(i-2));
			kn.put(i, num);
		}
		
		return kn;
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Private utility method used to compute the square root of a BigDecimal.
	 * 
	 * @author Luciano Culacciatti 
	 * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
	 */
	private static BigDecimal sqrtNewtonRaphson  (BigDecimal c, BigDecimal xn, BigDecimal precision){
	    BigDecimal fx = xn.pow(2).add(c.negate());
	    BigDecimal fpx = xn.multiply(new BigDecimal(2));
	    BigDecimal xn1 = fx.divide(fpx,2*SQRT_DIG.intValue(),RoundingMode.HALF_DOWN);
	    xn1 = xn.add(xn1.negate());
	    BigDecimal currentSquare = xn1.pow(2);
	    BigDecimal currentPrecision = currentSquare.subtract(c);
	    currentPrecision = currentPrecision.abs();
	    if (currentPrecision.compareTo(precision) <= -1){
	        return xn1;
	    }
	    return sqrtNewtonRaphson(c, xn1, precision);
	}

	/**
	 * Uses Newton Raphson to compute the square root of a BigDecimal.
	 * 
	 * @author Luciano Culacciatti 
	 * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
	 */
	public static BigDecimal bigSqrt(BigDecimal c){
	    return sqrtNewtonRaphson(c,new BigDecimal(1),new BigDecimal(1).divide(SQRT_PRE));
	}

	public static List<BigInteger> partition(int maxN) {
		List<BigInteger> bigList = new ArrayList<>();
		bigList.add(BigInteger.ONE);
		bigList.add(BigInteger.ONE);
		bigList.add(new BigInteger("2"));
		bigList.add(new BigInteger("3"));
		
		for (int n = 4; n < maxN; n++) {
			BigInteger bigAdd = BigInteger.ZERO;
			int k = 1;
			while (n - k*(3*k-1)/2 >= 0) {
				BigInteger sign = BigInteger.ONE;
				if ((k+1) % 2 == 0) {
					sign = BigInteger.ONE;
				} else {
					sign = BigInteger.ONE.negate();
				}
				BigInteger s1 = BigInteger.ZERO;
				BigInteger s2 = BigInteger.ZERO;
				if (n - k*(3*k+1)/2 >= 0) {
					s1 = bigList.get(n - k*(3*k+1)/2);
				}
				if (n - k*(3*k-1)/2 >= 0) {
					s2 = bigList.get(n - k*(3*k-1)/2);
				}
				BigInteger sum = s1.add(s2);
				bigAdd = bigAdd.add(sign.multiply(sum));
				k++;
			}
			bigList.add(bigAdd);
		}
		return bigList;
	}

	/**
	 * A* algorithm
	 * 
	 * @author Sam Ghysels
	 */
	public static int AStar(int[][] cost, int startX, int startY, int endX, int endY, int size) {
		
		int[][] map = new int[size][size]; 	//possible values:     -1: not yet visited
											//                     -2: on the closed list
        									//                     >0: on the open list, value is the cost of that node.
		
		// Initialize empty (unvisited) map
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				map[y][x] = -1;
			}
		}
		
		int x = startX;
		int y = startY;
		
		// Create starting Node
		Node currentNode = new Node(cost[y][x], x, y, null);
		
		// Add it to a priority queue
		// We will use two priority queue's for reasons explained below.
		int qi = 0;
		PriorityQueue<Node> queue[] = new PriorityQueue[2];
		queue[0] = new PriorityQueue<>();
		queue[1] = new PriorityQueue<>();
		queue[qi].add(currentNode);
		
		// Set cost at starting point
		map[y][x] = currentNode.getCost();
		
		// Keep going until queue is empty (= no solution found)
		while(!queue[qi].isEmpty()) {
			
			// Get lowest cost Node and remove it from the queue
			currentNode = queue[qi].remove();
			x = currentNode.getxPos();
			y = currentNode.getyPos();
			
			// if destination is reached return total cost
			if (y == endY && x == endX) {
				return currentNode.getTotalCost();
			}
			
			// Check all possible directions.
			// Here: Up, Down & Right (Left is for question 82)
			for (Direction dir : Direction.values()) {
				
				// get new coordinates based on the direction
				int xdx = 0, ydy = 0;
				switch (dir) {
					case RIGHT: 
						xdx = x + 1;
						ydy = y;
						break;
					case DOWN: 
						xdx = x;
						ydy = y + 1;
						break;
					case UP: 
						xdx = x;
						ydy = y - 1;
						break;
					case LEFT:
						xdx = x - 1;
						ydy = y;
						break;
				}
				
				// check if we are still within the bounds of the matrix
				if (xdx < 0 || xdx >= size || ydy < 0 || ydy >= size) {
					continue;
				}
				// check if the new location is on the closed list
				if (map[ydy][xdx] == -2) {
					continue;
				}
				// Create new node for this location
				Node newNode = new Node(cost[ydy][xdx], xdx, ydy, currentNode);
				
				// If node is unvisited add it to the map
				if (map[ydy][xdx] == -1) {
					queue[qi].add(newNode);
					map[ydy][xdx] = newNode.getTotalCost();
				// If the total cost of the new node is smaller, replace it
				} else if (newNode.getTotalCost() < map[ydy][xdx]) {
					// Since replacing in a priority queue is impossible... 
					// We will copy all elements from one queue to the other one 
					// without the element that needs to be replaced. (is there really no better way?)
					
					// Copy until we find the element we (don't) need
					while (!queue[qi].peek().equals(newNode)) {
						queue[1-qi].add(queue[qi].remove());
					}
					// Remove element we don't need
					queue[qi].remove();
					// Cope the rest
					while(!queue[qi].isEmpty()) {
						queue[1-qi].add(queue[qi].remove());
					}
					// Add new Node
					queue[1-qi].add(newNode);
					map[ydy][xdx] = newNode.getTotalCost();
					// Switch queue
					qi = 1-qi;
				}
			}
		}
		
		// Failed if we get here since there should always be a solution...
		return -1;
	}
	
	private enum Direction {
		RIGHT,
		DOWN,
		UP,
		LEFT
	}
	

}


