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
public class Q5 {
    public static long smallestMultiple (int maxNum) {
        long result = 1;
        boolean divAll = false;
        
        for (int i = maxNum; i >= 2; i--) {
            if (result % i != 0)
                result *= i;
        }
        
        for (int i = 2; i <= maxNum; i++) {
            while (result % i == 0) {
                result /= i;
                for (int j = 2; j <= maxNum; j++) {
                    if (result % j != 0)
                        break;
                    else
                        if (j == maxNum)
                            divAll = true;
                }
                if (divAll != true) {
                    result *= i;
                    divAll = false;
                    break;
                }                    
                divAll = false;
            }
        }
        
        return result;
    }
}
