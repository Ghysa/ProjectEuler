package Q51_60;

import java.util.ArrayList;
import java.util.Collections;
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

public class Hand implements Comparable<Hand> {
	List<Card> cards = new ArrayList<>();
	HandRank handRank;
	
	public Hand(List<Card> cards) {
		if (cards.size() != 5)
			throw new IllegalArgumentException("Too many or not enough cards.");
		this.cards = cards;
		Collections.sort(this.cards);
		this.handRank = calculateHandRank();
	}
	
	public Card getHighestCard() {
		Card highest = this.cards.get(0);
		for (Card card : this.cards) {
			if (Rank.compare(card.getRank(), highest.getRank())) {
				highest = card;
			}
		}
		return highest;
	}
	
	public HandRank calculateHandRank() {
		if (isRoyalFlush() != null) {
			return HandRank.ROYAL_FLUSH;
		} else if (isStraightFlush() != null) {
			return HandRank.STRAIGHT_FLUSH;
		} else if (isFourOfAKind() != null) {
			return HandRank.FOUR_OF_A_KIND;
		} else if (isFullHouse() != null) {
			return HandRank.FULL_HOUSE;
		} else if (isFlush() != null) {
			return HandRank.FLUSH;
		} else if (isStraight() != null) {
			return HandRank.STRAIGHT;
		} else if (isThreeOfAKind() != null) {
			return HandRank.THREE_OF_A_KIND;
		} else if (isTwoPair() != null) {
			return HandRank.TWO_PAIRS;
		} else if (isOnePair() != null) {
			return HandRank.ONE_PAIR;
		} else {
			return HandRank.HIGH_CARD;
		}
	}
	
	public Card isOnePair() {
		for (Card card : this.cards) {
			for (Card compCard : this.cards) {
					if (card.getRank() == compCard.getRank() && card != compCard) {
						return card;
					}
			}
		}
		return null;
	}
	
	public Card isTwoPair() {
		int count = 0;
		Card highest = new Card("2C");
		for (Card card : this.cards) {
			for (Card compCard : this.cards) {
				if (card != compCard) {
					if (card.getRank() == compCard.getRank()) {
						count++;
						if (Rank.compare(card.getRank(), highest.getRank())) {
							highest = card;
						}
					}
				}
			}
		}
		if (count == 4) { // each pair is counted twice...
			return highest;
		}
		return null;
	}
	
	public Card isThreeOfAKind() {
		for (Card card : this.cards) {
			for (Card secondCard : this.cards) {
				if (card.getRank() == secondCard.getRank() && card != secondCard) {
					for (Card thirdCard : this.cards) {
						if (secondCard.getRank() == thirdCard.getRank() && (secondCard != thirdCard && card != thirdCard)) {
							return card;
						}
					}
				}
			}
		}
		return null;
	}
	
