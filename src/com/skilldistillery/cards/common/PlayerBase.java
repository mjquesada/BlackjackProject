package com.skilldistillery.cards.common;

public abstract class PlayerBase {
	private BlackJackHand hand = new BlackJackHand();
	
	public PlayerBase() {
		
	}
	
	public int addCardToHand(Card card) {
		hand.addCard(card);
		return hand.getHandValue();
	}
	
	public void showCardsInHand() {
		for (Card card : hand.getCards()) {
			System.out.println(card);
		}
	}

	public BlackJackHand getHand() {
		return hand;
	}

	public void setHand(BlackJackHand hand) {
		this.hand = hand;
	}
	
	

}
