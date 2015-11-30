/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojecteuler;

import java.util.ArrayList;
import java.util.List;

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
    	
    	List<Card> cards = new ArrayList<>();
    	cards.add(new Card("3S"));
    	cards.add(new Card("QD"));
    	cards.add(new Card("QD"));
    	cards.add(new Card("AD"));
    	cards.add(new Card("AC"));
    	Hand hand = new Hand(cards);
    	
    	System.out.println("result: " + hand.isTwoPair());
    	
    	System.out.println((System.currentTimeMillis()-startTime)+" ms");
    }
    
}
