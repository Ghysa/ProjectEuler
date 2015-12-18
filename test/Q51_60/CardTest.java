package Q51_60;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardTest {
	
	@Test
	public void cardsShouldHaveCorrectRankAndSuit() {
		Card card1 = new Card("3H");
		Card card2 = new Card("KD");
		Card card3 = new Card("TS");
		Card card4 = new Card("7C");
		
		assertEquals("Must be 3", Rank.THREE, card1.getRank());
		assertEquals("Must be Hearts", Suit.HEARTS, card1.getSuit());
		assertEquals("Must be King", Rank.KING, card2.getRank());
		assertEquals("Must be Diamonds", Suit.DIAMONDS, card2.getSuit());
		assertEquals("Must be 10", Rank.TEN, card3.getRank());
		assertEquals("Must be Spades", Suit.SPADES, card3.getSuit());
		assertEquals("Must be 7", Rank.SEVEN, card4.getRank());
		assertEquals("Must be Clubs", Suit.CLUBS, card4.getSuit());
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testWrongCardArguments() throws IllegalArgumentException {
		Card card = new Card("Wrong Argument");
	}
}
