/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q11_20;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class Q12 {
    public static int highlyDivisibleTriangularNumber (int limit) {
        int result = 0;
        
        int temp = 0;
        
        List<Integer> triangleNumbers = new ArrayList<>();
        
        for (int i = 0; i <= limit; i++) {
            temp += i;
            triangleNumbers.add(temp);
        }
        
        
        int i = 1;
        for (int t : triangleNumbers) {
            List<Integer> div = new ArrayList<>();
            
            //slow :-(
            while (i <= t) {
                if (t%i == 0)
                    div.add(i);
                i++;
            }
            System.out.println("t: " + t + " : " + div.size());
            if (div.size() > 500) {
                result = t;
                break;
            }                
            div.clear();
            i = 1;
        }
        
        return result;
    }
}
