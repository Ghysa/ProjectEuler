/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojecteuler;

/**
 *
 * @author Sam
 */
public class ProjectEuler {
	
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	long startTime = System.currentTimeMillis();
    	
//    	List<Integer> list = new ArrayList<>();
//    	list.add(2389);
//    	list.add(8956);
//    	list.add(5621);
//    	list.add(2578);
//    	list.add(7823);
    	
    	System.out.println("result: " + Q70.totientPermutation(10000000));
    	
    	System.out.println((System.currentTimeMillis()-startTime)+" ms");
    }
    
}
