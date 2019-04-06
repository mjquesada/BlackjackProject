package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	private List<Card> cards = new ArrayList<>();
	

	public Hand() {

	}

	public int getHandValue() {
		int value = 0;
		
		for (Card card : cards) {
			value += card.getValue();
		}
		return value;
	}
	
	public int checkNumberOfCardsInHand() {
		int local; 
		local = cards.size();
		System.out.println(local);
		return local;
	}

	public void addCard(Card card) {
		cards.add(card);
		
	}

	public void clearHand() {
		cards = new ArrayList<>();
	}

	public List<Card> getCards() {
		return cards;
		
	}

	@Override
	public String toString() {
		return "Hand [card=" + cards + "]";
	}

}
