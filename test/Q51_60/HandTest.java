package Q51_60;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HandTest {

	@Test
	public void testIsTwoPair() {
		List<Card> cards = new ArrayList<>();
		cards.add(new Card("AC"));
		cards.add(new Card("AD"));
		cards.add(new Card("5D"));
		cards.add(new Card("7H"));
		cards.add(new Card("7D"));
		
		Hand hand = new Hand(cards);
		
		assertNotNull("This is not Two Pair.", hand.isTwoPair());
	}

}
