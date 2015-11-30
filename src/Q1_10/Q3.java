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
public class Q3 {
    public static long largestPrimeFactor(long num) {
        long result = 0;
        long d = 2;
        
        while (num > 1) {
            while (num % d == 0) {
                result = d;
                num /= d;
            }
            d++;
        }
        
        return result;
    }
}
