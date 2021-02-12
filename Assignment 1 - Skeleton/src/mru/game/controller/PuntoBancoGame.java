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
	
	public boolean launchGame(double myBalance) throws FileNotFoundException 
	{
		
		char choice = appMenu.betMenu();
		balanceCheck(myBalance);
		boolean hasWon = false;
		
		switch (choice) {
	
		case 'p':
			dealCards();
			if (truePlayerScore(playerScore) > trueBankerScore(bankerScore)) {
				hasWon = true;
				winMsg(betAmount);
			} else {
				hasWon = false;
				loseMsg(betAmount);
			}
			break;
		case 'b':
			dealCards();
			if (truePlayerScore(playerScore) < trueBankerScore(bankerScore)) {
				hasWon = true;
				winMsg(betAmount);
			} else {
				hasWon = false;
				loseMsg(betAmount);
			}
			break;
		case 't':
			dealCards();
			if (truePlayerScore(playerScore) == trueBankerScore(bankerScore)) {
				hasWon = true;
				winMsg(betAmount * 5);
			} else {
				hasWon = false;
				loseMsg(betAmount);
			}
			break;
		default:
			System.out.print("\nError: Please try again.\n");
			launchGame(myBalance);
		} 
		// we need a menu 
	
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
		if (newPlayerHand.getRank() >= 10) {
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
		if (newBankerHand.getRank() >= 10) {
			newBankerHand.setRank(0);
			newBankerHand.toString();
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
		
		switch (choice) {
		case 'y':
			play = true;
			playerScore = 0;
			bankerScore = 0;
			if (cardDeck.getDeck().size() < 4) {
				CardDeck cardDeck = new CardDeck();
			}
			break;
		case 'n': 
			play = false;
			break;
		default:
			System.out.print("\nERROR: Invalid character entered.\n"
						   + "       Please try again.");
			promptContinue();
		}
		return play;
		
	}
	
	/**
	 * makes sure the betamount is less then the player balance
	 * @param ballance players ballance
	 * @return betAmount the amount the player wants to bett on
	 */
	public double balanceCheck (double balance)
	{
		betAmount = appMenu.placeBet();
		
		while(betAmount > balance || betAmount < 0)
		{
			System.out.println("the amount you entered is greater than your ballance of $" + balance);
			System.out.println("bett an amount thats within the range of your ballance");

			betAmount = appMenu.placeBet();

		}
		
		return betAmount;
	}
	public void dealCards() {
		System.out.printf("%n               W E L C O M E              %n"
						+ "                    T O                     %n"
						+ "         ---P U N T O B A N C O---          %n"
	    				+ "+====================+=====================+%n"
	    				+ "|     P L A Y E R    |     B A N K E R     |%n"
	    				+ "+====================+=====================+%n");
		
		playerHand = cardDeck.getDeck().remove(0);
		if (playerHand.getRank() >= 10) {
			playerScore += 0;
		} else {
			playerScore += playerHand.getRank();
		}
		bankerHand = cardDeck.getDeck().remove(0);
		if (bankerHand.getRank() >= 10) {
			bankerScore += 0;
		} else {
			bankerScore += bankerHand.getRank();
		}
		
		
		System.out.printf("|%-20s|%-21s|                               %n"
						+ "+--------------------+---------------------+%n", playerHand, bankerHand);
	
		playerHand = cardDeck.getDeck().remove(0);
		if (playerHand.getRank() >= 10) {
			playerScore += 0;
		} else {
			playerScore += playerHand.getRank();
		}
		bankerHand = cardDeck.getDeck().remove(0);
		if (bankerHand.getRank() >= 10) {
			bankerScore += 0;
		} else {
			bankerScore += bankerHand.getRank();
		}

		System.out.printf("|%-20s|%-21s|                               %n"
						+ "+--------------------+---------------------+%n", playerHand, bankerHand);
		
		playerScore = truePlayerScore(playerScore);
		bankerScore = trueBankerScore(bankerScore);
		
		playerHand = cardDeck.getDeck().remove(0);
		if (playerHand.getRank() >= 10) {
			playerScore += 0;
		}
		bankerHand = cardDeck.getDeck().remove(0);
		if (bankerHand.getRank() >= 10) {
			bankerScore += 0;
		}
		
		if (truePlayerScore(playerScore) == 8 || truePlayerScore(playerScore) == 9 || trueBankerScore(bankerScore) == 8 || trueBankerScore(bankerScore) == 9) {
			System.out.printf("|                    |                     |%n"
							+ "+--------------------+---------------------+%n");
		} else if ((truePlayerScore(playerScore) == 6 || truePlayerScore(playerScore) == 7) && (trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7)) {
			System.out.printf("|                    |                     |%n"
							+ "+--------------------+---------------------+%n");
		} else if ((truePlayerScore(playerScore) == 6 || truePlayerScore(playerScore) == 7) && (trueBankerScore(bankerScore) <= 5)) {
			bankerScore += bankerHand.getRank();
			System.out.printf("|                    |%-21s|               %n"
							+ "+--------------------+---------------------+%n", bankerHand);
		} else if ((truePlayerScore(playerScore) <= 5 && (playerHand.getRank() == 2 || playerHand.getRank() == 3)) && (trueBankerScore(bankerScore) <= 4)) {
			playerScore += playerHand.getRank();
			bankerScore += bankerHand.getRank();
			System.out.printf("|%-20s|%-21s|                              %n"
							+ "+--------------------+---------------------+%n", playerHand, bankerHand);
		} else if ((truePlayerScore(playerScore) <= 5 && playerHand.getRank() == 2 || playerHand.getRank() == 3) && (trueBankerScore(bankerScore) == 5 || trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7)) {
			playerScore += playerScore + playerHand.getRank();
			System.out.printf("|%-20s|                     |               %n"
							+ "+--------------------+---------------------+%n", playerHand);
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 4 || playerHand.getRank() == 5) && (trueBankerScore(bankerScore) <= 5)) {
			playerScore += playerHand.getRank();
			bankerScore += bankerHand.getRank();
			System.out.printf("|%-20s|%-21s|                               %n"
							+ "+--------------------+---------------------+%n", playerHand, bankerHand);
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 4 || playerHand.getRank() == 5) && (trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7)) {
			playerScore += playerHand.getRank();
			System.out.printf("|%-20s|                     |               %n"
							+ "+--------------------+---------------------+%n", playerHand);
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 8) && (trueBankerScore(bankerScore) <= 2)) {
			playerScore += playerHand.getRank();
			bankerScore += bankerHand.getRank();
			System.out.printf("|%-20s|%-21s|                               %n"
							+ "+--------------------+---------------------+%n", playerHand, bankerHand);
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 8) && (trueBankerScore(bankerScore) == 3 || trueBankerScore(bankerScore) == 4 || trueBankerScore(bankerScore) == 5 || trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7 )) {
			playerScore += playerHand.getRank();
			System.out.printf("|%-20s|                     |               %n"
							+ "+--------------------+---------------------+%n", playerHand);
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 1 || playerHand.getRank() == 9 || playerHand.getRank() == 10 || playerHand.getRank() == 11 || playerHand.getRank() == 12 || playerHand.getRank() == 13) && (trueBankerScore(bankerScore) <= 3)) {
			playerScore += playerHand.getRank();
			bankerScore += bankerHand.getRank();
			System.out.printf("|%-20s|%-21s|                               %n"
							+ "+--------------------+---------------------+%n", playerHand, bankerHand);
		} else if ((truePlayerScore(playerScore) <= 5) && (playerHand.getRank() == 1 || playerHand.getRank() == 9 || playerHand.getRank() == 10 || playerHand.getRank() == 11 || playerHand.getRank() == 12 || playerHand.getRank() == 13) && (trueBankerScore(bankerScore) == 4 || trueBankerScore(bankerScore) == 5 || trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7)) {
			playerScore += playerHand.getRank();
			System.out.printf("|%-20s|                     |               %n"
							+ "+--------------------+---------------------+%n", playerHand);
		}
		System.out.printf("|PLAYER SCORE: %2d    |BANKER SCORE: %-6d |  %n" 
				+ "+====================+=====================+%n", truePlayerScore(playerScore), trueBankerScore(bankerScore));
	}
}
