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
	GameManager gm;
	Scanner input;
	Card playerHand;
	Card bankerHand;
	
	private int playerScore;
	private int bankerScore;
	private double betAmount;
	
	
	public PuntoBancoGame() 
	{
		 cardDeck = new CardDeck();
		 rdm = new Random();
		 appMenu = new AppMenu();
		 player = new Player();
		 input = new Scanner(System.in);
		 
	}
	
	public boolean launchGame() throws FileNotFoundException 
	{
		
		// players betting option
		char choice = appMenu.betMenu();
		char playerBet = 'p';
		char bankerBet = 'b';
		char tie = 't';
		betAmount = appMenu.placeBet();
		
		boolean hasWon = false;
		
		
		System.out.printf("%n               -PUNTO BANCO-            %n"
			    		+ "+====================+===================+%n"
			    		+ "|PLAYER              |BANKER             |%n"
			    		+ "+====================+===================+%n");
		{
			playerHand = cardDeck.getDeck().remove(0);
			bankerHand = cardDeck.getDeck().remove(0);
			
			
			playerScore = playerHand.getRank() + playerHand.getRank(); 
			bankerScore = bankerHand.getRank() + bankerHand.getRank();
			
			
			for (int i = 1; i <= 2; i ++) {
				System.out.printf("|%s                  |%s                 |%n"
								+ "+--------------------+-------------------+%n", playerHand, bankerHand);
			}
			if (truePlayerScore(playerScore) == 8 || truePlayerScore(playerScore) == 9 || trueBankerScore(bankerScore) == 8 || trueBankerScore(bankerScore) == 9) {
				
				System.out.printf("|                    |                   |%n"
								+ "+--------------------+-------------------+%n"
								+ "|PLAYER SCORE: %d    |BANKER SCORE: %d   |%n" 
								+ "+====================+===================+%n", truePlayerScore(playerScore), trueBankerScore(bankerScore));
			} else if (truePlayerScore(playerScore) <= 5) {
				playerScore = playerScore + playerHand.getRank(); 
				bankerScore = bankerScore + bankerHand.getRank();
				System.out.printf("|%s                  |%s                 |%n"
								+ "+--------------------+-------------------+%n"
								+ "|PLAYER SCORE: %d    |BANKER SCORE: %d   |%n" 
								+ "+====================+===================+%n", playerHand, bankerHand, truePlayerScore(playerScore), trueBankerScore(bankerScore));
			} else if (truePlayerScore(playerScore) == 6 || truePlayerScore(playerScore) == 7 && trueBankerScore(bankerScore) <= 5) {
				playerScore = playerHand.getRank() + playerHand.getRank();
				bankerScore = bankerScore + bankerHand.getRank();
				System.out.printf("|                    |%s                 |%n"
								+ "+--------------------+-------------------+%n"
								+ "|PLAYER SCORE: %d    |BANKER SCORE: %d   |%n" 
								+ "+====================+===================+%n", bankerHand, truePlayerScore(playerScore), trueBankerScore(bankerScore));
			} else if (truePlayerScore(playerScore) == 6 || truePlayerScore(playerScore) == 7 && trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7) {
				System.out.printf("|                    |                   |%n"
								+ "+--------------------+-------------------+%n"
								+ "|PLAYER SCORE: %d    |BANKER SCORE: %d   |%n" 
								+ "+====================+===================+%n", truePlayerScore(playerScore), trueBankerScore(bankerScore));
			}
		}
		
		
		// we need a menu 
	

		if(truePlayerScore(playerScore) > trueBankerScore(bankerScore) && choice == playerBet) {
			hasWon = true;
			winMsg(betAmount);
			promptContinue();
		} else if (truePlayerScore(playerScore) > trueBankerScore(bankerScore) && choice != playerBet) {
			hasWon = false;
			loseMsg(betAmount);
			promptContinue();
		} else if(truePlayerScore(playerScore) < trueBankerScore(bankerScore) && choice == bankerBet) {
			hasWon = true;
			winMsg(betAmount);
			promptContinue();
		} else if (truePlayerScore(playerScore) < trueBankerScore(bankerScore) && choice != bankerBet) {
			hasWon = false;
			loseMsg(betAmount);
			promptContinue();
		} else if (truePlayerScore(playerScore) == trueBankerScore(bankerScore) && choice == tie){
			hasWon = true;
			winMsg(betAmount * 5);
			promptContinue();
		} else {
			hasWon = false;
			loseMsg(betAmount);
			promptContinue();
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
		System.out.print("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
				   	   + "$     YOU WIN "+betAmount+"!       $\n"
				   	   + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
	}
	/**
	 * Displays a losing message if the gambler bets incorrectly.
	 * @param betAmount
	 */
	private void loseMsg(double betAmount) {
		System.out.print("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
					    + "$     YOU LOSE "+betAmount+"!     $\n"
			   	        + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
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
	 * Asks the player whether they wants to continue playing the game.
	 */
	public boolean promptContinue() throws FileNotFoundException {
		
		boolean play = false;
		
		System.out.print("\nDo you want to play again (Y/N)? ");
		char choice = input.next().toLowerCase().charAt(0);
		
		if (choice == 'y') {
			play = true;
			launchGame();
		} else if (choice == 'n') {
			play = false;
			gm.showMainMenu();
		}
		return play;
	}
	
	
}
