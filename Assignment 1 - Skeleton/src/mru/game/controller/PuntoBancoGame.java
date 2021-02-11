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
		
		
		
		System.out.printf("%n               -PUNTO BANCO-            %n"
			    		+ "+====================+===================+%n"
			    		+ "|PLAYER              |BANKER             |%n"
			    		+ "+====================+===================+%n");
	
		
			
		// needs work still
		/*
		for (int i = 1; i <= 2; i++) {
			
			playerHand = cardDeck.getDeck().remove(0);
			bankerHand = cardDeck.getDeck().remove(0);
			playerScore = playerHand.getRank() + playerHand.getRank();
			bankerScore = bankerHand.getRank() + playerHand.getRank();
			
			System.out.printf("|%s                  |%s                 |%n"
							+ "+--------------------+-------------------+%n", playerToZero(playerHand), bankerToZero(bankerHand));
			
			if (truePlayerScore(playerScore) == 8 || truePlayerScore(playerScore) == 9 || trueBankerScore(bankerScore) == 8 || trueBankerScore(bankerScore) == 9) {
				playerScore = playerHand.getRank() + playerHand.getRank();
				bankerScore = bankerHand.getRank() + bankerHand.getRank();
				System.out.printf("|                    |                   |%n"
								+ "+--------------------+-------------------+%n");	
				System.out.printf("|PLAYER SCORE: %d    |BANKER SCORE: %d   |%n" 
								+ "+====================+===================+%n", truePlayerScore(playerScore), trueBankerScore(bankerScore));
				break;
			} else if (truePlayerScore(playerScore) == 6 || truePlayerScore(playerScore) == 7 && trueBankerScore(bankerScore) <= 5) {
				for (int j = 0; j <= 1; i++) {
					playerScore = playerScore + playerHand.getRank();
					bankerScore = bankerScore + playerHand.getRank();
					System.out.printf("|                    |%s                 |%n"
									+ "+--------------------+-------------------+%n", bankerToZero(bankerHand));	
				}
				break;
			} else if (playerHand.getRank() == 2 || playerHand.getRank() == 3 && trueBankerScore(bankerScore) <= 4) {
				for (int j = 0; j <= 1; i++) {
					playerScore = playerScore + playerHand.getRank();
					bankerScore = bankerScore + playerHand.getRank();
					System.out.printf("|%s                  |%s                 |%n"
									+ "+--------------------+-------------------+%n", playerToZero(playerHand), bankerToZero(bankerHand));
				}
				break;
			}
		}
		*/

		
			
		
			if (truePlayerScore(playerScore) == 8 || truePlayerScore(playerScore) == 9 || trueBankerScore(bankerScore) == 8 || trueBankerScore(bankerScore) == 9) {
				for (int i = 0; i <= 1; i ++) {
					playerHand = cardDeck.getDeck().remove(0);
					bankerHand = cardDeck.getDeck().remove(0);
					playerScore = playerHand.getRank() + playerHand.getRank();
					bankerScore = bankerHand.getRank() + bankerHand.getRank();
					
					System.out.printf("|%s                  |%s                 |%n"
									+ "+--------------------+-------------------+%n", playerToZero(playerHand), bankerToZero(bankerHand));
				}
				
					System.out.printf("|                    |                   |%n"
									+ "+--------------------+-------------------+%n");	
					System.out.printf("|PLAYER SCORE: %d    |BANKER SCORE: %d   |%n" 
									+ "+====================+===================+%n", truePlayerScore(playerScore), trueBankerScore(bankerScore));					
			} else if (truePlayerScore(playerScore) <= 5) {
				for (int i = 0; i <= 2; i++) {
					playerHand = cardDeck.getDeck().remove(0);
					bankerHand = cardDeck.getDeck().remove(0);
					playerScore = playerScore + playerHand.getRank();
					bankerScore = bankerScore + bankerHand.getRank();
					
					System.out.printf("|%s                  |%s                 |%n"
									+ "+--------------------+-------------------+%n", playerToZero(playerHand), bankerToZero(bankerHand));
				}
					System.out.printf("|PLAYER SCORE: %d    |BANKER SCORE: %d   |%n" 
									+ "+====================+===================+%n", truePlayerScore(playerScore), trueBankerScore(bankerScore));
			} else if (truePlayerScore(playerScore) == 6 || truePlayerScore(playerScore) == 7 && trueBankerScore(bankerScore) <= 5) {
				for (int i = 0; i <= 2; i++) {
					playerHand = cardDeck.getDeck().remove(0);
					bankerHand = cardDeck.getDeck().remove(0);
					playerScore = playerScore + playerHand.getRank();
					bankerScore = bankerScore + bankerHand.getRank();

					System.out.printf("|                    |%s                 |%n"
									+ "+--------------------+-------------------+%n", playerToZero(playerHand), bankerToZero(bankerHand));
				}
					System.out.printf("|PLAYER SCORE: %d    |BANKER SCORE: %d   |%n" 
									+ "+====================+===================+%n", truePlayerScore(playerScore), trueBankerScore(bankerScore));
			} else if (truePlayerScore(playerScore) == 6 || truePlayerScore(playerScore) == 7 && trueBankerScore(bankerScore) == 6 || trueBankerScore(bankerScore) == 7) {
					for (int i = 0; i <= 1; i++) {
						playerHand = cardDeck.getDeck().remove(0);
						bankerHand = cardDeck.getDeck().remove(0);
						playerScore = playerScore + playerHand.getRank();
						bankerScore = bankerScore + bankerHand.getRank();
					System.out.printf("|                    |                   |%n"
									+ "+--------------------+-------------------+%n", playerToZero(playerHand), bankerToZero(bankerHand));
				}
					System.out.printf("|PLAYER SCORE: %d    |BANKER SCORE: %d   |%n" 
									+ "+====================+===================+%n", truePlayerScore(playerScore), trueBankerScore(bankerScore));
			}else if(truePlayerScore(playerScore) == 2|| trueBankerScore(bankerScore) == 3 &&  trueBankerScore(bankerScore) <= 4 ) {
				
			}else if(truePlayerScore(playerScore) == 2|| trueBankerScore(bankerScore) == 3 &&  trueBankerScore(bankerScore) == 5 && trueBankerScore(bankerScore) == 6 && trueBankerScore(bankerScore) == 7){
			
			}else if(truePlayerScore(playerScore) == 4|| trueBankerScore(bankerScore) == 5 &&  trueBankerScore(bankerScore) <= 5){
				
			}else if(truePlayerScore(playerScore) == 4|| trueBankerScore(bankerScore) == 5 &&  trueBankerScore(bankerScore) == 6 &  trueBankerScore(bankerScore) == 7){
				
			}else if(truePlayerScore(playerScore) == 6|| trueBankerScore(bankerScore) == 7 &&  trueBankerScore(bankerScore) <= 6){
				
			}else if(truePlayerScore(playerScore) == 6|| trueBankerScore(bankerScore) == 7 &&   trueBankerScore(bankerScore) == 7){
				
			}else if(truePlayerScore(playerScore) == 8 &&   trueBankerScore(bankerScore) <= 2){
				
			}else if(truePlayerScore(playerScore) == 8 &&   trueBankerScore(bankerScore) >= 3 && trueBankerScore(bankerScore) <=7){
				
			}else if(truePlayerScore(playerScore) == 9|| trueBankerScore(bankerScore) == 10 || trueBankerScore(bankerScore) == 0 &&   trueBankerScore(bankerScore) <= 3){
				
			}else if(truePlayerScore(playerScore) == 9|| trueBankerScore(bankerScore) == 10 || trueBankerScore(bankerScore) == 0 &&   trueBankerScore(bankerScore) >= 4 &&   trueBankerScore(bankerScore) <= 7){
				
			}
			
		
		
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
			System.out.print(cardDeck.getDeck().size());
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
	
	
}
