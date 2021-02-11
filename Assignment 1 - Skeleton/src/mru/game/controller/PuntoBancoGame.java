package mru.game.controller;
import mru.game.view.*;

import java.io.FileNotFoundException;

import mru.game.model.*;
import java.util.*;


public class PuntoBancoGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */
	CardDeck cardDeck;
	Random rdm;
	AppMenu appMenu;
	Player player;
	Scanner input;
	Card playerHand;
	Card bankerHand;

	
	private int playerScore = 0;
	private int bankerScore = 0;
	private double betAmount;
	
	
	public PuntoBancoGame() throws FileNotFoundException 
	{
		 cardDeck = new CardDeck();
		 rdm = new Random();
		 appMenu = new AppMenu();
		 player = new Player();
		 input = new Scanner(System.in);
		 
	}
	
	public boolean launchGame(double myBallance) throws FileNotFoundException 
	{
		
		// players betting option
		char choice = appMenu.betMenu();
		char playerBet = 'p';
		char bankerBet = 'b';
		char tie = 't';
		ballanceCheck(myBallance);
		boolean hasWon = false;
		

		
		/*
		playerHand = cardDeck.getDeck().remove(0);
		playerScore += playerHand.getRank();
		
		System.out.println(playerHand);
		
		playerHand = cardDeck.getDeck().remove(0);
		playerScore = playerScore + playerHand.getRank();
		
		System.out.println(playerHand);
		
		System.out.println(truePlayerScore(playerScore));
		*/
		
		
		dealCards();

			
	
		System.out.printf("|PLAYER SCORE: %2d    |BANKER SCORE: %-6d |  %n" 
						+ "+====================+=====================+%n", truePlayerScore(playerScore), trueBankerScore(bankerScore));
		
		
		
		// we need a menu 
	

		if(truePlayerScore(playerScore) > trueBankerScore(bankerScore) && choice == playerBet) {
			hasWon = true;
			winMsg(betAmount);
		
		} else if (truePlayerScore(playerScore) > trueBankerScore(bankerScore) && choice != playerBet) {
			hasWon = false;
			loseMsg(betAmount);
	
		} else if(truePlayerScore(playerScore) < trueBankerScore(bankerScore) && choice == bankerBet) {
			hasWon = true;
			winMsg(betAmount);
			
		} else if (truePlayerScore(playerScore) < trueBankerScore(bankerScore) && choice != bankerBet) {
			hasWon = false;
			loseMsg(betAmount);
			
		} else if (truePlayerScore(playerScore) == trueBankerScore(bankerScore) && choice == tie){
			hasWon = true;
			winMsg(betAmount * 5);
			
		} else {
			hasWon = false;
			loseMsg(betAmount);
			
			
	}
		return hasWon;
	}
	/**
	 * Gets the gambler's bet.
	 * @return Gamblers bet amount.
	 */
	public double getBet()
	{
		return betAmount;
	}
	/**
	 * Displays a winning message if the gambler bets correctly.
	 * @param betAmount
	 */
	private void winMsg(double betAmount) {
		System.out.printf("%n  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$%n"
				   	    + "  $          YOU WIN!! + $%-14.2f$          %n"
				   	    + "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$%n", betAmount);
	}
	/**
	 * Displays a losing message if the gambler bets incorrectly.
	 * @param betAmount
	 */
	private void loseMsg(double betAmount) {
		System.out.printf("%n  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$%n"
					    + "  $          YOU LOSE!! - $%-14.2f$          %n"
			   	        + "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$%n", betAmount);
	}
	/**
	 * Sums the players score to modulo 10.
	 * @param newPlayerScore
	 * @return Players score in modulo 10.
	 */
	private int truePlayerScore(int newPlayerScore) {
		playerScore = newPlayerScore;
		if (newPlayerScore >= 10) {
			newPlayerScore = newPlayerScore - 10;
			return newPlayerScore;
		} else {
			return newPlayerScore;
		}
	}
	/**
	 * Sums the bankers score to modulo 10. 
	 * @param newBankerScore
	 * @return Bankers score in modulo 10.
	 */
	private int trueBankerScore(int newBankerScore) {
		bankerScore = newBankerScore;
		if (newBankerScore >= 10) {
			newBankerScore = newBankerScore - 10;
			return newBankerScore;
		} else {
			return newBankerScore;
		}
	}
	/**
	 * Sets players face cards and 10 cards to zero.
	 * @param newPlayerHand
	 * @return
	 */
	
	private Card playerToZero(Card newPlayerHand) {
		playerHand = newPlayerHand;
		if (newPlayerHand.getRank() == 10) {
			newPlayerHand.setRank(0);
			return newPlayerHand;
		} else {
			return playerHand;
		}
	}
	/**
	 * Sets bankers face cards and 10 cards to zero.
	 * @param newBankerHand
	 * @return 
	 */
	
	private Card bankerToZero(Card newBankerHand) {
		bankerHand = newBankerHand;
		if (newBankerHand.toString() == "Jack of " || newBankerHand.toString() == "Queen of " || newBankerHand.toString() == "King of ") {
			newBankerHand.setRank(0);
			return newBankerHand;
		} else {
			return bankerHand;
		}
	}
	
	/**
	 * Asks the player whether they wants to continue playing the game.
	 */
	public boolean promptContinue() throws FileNotFoundException {
		
		boolean play = false;
		
		System.out.print("\nDo you want to play again (Y/N)? ");
		
		char choice = input.nextLine().toLowerCase().charAt(0);
		
		if (choice == 'y') {
			play = true;
		} else {
			play = false;
		}
		return play;
	}
	
	/**
	 * makes sure the betamount is less then the player balance
	 * @param ballance players ballance
	 * @return betAmount the amount the player wants to bett on
	 */
	public double ballanceCheck (double ballance)
	{
		betAmount = appMenu.placeBet();
		
		while(betAmount > ballance || betAmount < 0)
		{
			System.out.println("the amount you entered is greater than your ballance of $" + ballance);
			System.out.println("bett an amount thats within the range of your ballance");

			betAmount = appMenu.placeBet();

		}
		
		return betAmount;
	}
	private void dealCards() {
		System.out.printf("%n               W E L C O M E              %n"
						+ "                    T O                     %n"
						+ "         ---P U N T O B A N C O---          %n"
	    				+ "+====================+=====================+%n"
	    				+ "|     P L A Y E R    |     B A N K E R     |%n"
	    				+ "+====================+=====================+%n");
		
		playerHand = cardDeck.getDeck().remove(0);
		bankerHand = cardDeck.getDeck().remove(0);
		
		playerScore += playerHand.getRank();
		bankerScore += bankerHand.getRank();
		
		System.out.printf("|%-20s|%-21s|                               %n"
						+ "+--------------------+---------------------+%n", playerHand, bankerHand);
	
		playerHand = cardDeck.getDeck().remove(0);
		bankerHand = cardDeck.getDeck().remove(0);
		
		playerScore = playerScore + playerHand.getRank();
		bankerScore = bankerScore + bankerHand.getRank();

		System.out.printf("|%-20s|%-21s|                               %n"
						+ "+--------------------+---------------------+%n", playerHand, bankerHand);
		
		playerScore = truePlayerScore(playerScore);
		bankerScore = trueBankerScore(bankerScore);
		
		playerHand = cardDeck.getDeck().remove(0);
		bankerHand = cardDeck.getDeck().remove(0);
		if (truePlayerScore(playerScore) == 8 || truePlayerScore(playerScore) == 9 || trueBankerScore(bankerScore) == 8 || trueBankerScore(bankerScore) == 9) {
			System.out.printf("|                    |                     |%n"
							+ "+--------------------+---------------------+%n");
		} else if ((truePlayerScore(playerScore) == 6 || truePlayerScore(playerScore) == 7) && (trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7)) {
			System.out.printf("|                    |                     |%n"
							+ "+--------------------+---------------------+%n");
		} else if ((truePlayerScore(playerScore) == 6 || truePlayerScore(playerScore) == 7) && (trueBankerScore(bankerScore) <= 5)) {
			
			bankerScore += bankerHand.getRank();
			System.out.printf("|                    |%-21s|               %n"
							+ "+--------------------+---------------------+%n", bankerToZero(bankerHand));
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 2 || playerHand.getRank() == 3) && (trueBankerScore(bankerScore) <= 4)) {
			playerScore += playerHand.getRank();
			bankerScore += bankerHand.getRank();
			System.out.printf("|%-20s|%-21s|                              %n"
							+ "+--------------------+---------------------+%n", playerToZero(playerHand), bankerToZero(bankerHand));
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 2 || playerHand.getRank() == 3) && (trueBankerScore(bankerScore) == 5 || trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7)) {
			playerScore += playerScore + playerHand.getRank();
			System.out.printf("|%-20s|                     |               %n"
							+ "+--------------------+---------------------+%n", playerToZero(playerHand));
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 4 || playerHand.getRank() == 5) && (trueBankerScore(bankerScore) <= 5)) {
			playerScore += playerHand.getRank();
			bankerScore += bankerHand.getRank();
			System.out.printf("|%-20s|%-21s|                               %n"
							+ "+--------------------+---------------------+%n", playerToZero(playerHand), bankerToZero(bankerHand));
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 4 || playerHand.getRank() == 5) && (trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7)) {
			playerScore += playerHand.getRank();
			System.out.printf("|%-20s|                     |               %n"
							+ "+--------------------+---------------------+%n", playerToZero(playerHand));
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 8) && (trueBankerScore(bankerScore) <= 2)) {
			playerScore += playerHand.getRank();
			bankerScore += bankerHand.getRank();
			System.out.printf("|%-20s|%-21s|                               %n"
							+ "+--------------------+---------------------+%n", playerToZero(playerHand), bankerToZero(bankerHand));
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 8) && (trueBankerScore(bankerScore) == 3 || trueBankerScore(bankerScore) == 4 || trueBankerScore(bankerScore) == 5 || trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7 )) {
			playerScore += playerHand.getRank();
			System.out.printf("|%-20s|                     |               %n"
							+ "+--------------------+---------------------+%n", playerToZero(playerHand));
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 1 || playerHand.getRank() == 9 || playerHand.getRank() == 10 || playerHand.getRank() == 11 || playerHand.getRank() == 12 || playerHand.getRank() == 13) && (trueBankerScore(bankerScore) <= 3)) {
			playerScore += playerHand.getRank();
			bankerScore += bankerHand.getRank();
			System.out.printf("|%-20s|%-21s|                               %n"
							+ "+--------------------+---------------------+%n", playerToZero(playerHand), bankerToZero(bankerHand));
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 1 || playerHand.getRank() == 9 || playerHand.getRank() == 10 || playerHand.getRank() == 11 || playerHand.getRank() == 12 || playerHand.getRank() == 13) && (trueBankerScore(bankerScore) == 4 || trueBankerScore(bankerScore) == 5 || trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7)) {
			playerScore += playerHand.getRank();
			System.out.printf("|%-20s|                     |               %n"
							+ "+--------------------+---------------------+%n", playerToZero(playerHand));
		}
	}
}
