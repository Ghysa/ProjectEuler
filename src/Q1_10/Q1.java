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
public class Q1 {
    
    public static int multiplesOf3And5 (int num) {
        int result = 0;
        
        for (int i = 0; i < num; i++) {
            if (i % 3 == 0)
                result += i;
            else if (i % 5 == 0)
                result += i;
        }
        return result;
    }
}
