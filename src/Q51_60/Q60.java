package Q51_60;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pojecteuler.HelperFunctions;

public class Q60 {
	public static int primePairSets() {
		int result = 9999999;
		int max = 10000;
		
		List<Integer> primes = HelperFunctions.findPrimes(max);
		List<Integer> primesBig = HelperFunctions.findPrimes(max*max);
		Set<Integer> containsSet = new HashSet<>(primesBig);
		
		// 2 & 5 are impossible
		primes.remove(0);
		primes.remove(1);
		
		System.out.println(primes);
		
		for (int i = 0; i < primes.size(); i++) {
			for (int j = i+1; j < primes.size(); j++) {
				if (containsSet.contains(HelperFunctions.concatenateInts(primes.get(i), primes.get(j))) == false 
						|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(j), primes.get(i))) == false
						|| primes.get(i).equals(primes.get(j))) {
					continue;
				}
				for (int k = j+1; k < primes.size(); k++) {
					if (containsSet.contains(HelperFunctions.concatenateInts(primes.get(i), primes.get(k))) == false 
							|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(k), primes.get(i))) == false
							|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(j), primes.get(k))) == false 
							|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(k), primes.get(j))) == false
							|| primes.get(i).equals(primes.get(k)) || primes.get(j).equals(primes.get(k))) {
						continue;
					}
					for (int l = k+1; l < primes.size(); l++) {
						if (containsSet.contains(HelperFunctions.concatenateInts(primes.get(i), primes.get(l))) == false 
								|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(l), primes.get(i))) == false
								|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(j), primes.get(l))) == false 
								|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(l), primes.get(j))) == false
								|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(k), primes.get(l))) == false 
								|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(l), primes.get(k))) == false
								|| primes.get(i).equals(primes.get(l)) || primes.get(j).equals(primes.get(l))
								|| primes.get(k).equals(primes.get(l))) {
							continue;
						}
						for (int m = l+1; m < primes.size(); m++) {
							if (containsSet.contains(HelperFunctions.concatenateInts(primes.get(i), primes.get(m))) == false 
									|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(m), primes.get(i))) == false
									|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(j), primes.get(m))) == false 
									|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(m), primes.get(j))) == false
									|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(k), primes.get(m))) == false 
									|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(m), primes.get(k))) == false
									|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(l), primes.get(m))) == false 
									|| containsSet.contains(HelperFunctions.concatenateInts(primes.get(m), primes.get(l))) == false
									|| primes.get(i).equals(primes.get(m)) || primes.get(j).equals(primes.get(m))
									|| primes.get(k).equals(primes.get(m)) || primes.get(l).equals(primes.get(m))) {
								continue;
							}
							List<Integer> list = new ArrayList<>();
							list.add(primes.get(i));
							list.add(primes.get(j));
							list.add(primes.get(k));
							list.add(primes.get(l));
							list.add(primes.get(m));
							
							System.out.println(list);
							int tempResult = 0;
							for (Integer sum : list) {
								tempResult += sum;
							}
							if (tempResult < result) {
								result = tempResult;
							}
						}
					}
				}
			}
			System.out.println(primes.get(i));
		}
		
		return result;
	}
	
	public static Set<Integer> findAllCombinations(List<Integer> list) {
		Set<Integer> set = new HashSet<>();
		
		for (Integer i1 : list) {
			for (Integer i2 : list) {
				if (i1.equals(i2)) {
					continue;
				}
				StringBuilder str = new StringBuilder(String.valueOf(i1));
				str.append(String.valueOf(i2));
				set.add(Integer.parseInt(str.toString()));
			}
		}
		
		return set;
	}
}
