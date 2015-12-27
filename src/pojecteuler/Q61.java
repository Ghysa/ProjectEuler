package pojecteuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q61 {
	private static final int min = 1000, max = 10000; // 4 digit numbers
	private static final List<Integer> triangle = HelperFunctions.generateTriangleNumbers(min, max);
	private static final Set<Integer> triangleSet = new HashSet<>(triangle);
	private static final List<Integer> square = HelperFunctions.generateSquareNumbers(min, max);
	private static final Set<Integer> squareSet = new HashSet<>(square);
	private static final List<Integer> pentagonal = HelperFunctions.generatePentagonalNumbers(min, max);
	private static final Set<Integer> pentaSet = new HashSet<>(pentagonal);
	private static final List<Integer> hexagonal = HelperFunctions.generateHexagonalNumbers(min, max);
	private static final Set<Integer> hexaSet = new HashSet<>(hexagonal);
	private static final List<Integer> heptagonal = HelperFunctions.generateHeptagonalNumbers(min, max);
	private static final Set<Integer> heptaSet = new HashSet<>(heptagonal);
	private static final List<Integer> octagonal = HelperFunctions.generateOctagonalNumbers(min, max);
	private static final Set<Integer> octaSet = new HashSet<>(octagonal);
	
	// Not pretty but it works and it is quite fast.
	public static int cyclicalFigurateNumbers() {
		// Add all numbers in one list.
		List<Integer> numbers = new ArrayList<>();
		numbers.addAll(triangle);
		numbers.addAll(square);
		numbers.addAll(pentagonal);
		numbers.addAll(hexagonal);
		numbers.addAll(heptagonal);
		numbers.addAll(octagonal);
		
		// Pick a number and then find a next number that satisfies two conditions:
		// - It is in a different set than the previous numbers
		// - The last two digits of the last number are equal to the first two digits of the new number
		// Repeat.
		for (Integer number1 : numbers) {
			boolean[] contains = new boolean[6];
			contains[inList(number1)] = true;
			for (Integer number2 : numbers) {
				if (contains[inList(number2)] == true) {
					continue;
				}
				int _1_first = first2digits(number1);
				int _1_last = last2digits(number1);
				int _2_first = first2digits(number2);
				int _2_last = last2digits(number2);
				if (_1_last != _2_first) {
					continue;
				}
				contains[inList(number2)] = true;
				for (Integer number3 : numbers) {
					if (contains[inList(number3)]) {
						continue;
					}
					int _3_first = first2digits(number3);
					int _3_last = last2digits(number3);
					if ((_2_last != _3_first)) {
						continue;
					}
					contains[inList(number3)] = true;
					for (Integer number4 : numbers) {
						if (contains[inList(number4)]) {
							continue;
						}
						int _4_first = first2digits(number4);
						int _4_last = last2digits(number4);
						if ((_3_last != _4_first)) {
							continue;
						}
						contains[inList(number4)] = true;
						for (Integer number5 : numbers) {
							if (contains[inList(number5)]) {
								continue;
							}
							int _5_first = first2digits(number5);
							int _5_last = last2digits(number5);
							if ((_4_last != _5_first)) {
								continue;
							}
							contains[inList(number5)] = true;
							for (Integer number6 : numbers) {
								// Since doubles are possible we will check a better method to 
								// check in which list the number is in.
								List<Integer> listIn = inLists(number6);
								boolean inLastList = false;
								for (int i = 0; i < listIn.size(); i++) {
									if (contains[listIn.get(i)] == false) {
										inLastList = true;
									}
								}
								if (inLastList == false) {
									continue;
								}
								int _6_first = first2digits(number6);
								int _6_last = last2digits(number6);
								if ((_5_last != _6_first)) {
									continue;
								}
								if (_6_last == _1_first) {
									return number1+number2+number3+number4+number5+number6;
								}
							}
						}
					}
				}
			}
		}

		return -1;
	}
	
	private static List<Integer> inLists(Integer number) {
		List<Integer> list = new ArrayList<>();
		if (triangleSet.contains(number)) {
			list.add(0);
		}
		if (squareSet.contains(number)) {
			list.add(1);
		}
		if (pentaSet.contains(number)) {
			list.add(2);
		}
		if (hexaSet.contains(number)) {
			list.add(3);
		}
		if (heptaSet.contains(number)) {
			list.add(4);
		}
		if (octaSet.contains(number)) {
			list.add(5);
		}
		return list;
	}

	public static int inList(Integer number) {
		if (triangleSet.contains(number)) {
			return 0;
		} else if (squareSet.contains(number)) {
			return 1;
		} else if (pentaSet.contains(number)) {
			return 2;
		} else if (hexaSet.contains(number)) {
			return 3;
		} else if (heptaSet.contains(number)) {
			return 4;
		} else if (octaSet.contains(number)) {
			return 5;
		}
		return -1;
	}
	
	public static boolean isCyclicList(int[] list) {
		
		for (Integer i1 : list) {
			boolean isCyclic = false;
			for (Integer i2 : list) {
				if (last2digits(i1) == first2digits(i2)) {
					isCyclic = true;
				}
			}
			if (isCyclic == false)
				return false;
		}
		
		return true;
	}
	
	public static int first2digits(int number) {
		return number / 100;
	}
	
	public static int last2digits(int number) {
		return number % 100;
	}
}
