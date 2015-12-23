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
		
    	System.out.println("result: " + Q82.pathSumThreeWay());
    	
    	System.out.println((System.currentTimeMillis()-startTime)+" ms");
    }
    
}
