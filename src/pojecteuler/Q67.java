package pojecteuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Q11_20.Q18;

public class Q67 {
	public static int maximumPathSum() {
		int result = 0;
		
		List<Integer> numbers = new ArrayList<>();
		try {
			for (String line : Files.readAllLines(Paths.get("res/p067_triangle.txt"))) {
			    for (String part : line.split("\\s+")) {
			    	if (HelperFunctions.isNumeric(part)) {
				        Integer i = Integer.valueOf(part);
				        numbers.add(i);
			    	}
			    }
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		int[] nums = new int[numbers.size()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = numbers.get(i);
		}
		
		int row, pos;
        
        for (row = 1; row < 100; row++) {
        	for (pos = 1; pos <= row; pos++) {
        		
        		int current = nums[Q18.calculateIndex(row, pos)];
        		System.out.println("current: " + current);
        		System.out.println("row: " + row);
        		System.out.println("pos: " + pos);
        		
        		//trivial cases
        		if (pos == 1) {
        			// always have to add current to left child but maybe not to right child?
        			nums[Q18.calculateIndex(row+1, pos)] += current;
        			int rightOfCurrent = nums[Q18.calculateIndex(row, pos+1)];
        			// same on the right side
        			if (current > rightOfCurrent || row == 1)
        				nums[Q18.calculateIndex(row+1, pos+1)] += current;
        		} else if (pos == row) {
        			nums[Q18.calculateIndex(row+1, pos+1)] += current;
        			int leftOfCurrent = nums[Q18.calculateIndex(row, pos-1)];
        			// add current value to left child but only if it's bigger than the left neighbor
        			if (current > leftOfCurrent)
        				nums[Q18.calculateIndex(row+1, pos)] += current;
        		} else {
        			int leftOfCurrent = nums[Q18.calculateIndex(row, pos-1)];
        			int rightOfCurrent = nums[Q18.calculateIndex(row, pos+1)];
        			System.out.println("leftOfCurrent: " + leftOfCurrent);
        			System.out.println("RightOfCurrent: " + rightOfCurrent);
        			
        			// add current value to left child but only if it's bigger than the left neighbor
        			if (current >= leftOfCurrent) // equal sign is very important! (you can figure out why)
        				nums[Q18.calculateIndex(row+1, pos)] += current;
        			// same on the right side
        			if (current > rightOfCurrent)
        				nums[Q18.calculateIndex(row+1, pos+1)] += current;
        		}
        	}
        }
        
        row = 100;
        for (pos = 1; pos <= 100; pos++) {
        	if (nums[Q18.calculateIndex(row, pos)] > result) {
        		result = nums[Q18.calculateIndex(row, pos)];
        	}
        	System.out.println(nums[Q18.calculateIndex(row, pos)]);
        }
		
		return result;
	}
}
