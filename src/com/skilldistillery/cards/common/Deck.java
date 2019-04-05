package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skilldistillery.enums.solutions.cards.Card;

public class Deck {
	private List<Card> cards = new ArrayList<>(52);

	private List<Card> Deck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card c = new Card(rank, suit);
				cards.add(c);
			}
		}
	}
	
	public void dealCard() {
		cards.remove(0);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
}
