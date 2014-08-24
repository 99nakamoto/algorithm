package v4cc150.chap7;

import java.util.List;

public class Q7_1 {

	// Design a Generic Deck of Cards

	enum Suit {
		HEART, DIAMOND, SPADES, CLUBS;
	}

	class Deck<T extends Card> {
		List<Card> deck;

		public void shuffle() {
		};
	}

	abstract class Card {
		boolean available;
		Suit suit;
		int num;

		public boolean isAvailable() {
			return available;
		};
	}

	class Hand<T extends Card> {
		List<Card> cards;

		public int score() {
			int score = 0;
			for (Card c : cards) {
				score += c.num;
			}
			return score;
		}

		public void addCard(T card) {
			cards.add(card);
		}
	}

	// Now use the above generic Data Structure to make a
	// Blackjack Game
	public class Blackjack extends Hand<BlackJackCard> {
	}

	class BlackJackCard extends Card {
	}
}