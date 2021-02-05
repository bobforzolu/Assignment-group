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
	
	private double bettAmount;
	
	
	public double getBett()
	{
		return bettAmount;
	}
	
	public PuntoBancoGame() 
	{
		 cardDeck = new CardDeck();
		 rdm = new Random();
		 appMenu = new AppMenu();
		 
		 player = new Player();
		 
	}
	
	public boolean launchGame() 
	{
		// score
		int playerScore = 0;
		int brokerScore = 0;
		int tieScore = 0;
		
		// players betting option
		char choice = appMenu.betMenu();
		char playerBet = 'p';
		char brokerBet = 'b';
		char tie = 't';
		bettAmount = appMenu.placeBet();
		
		boolean hasWon = false;
			
		for(int i=0; i<=2; i++)
		{
			
			int playercard = rdm.nextInt(12) +1;
			int bankercard = rdm.nextInt(12) +1;
			
			
			Card playerHand = cardDeck.getDeck().get(playercard);
			Card bankerHand = cardDeck.getDeck().get(bankercard);
			
			// we need a menu 
			System.out.println(bankerHand);
			System.out.println(playerHand);
	
			if(playerHand.getRank() > bankerHand.getRank())
			{
				playerScore++;
				System.out.println("player: " + playerScore);

				if(playerScore == 2)	
				{
					if(choice == playerBet)
					{
						hasWon = true;
					}
					break;
				}
			}else if(playerHand.getRank() < bankerHand.getRank())
			{
				brokerScore++;
				System.out.println("broker: "+brokerScore);

				if(brokerScore == 2)
				{
					if(choice == brokerBet)
					{	
						hasWon = true;
					}
					break;
				}
			}else {
				tieScore ++;
				if(playerScore == 1 && tieScore == 1 && brokerScore == 1)
				{
					if(choice == tie)
					{	
						hasWon = true;
					}
					
				}
			}
		}
		return hasWon;
	}
	
	

}
