/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q11_20;

import java.math.BigInteger;

/**
 *
 * @author Sam
 */
public class Q16 {
    public static int powerDigitSum (int power) {
        int result = 0;
        BigInteger pow = BigInteger.ONE;
        BigInteger two = new BigInteger("2");
        
        for (int i = 0; i < power; i++) {
            pow = pow.multiply(two);
        }
        
        String res = pow.toString();
        char[] arr = res.toCharArray();
        
        for (char c : arr) {
            result += Character.getNumericValue(c);
        }
        
        return result;
    }
}
