/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Sam
 */
public class Q10 {
    public static long summationOfPrimes (int limit) {
        long result = 0;
        
        List<Boolean> primes = new ArrayList<>(Arrays.asList(new Boolean[limit]));
        Collections.fill(primes, Boolean.TRUE);
        
        for (int i = 2; i <= Math.sqrt(limit); i++) {
            if (primes.get(i) == true) {
                for (int j = (i*i); j < limit; j += i) {
                    primes.set(j, Boolean.FALSE);
                }
            }
        }
        
        for (int i = 2; i < limit; i++) {
            if (primes.get(i) == true)
                result += i;
        }
        
        return result;
    }
}
