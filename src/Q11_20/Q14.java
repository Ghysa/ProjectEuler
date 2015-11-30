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
public class Q14 {
    public static long longestCollatzSequence (int limit) {
        long result = 0;
        long temp;
        
        int length;
        int resultLength = 1;
        
        for (int i = 2; i <= limit; i++) {
            temp = i;
            length = 1;
            while (temp != 1) {
                if ((temp%2) == 0) {
                    temp = temp / 2;
                } else {
                    temp = (temp * 3) + 1;
                }
                length++;
                
            }
            System.out.println("i : " + i + " length: " + length);
            if (length > resultLength) {
                resultLength = length;
                result = i;
            }
        }        
        return result;
    }
}