	public Card isStraight() {
		for (Card card : this.cards) {
			for (Card secondCard : this.cards) {
				if (card.getRank().getRank()+1 == secondCard.getRank().getRank()) {
					for (Card thirdCard : this.cards) {
						if (secondCard.getRank().getRank()+1 == thirdCard.getRank().getRank()) {
							for (Card fourthCard : this.cards) {
								if (thirdCard.getRank().getRank()+1 == fourthCard.getRank().getRank()) {
									for (Card fifthCard : this.cards) {
										if (fourthCard.getRank().getRank()+1 == fifthCard.getRank().getRank()) {
											return fifthCard;
										}											
									}
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	public Card isFlush() {
		Suit suit = this.cards.get(0).getSuit();
		if ( suit == this.cards.get(1).getSuit() 
				&& suit == this.cards.get(2).getSuit()
				&& suit == this.cards.get(3).getSuit()
				&& suit == this.cards.get(4).getSuit()) {
			return getHighestCard();
		}
		return null;
	}
	
	public Card isFullHouse() {
		for (Card card : this.cards) {
			for (Card secondCard : this.cards) {
				if (card.getRank() == secondCard.getRank() && card != secondCard) {
					for (Card thirdCard : this.cards) {
						if (card.getRank() == thirdCard.getRank() && (secondCard != thirdCard && card != thirdCard)) {
							for (Card fourthCard : this.cards) {
								for (Card fifthCard : this.cards){
									if (fourthCard.getRank() == fifthCard.getRank() && (fourthCard.getRank() != card.getRank() && fourthCard != fifthCard)) {
										return card;
									}
								}
							}
						}
					}
				}
			}
		}			
		return null;
	}
	
	public Card isFourOfAKind() {
		for (Card card : this.cards) {
			for (Card secondCard : this.cards) {
				if (card.getRank() == secondCard.getRank() && card != secondCard) {
					for (Card thirdCard : this.cards) {
						if (card.getRank() == thirdCard.getRank() && (secondCard != thirdCard && card != thirdCard)) {
							for (Card fourthCard : this.cards) {
								if (card.getRank() == fourthCard.getRank() && (thirdCard != fourthCard && (secondCard != fourthCard && card != fourthCard))) {
									return card;
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	public Card isStraightFlush() {
		if (isFlush() == null) {
			return null;
		}
		return isStraight();
	}
	
	public Card isRoyalFlush() {
		if (isStraightFlush() == null) {
			return null;
		}
		
		Card highest = getHighestCard();
		if (highest.getRank() == Rank.ACE) {
			return highest;
		}
		
		return null;
	}
	
	public int compareTo(Hand hand) {
		int compHandRank = this.handRank.compareTo(hand.getHandRank());
		if (compHandRank == 0) {
			if (this.handRank == HandRank.ROYAL_FLUSH) {
				return this.getHighestCard().compareTo(hand.getHighestCard());
			} else if (this.handRank == HandRank.STRAIGHT_FLUSH) {
				return this.getHighestCard().compareTo(hand.getHighestCard());
			} else if (this.handRank == HandRank.FOUR_OF_A_KIND) {
				return this.getHighestCard().compareTo(hand.getHighestCard());
			} else if (this.handRank == HandRank.FULL_HOUSE) {
				Card thisHighest = this.isFullHouse();
				Card handHighest = hand.isFullHouse();
				return thisHighest.compareTo(handHighest);
			} else if (this.handRank == HandRank.FLUSH) {
				for (int i = this.cards.size()-1; i >= 0; i--) {
					Card thisHighest = this.cards.get(i);
					Card handHighest = hand.getCards().get(i);
					if (thisHighest.compareTo(handHighest) == 0) {
						continue;
					} else {
						return thisHighest.compareTo(handHighest);
					}
				}
			} else if (this.handRank == HandRank.STRAIGHT) {
				return this.getHighestCard().compareTo(hand.getHighestCard());
			} else if (this.handRank == HandRank.THREE_OF_A_KIND) {
				Card thisHighest = this.isThreeOfAKind();
				Card handHighest = hand.isThreeOfAKind();
				return thisHighest.compareTo(handHighest);
			} else if (this.handRank == HandRank.TWO_PAIRS) { // INCOMPLETE!
				Card thisHighest = this.isTwoPair();
				Card handHighest = hand.isTwoPair();
				return thisHighest.compareTo(handHighest);				
			} else if (this.handRank == HandRank.ONE_PAIR) {
				Card thisHighest = this.isOnePair();
				Card handHighest = hand.isOnePair();
				if (thisHighest.getRank().compareTo(handHighest.getRank()) == 0) {
					for (int i = this.cards.size()-1; i >= 0; i--) {
						Card thisKicker = this.cards.get(i);
						Card handKicker = hand.getCards().get(i);
						if (thisKicker.getRank().compareTo(handKicker.getRank()) == 0 || thisKicker.getRank() == thisHighest.getRank()) {
							continue;
						} else {
							return thisKicker.getRank().compareTo(handKicker.getRank());
						}
					}
				} else {
					return thisHighest.getRank().compareTo(handHighest.getRank());
				}
			} else if (this.handRank == HandRank.HIGH_CARD) {
				for (int i = this.cards.size()-1; i >= 0; i--) {
					Card thisHighest = this.cards.get(i);
					Card handHighest = hand.getCards().get(i);
					if (thisHighest.getRank().compareTo(handHighest.getRank()) == 0) {
						continue;
					} else {
						return thisHighest.getRank().compareTo(handHighest.getRank());
					}
				}
				for (int i = this.cards.size()-1; i >= 0; i--) {
					Card thisHighest = this.cards.get(i);
					Card handHighest = hand.getCards().get(i);
					if (thisHighest.getSuit().compareTo(handHighest.getSuit()) == 0) {
						continue;
					} else {
						return thisHighest.getSuit().compareTo(handHighest.getSuit())*-1;
					}
				}
			}
			return 0;
			
		} else {
			return compHandRank;
		}
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
