package pojecteuler;

import java.util.ArrayList;
import java.util.List;

enum HandRank {
	HIGH_CARD(1),
	ONE_PAIR(2),
	TWO_PAIRS(3),
	THREE_OF_A_KIND(4),
	STRAIGHT(5),
	FLUSH(6),
	FULL_HOUSE(7),
	FOUR_OF_A_KIND(8),
	STRAIGHT_FLUSH(9),
	ROYAL_FLUSH(10);
	HandRank (int rank) {
		this.rank = rank;
	}
	private int rank;
	public int getRank() {
		return this.rank;
	}
	public static boolean compare (HandRank _1, HandRank _2) {
		if (_1.rank > _2.rank) {
			return true;
		}
		return false;
	}
}

public class Hand {
	List<Card> cards = new ArrayList<>();
	HandRank handRank;
	
	public Hand(List<Card> cards) {
		if (cards.size() != 5)
			throw new IllegalArgumentException("Too many or not enough cards.");
		this.cards = cards;
		this.handRank = calculateHandRank();
	}
	
	public HandRank calculateHandRank() {
		return HandRank.ROYAL_FLUSH;
	}
	
	public boolean isOnePair() {
		for (Card card : this.cards) {
			for (Card compCard : this.cards) {
				if (card != compCard) {
					if (card.getRank() == compCard.getRank()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isTwoPair() {
		int count = 0;
		for (Card card : this.cards) {
			for (Card compCard : this.cards) {
				if (card != compCard) {
					if (card.getRank() == compCard.getRank()) {
						count++;
						System.out.println("pair found");
					}
				}
			}
		}
		if (count == 4) // each pair is counted twice...
			return true;
		return false;
	}
	
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public HandRank getHandRank() {
		return handRank;
	}
	public void setHandRank(HandRank handRank) {
		this.handRank = handRank;
	}
	
}
