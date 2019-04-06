package com.skilldistillery.cards.common;

import java.util.Scanner;

public class GameDriver {
	Scanner kb = new Scanner(System.in);
	Player player = new Player();
	Dealer dealer = new Dealer();
	boolean goAgain = false;

	public GameDriver() {

	}

	public void launchGame() {

		System.out.println("Let's play blackjack!");
		kb.nextLine();
		System.out.println("The dealer will shuffle then deal the cards");
		kb.nextLine();
		deal();
		
		while (goAgain) {
		playerTurn();
		dealerTurn();
		
		}
	}

	public void deal() {
		
		dealer.getDeck().shuffleDeck();

		player.addCardToHand(dealer.dealCard());
		dealer.addCardToHand(dealer.dealCard());
		player.addCardToHand(dealer.dealCard());
		dealer.addCardToHand(dealer.dealCard());

		System.out.println("Your cards are:");
		player.showCardsInHand();
		System.out.println();
		System.out.println("The dealers cards are: ");
		dealer.showFaceCard();
		System.out.println();

	}

	public void playerTurn() {
		int hitOrStand = 1;
		int handValue = 0;

		while (handValue <= 21 && hitOrStand == 1) {
			System.out.println("Would you like to: ");
			System.out.println("1. Hit (Take another card)");
			System.out.println("2. Stand (Don't take another card");
			hitOrStand = kb.nextInt();

			if (hitOrStand == 1) {
				handValue = player.addCardToHand(dealer.dealCard());
				System.out.println("Your cards are:");
				player.showCardsInHand();
				if (handValue > 21) {
					System.out.println("Sorry, you lose");
					System.out.println("Would you like to play again?(y or n)");
					goAgain = kb.nextBoolean();
					
					
					System.exit(0);
				}

			} else {
				System.out.println("Dealers turn");
			}
		}
	}

	public void dealerTurn() {
		int toWin = 0;

		toWin = dealer.getHand().getHandValue();

		while (toWin < 17) {
			toWin = dealer.addCardToHand(dealer.dealCard());
			if (toWin > 21) {
				System.out.println("The dealer has more than 21");
				System.out.println("You won this round");
				System.exit(0);
			}
		}

	}

}
