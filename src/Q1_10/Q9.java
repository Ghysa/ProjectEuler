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
public class Q9 {
    public static int specialPythTriplet (int num) {
        int result = 0;
        boolean resultFound = false;
        
        for (int i = 2; i < num; i++) {
            for (int j = 2; j < num; j++) {
                for (int k = 2; k < num; k++) {
                    if ( ((i*i) + (j*j)) == (k*k) ) {
                        if ((i + j + k) == num) {
                            result = i * j * k;
                            resultFound = true;
                            break;
                        }
//                        List<Integer> triplet = new ArrayList<>();
//                        triplet.add(i*i);
//                        triplet.add(j*j);
//                        triplet.add(k*k);
//                        list.add(triplet);
                    }
                        
                }
                if (resultFound == true)
                    break;
            }
            if (resultFound == true)
                    break;
        }
        
        return result;
    }
}
