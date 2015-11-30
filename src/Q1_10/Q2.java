/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Q1_10;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class Q2 {
    public static int evenFibonacciNumbers (int num) {
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(2);
        int result = 0;
        
        while (fib.get(fib.size() - 1) < num) {
            fib.add(fib.get(fib.size() - 2) + fib.get(fib.size() - 1));
        }
        
        for (int i : fib) {
            if (i % 2 == 0)
                result += i;
        }
        
        return result;
    }
}
