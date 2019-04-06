package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards = new ArrayList<>();

	public Deck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card c = new Card(rank, suit);
				cards.add(c);
			}
		}System.out.println(cards.size());
	}
	
	public Card dealCard() {
		return cards.remove(0);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	public int checkDeckSize() {
		int local; 
		local = cards.size();
		System.out.println(local);
		return local; 
	}
}
