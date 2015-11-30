/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q11_20;

/**
 *
 * @author Sam
 */
public class Q18 {
    public static int maximumPathSum() {
        int result = 0;
        
        String tri = "75 " +
            "95 64 " +
            "17 47 82 " +
            "18 35 87 10 " +
            "20 04 82 47 65 " +
            "19 01 23 75 03 34 " +
            "88 02 77 73 07 63 67 " +
            "99 65 04 28 06 16 70 92 " +
            "41 41 26 56 83 40 80 70 33 " +
            "41 48 72 33 47 32 37 16 94 29 " +
            "53 71 44 65 25 43 91 52 97 51 14 " +
            "70 11 33 28 77 73 17 78 39 68 17 57 " +
            "91 71 52 38 17 14 91 43 58 50 27 29 48 " +
            "63 66 04 68 89 53 67 30 73 16 69 87 40 31 " +
            "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
        
        String[] triangle = tri.split(" ");
        int[] numbers = new int[triangle.length+1];
        
        for (int i = 0; i < triangle.length; i++) {
            numbers[i] = Integer.parseInt(triangle[i]);
        }
        int row, pos = 1;
        
        for (row = 1; row < 15; row++) {
        	for (pos = 1; pos <= row; pos++) {
        		
        		int current = numbers[Q18.calculateIndex(row, pos)];
        		System.out.println("current: " + current);
        		System.out.println("row: " + row);
        		System.out.println("pos: " + pos);
        		
        		//trivial cases
        		if (pos == 1) {
        			// always have to add current to left child but maybe not to right child?
        			numbers[Q18.calculateIndex(row+1, pos)] += current;
        			int rightOfCurrent = numbers[Q18.calculateIndex(row, pos+1)];
        			// same on the right side
        			if (current > rightOfCurrent || row == 1)
        				numbers[Q18.calculateIndex(row+1, pos+1)] += current;
        		} else if (pos == row) {
        			numbers[Q18.calculateIndex(row+1, pos+1)] += current;
        			int leftOfCurrent = numbers[Q18.calculateIndex(row, pos-1)];
        			// add current value to left child but only if it's bigger than the left neighbor
        			if (current > leftOfCurrent)
        				numbers[Q18.calculateIndex(row+1, pos)] += current;
        		} else {
        			int leftOfCurrent = numbers[Q18.calculateIndex(row, pos-1)];
        			int rightOfCurrent = numbers[Q18.calculateIndex(row, pos+1)];
        			System.out.println("leftOfCurrent: " + leftOfCurrent);
        			System.out.println("RightOfCurrent: " + rightOfCurrent);
        			
        			// add current value to left child but only if it's bigger than the left neighbor
        			if (current >= leftOfCurrent) // equal sign is very important! (you can figure out why)
        				numbers[Q18.calculateIndex(row+1, pos)] += current;
        			// same on the right side
        			if (current > rightOfCurrent)
        				numbers[Q18.calculateIndex(row+1, pos+1)] += current;
        		}
        	}
        }
        
        row = 15;
        for (pos = 1; pos <= 15; pos++) {
        	if (numbers[Q18.calculateIndex(row, pos)] > result) {
        		result = numbers[Q18.calculateIndex(row, pos)];
        	}        	
        }
        
        
        return result;
    }
    
    public static int calculateIndex(int row, int pos) {
    	int index = 0;
    	
    	for (int i = 1; i < row; i++) {
    		index += i;
    	}
    	
    	index += pos - 1;
    	
    	return index;
    }
}
