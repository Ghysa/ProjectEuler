package pojecteuler;

import java.util.ArrayList;
import java.util.List;

public class Q61 {
	public static int cyclicalFigurateNumbers() {
		int result = 0;
		int min = 1000, max = 10000;
		
		List<Integer> triangle = HelperFunctions.generateTriangleNumbers(min, max);
		List<Integer> square = HelperFunctions.generateSquareNumbers(min, max);
		List<Integer> pentagonal = HelperFunctions.generatePentagonalNumbers(min, max);
		List<Integer> hexagonal = HelperFunctions.generateHexagonalNumbers(min, max);
		List<Integer> heptagonal = HelperFunctions.generateHeptagonalNumbers(min, max);
		List<Integer> octagonal = HelperFunctions.generateOctagonalNumbers(min, max);
		
		int[] solution = new int[6];
		List<List<Integer>> numbers = new ArrayList<>();
		numbers.add(triangle);
		numbers.add(square);
		numbers.add(pentagonal);
		numbers.add(hexagonal);
		numbers.add(heptagonal);
		numbers.add(octagonal);
		
		System.out.println(numbers);
		
		for (int i = 0; i < numbers.get(i).size(); i++) {
			
		}

		return result;
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
