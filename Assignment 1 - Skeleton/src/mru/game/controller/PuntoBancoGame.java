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
			
		Card playerHand = cardDeck.getDeck().remove(0);
		Card playerHand2 = cardDeck.getDeck().remove(0);
		Card playerHand3 = cardDeck.getDeck().remove(0);
		
		Card bankerHand = cardDeck.getDeck().remove(0);
		Card bankerHand2 = cardDeck.getDeck().remove(0);
		Card bankerHand3 = cardDeck.getDeck().remove(0);
		
		playerScore = playerHand.getRank() + playerHand2.getRank();
		bankerScore = bankerHand.getRank() + bankerHand2.getRank();
			
		if (playerScore == 8 || playerScore == 9 || bankerScore == 8 || bankerScore == 9) {
			System.out.printf("%n               -PUNTO BANCO-            %n"
				    + "+====================+===================+%n"
				    + "|PLAYER              |BANKER             |%n"
				    + "+====================+===================+%n"
				    + "|%s                  |%s                 |%n"
				    + "+--------------------+-------------------+%n"
				    + "|%s                  |%s                 |%n"
				    + "+--------------------+-------------------+%n"
				    + "|                    |                   |%n"
				    + "+--------------------+-------------------+%n"
				    + "|PLAYER SCORE: %d    |BANKER SCORE: %d   |%n"
				    + "+====================+===================+%n", playerHand, bankerHand, playerHand2, bankerHand2, playerScore, bankerScore);
		}
		
		// we need a menu 
	

		if(playerScore > bankerScore && choice == playerBet) {
			hasWon = true;
			winMsg(betAmount);
			promptContinue();
			launchGame();
		} else if (playerScore > bankerScore && choice != playerBet) {
			hasWon = false;
			loseMsg(betAmount);
			promptContinue();
		} else if(playerScore < bankerScore && choice == bankerBet) {
			hasWon = true;
			winMsg(betAmount);
			promptContinue();
		} else if (playerScore < bankerScore && choice != bankerBet) {
			hasWon = false;
			loseMsg(betAmount);
			promptContinue();
		} else if (playerScore == bankerScore && choice == tie){
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
	
	
	public double getBet()
	{
		return betAmount;
	}
	
	private void winMsg(double betAmount) {
		System.out.print("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
				   	   + "$     YOU WIN "+betAmount+"!       $\n"
				   	   + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
	}
	
	private void loseMsg(double betAmount) {
		System.out.print("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
					    + "$     YOU LOSE "+betAmount+"!     $\n"
			   	        + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
	}
	//System.out.printf("|%s                 |%s                  |%n"
	        //+ "+-------------------+--------------------+%n",playerHand, bankerHand);
	public boolean promptContinue() throws FileNotFoundException {
		
		boolean play = false;
		
		System.out.print("\nDo you want to play again (Y/N)? ");
		char choice = input.next().toLowerCase().charAt(0);
		
		if (choice == 'y') {
			play = true;
		} else if (choice == 'n') {
			gm.showMainMenu();
		}
		return play;
	

	}
}
