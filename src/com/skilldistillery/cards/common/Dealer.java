package com.skilldistillery.cards.common;

public class Dealer extends PlayerBase {
	private Deck deck = new Deck();
	
	public Dealer() {
		
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}
	
	public void showFaceCard() {
		System.out.println("XXXX of XXXX");
		System.out.println(getHand().getCards().get(1));
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	
}
