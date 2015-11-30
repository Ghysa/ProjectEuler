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
public class Q4 {
    public static int largestPalindromeProduct (int digits) {
        int result = 0;
        
        int i,j;
        
        for (i = (int) Math.pow(10, digits) - 1; i > 1; i--) {
            for (j = (int) Math.pow(10, digits) - 1; j > 1; j--) {
                if (checkPalindrome(i*j, digits)) {
                    if (result < (i*j))
                        result = i*j;
                }
            }
        }
        
        return result;
    }

    public static boolean checkPalindrome(int product, int digits) {
        boolean isPalindrome = false;
        
        if (product < (int) Math.pow(10, (digits*2) - 1))
            return isPalindrome;
        
        String prod = Integer.toString(product);
        char[] p = prod.toCharArray();
        char[] front = new char[digits];        
        char[] end = new char[digits];
        
        for (int i = 0; i < digits*2; i++) {
            if (i < digits)
                front[i] = p[i];
            else
                end[digits*2 - i - 1] = p[i];
            
        }
        String f = new String(front);
        String e = new String(end);
        
        int comp = f.compareTo(e);
        
        if (comp == 0)
            isPalindrome = true;
        
        return isPalindrome;
    }
}
