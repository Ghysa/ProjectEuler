/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1_10;

/**
 *
 * @author Sam
 */
public class Q6 {
    public static long sumSquareDifference (int numbers) {
        long result = 0;
        long sumOfSquares = 0;
        long squareOfSum = 0;
        
        for (int i = 1; i <= numbers; i++) {
            sumOfSquares += (i * i);
        }
        
        for (int i = 1; i <= numbers; i++) {
            squareOfSum += i;
        }
        
        squareOfSum = squareOfSum * squareOfSum;
        
        result = squareOfSum - sumOfSquares;
        
        return result;
    }
}
