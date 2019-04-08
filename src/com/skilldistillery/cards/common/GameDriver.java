package com.skilldistillery.cards.common;

import java.util.Scanner;

public class GameDriver {
	Scanner kb = new Scanner(System.in);
	Player player = new Player();
	Dealer dealer = new Dealer();
	boolean goAgain;
	int pWin = 0;
	int dWin = 0;
	int tie = 0;

	public GameDriver() {

	}

	public void launchGame() {

		System.out.println("Let's play blackjack!");
		kb.nextLine();
		System.out.println("The dealer will shuffle then deal the cards");
		kb.nextLine();

		do {
			player.getHand().clearHand();
			dealer.getHand().clearHand();
			deal();

			if (player.getHand().getHandValue() == 21 || dealer.getHand().getHandValue() == 21) {
				checkWin();
				
			} else {
				System.out.println();
				goAgain = playerTurn();
				if (goAgain) {
					dealerTurn();
				}
			}
			System.out.println();
			System.out.println("Scorecard");
			System.out.println("Player wins: " + pWin);
			System.out.println("Dealer wins: " + dWin);
			System.out.println("Ties: " + tie);
			System.out.println();

		} while (playAgain());
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

	public boolean playerTurn() {
		int hitOrStand = 1;
		int handValue = 0;
		String round2;

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
					dWin++;
					return false;
				}
			} else {
				System.out.println("Dealers turn");
				return true;
			}
		}
		return true;
	}

	public void dealerTurn() {
		int toWin = 0;

		toWin = dealer.getHand().getHandValue();

		dealer.showCardsInHand();
		while (toWin < 17) {
			Card card = dealer.dealCard();
			System.out.println("Dealer took a(n) " + card);
			toWin = dealer.addCardToHand(card);
			if (toWin > 21) {
				System.out.println("The dealer has more than 21");
				System.out.println("You won this round");
				pWin++;
			}
		}
		if (toWin <= 21) {
			checkWin();
		}
	}

	public boolean playAgain() {
		String round2;

		System.out.println("Would you like to play again?(y or n)");
		round2 = kb.next();
		if (round2.toUpperCase().contains("Y")) {
			return true;
		} else {
			System.out.println("Goodbye");
			return false;
		}

	}

	public void checkWin() {

		if (player.getHand().getHandValue() > dealer.getHand().getHandValue()) {
			System.out.println("You won!");
			pWin++;
		} else if (player.getHand().getHandValue() < dealer.getHand().getHandValue()) {
			System.out.println("The dealer won this round.");
			dWin++;
		} else {
			System.out.println("You tied this round.");
			tie++;
		}
	}

}
