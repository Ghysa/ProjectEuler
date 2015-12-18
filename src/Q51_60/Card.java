package Q51_60;

enum Suit {
	SPADES(1) {
		public String getChar() {
			return "S";
		}
	}, HEARTS(2) {
		public String getChar() {
			return "H";
		}
	},  DIAMONDS(3) {
		public String getChar() {
			return "D";
		}
	}, CLUBS(4) {
		public String getChar() {
			return "C";
		}
	};
	Suit(int rank) {
		this.rank = rank;
	}
	private int rank;
	public String getChar() {
		return "D";
	}
	public int getRank() {
		return this.rank;
	}
}

enum Rank {
	TWO(2) {
		public String getChar() {
			return "2";
		}
	},
	THREE(3) {
		public String getChar() {
			return "3";
		}
	},
	FOUR(4) {
		public String getChar() {
			return "4";
		}
	},
	FIVE(5) {
		public String getChar() {
			return "5";
		}
	},
	SIX(6) {
		public String getChar() {
			return "6";
		}
	},
	SEVEN(7) {
		public String getChar() {
			return "7";
		}
	},
	EIGHT(8) {
		public String getChar() {
			return "8";
		}
	},
	NINE(9) {
		public String getChar() {
			return "9";
		}
	},
	TEN(10) {
		public String getChar() {
			return "T";
		}
	},
	JACK(11) {
		public String getChar() {
			return "J";
		}
	},
	QUEEN(12) {
		public String getChar() {
			return "Q";
		}
	},
	KING(13) {
		public String getChar() {
			return "K";
		}
	},
	ACE(14) {
		public String getChar() {
			return "A";
		}
	};
	Rank(int rank) {
		this.rank = rank;
	}
	private int rank;
	public int getRank() {
		return this.rank;
	}
	public static boolean compare (Rank _1, Rank _2) {
		if (_1.rank > _2.rank) {
			return true;
		}
		return false;
	}
	public String getChar() {
		return "";
	}
}

public class Card implements Comparable<Card> {
	private Rank rank;
	private Suit suit;
	
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Card(String card) {
		if (card.length() != 2)
			throw new IllegalArgumentException("For input string: " + card);
		char[] ca = card.toCharArray();
		switch (ca[0]) {
			case '2':
				this.rank = Rank.TWO;
				break;
			case '3':
				this.rank = Rank.THREE;
				break;
			case '4':
				this.rank = Rank.FOUR;
				break;
			case '5':
				this.rank = Rank.FIVE;
				break;
			case '6':
				this.rank = Rank.SIX;
				break;
			case '7':
				this.rank = Rank.SEVEN;
				break;
			case '8':
				this.rank = Rank.EIGHT;
				break;
			case '9':
				this.rank = Rank.NINE;
				break;
			case 'T':
				this.rank = Rank.TEN;
				break;
			case 'J':
				this.rank = Rank.JACK;
				break;
			case 'Q':
				this.rank = Rank.QUEEN;
				break;
			case 'K':
				this.rank = Rank.KING;
				break;
			case 'A':
				this.rank = Rank.ACE;
				break;
			default:
				throw new IllegalArgumentException("For input string: " + card);
		}
		switch (ca[1]) {
			case 'S':
				this.suit = Suit.SPADES;
				break;
			case 'H':
				this.suit = Suit.HEARTS;
				break;
			case 'D':
				this.suit = Suit.DIAMONDS;
				break;
			case 'C':
				this.suit = Suit.CLUBS;
				break;
			default:
				throw new IllegalArgumentException("For input string: " + card);
		}
	}
	
	public String toString() {
		return ""+this.rank.getChar()+this.suit.getChar();
	}
	
	public int compareTo(Card card) {
		int rankComp = this.rank.compareTo(card.getRank());
		if (rankComp == 0) {
			return (this.suit.compareTo(card.getSuit())*-1);
		} else {
			return rankComp;
		}
	}
	
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
}
